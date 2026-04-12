package com.grownited.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.config.PaymentGatewayConfig;
import com.grownited.entity.PaymentEntity;
import com.grownited.entity.PayrollEntity;
import com.grownited.repository.PaymentRepository;
import com.grownited.repository.PayrollRepository;

import net.authorize.Environment;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.CustomerDataType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.contract.v1.TransactionTypeEnum;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase;

@Service
public class PaymentService {

	private final PaymentGatewayConfig config;

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private PayrollRepository payrollRepo;

	public PaymentService(PaymentGatewayConfig config) {
		this.config = config;
	}

	public ANetApiResponse chargeCreditCard(String email, String creditCardNum, String expiredDate, BigDecimal amount,
			Long payrollId) {

		System.out.println("Transaction Key: " + config.getTransactionKey());
		System.out.println("Length: " + config.getTransactionKey().length());
		
		PayrollEntity payroll = payrollRepo.findById(payrollId)
				.orElseThrow(() -> new RuntimeException("Payroll not found"));

		// Set the request to operate in either the sandbox or production environment
		// Set environment from config class
		if ("PRODUCTION".equalsIgnoreCase(config.getEnvironment())) {
			ApiOperationBase.setEnvironment(Environment.PRODUCTION);
		} else {
			ApiOperationBase.setEnvironment(Environment.SANDBOX);
		}

		// Create object with merchant authentication details
		MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType();
		merchantAuthenticationType.setName(config.getLoginId());
		merchantAuthenticationType.setTransactionKey(config.getTransactionKey());

		// Populate the payment data
		PaymentType paymentType = new PaymentType();
		CreditCardType creditCard = new CreditCardType();
		creditCard.setCardNumber(creditCardNum);
		creditCard.setExpirationDate(expiredDate);
		paymentType.setCreditCard(creditCard);

		// Set email address (optional)
		CustomerDataType customer = new CustomerDataType();
		customer.setEmail(email);

		// Create the payment transaction object
		TransactionRequestType txnRequest = new TransactionRequestType();
		txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
		txnRequest.setPayment(paymentType);
		txnRequest.setCustomer(customer);
		txnRequest.setAmount(amount.setScale(2, RoundingMode.CEILING));

		// Create the API request and set the parameters for this specific request
		CreateTransactionRequest apiRequest = new CreateTransactionRequest();
		apiRequest.setMerchantAuthentication(merchantAuthenticationType);
		apiRequest.setTransactionRequest(txnRequest);

		// Call the controller
		CreateTransactionController controller = new CreateTransactionController(apiRequest);
		controller.execute();

		// Get the response
		CreateTransactionResponse response = controller.getApiResponse();

		// Parse the response to determine results
		if (response != null) {
			// If API Response is OK, go ahead and check the transaction response
			if (response.getMessages().getResultCode() == MessageTypeEnum.OK) {
				TransactionResponse result = response.getTransactionResponse();
				if (result.getMessages() != null) {

					PaymentEntity payment = new PaymentEntity();
					payment.setAmount(amount);
					payment.setGateway("AUTHORIZE.NET");
					payment.setPaymentDate(LocalDateTime.now());
					payment.setAuthCode(result.getAuthCode());
					payment.setTransactionId(result.getTransId());
					payment.setPayrollId(payroll);
					payment.setPaymentStatus(PaymentEntity.PaymentStatus.SUCCESS);

					paymentRepo.save(payment);

					// UPDATE PAYROLL
					payroll.setStatus(PayrollEntity.PayrollStatus.PAID);
					payroll.setPaymentDate(LocalDateTime.now());

					payrollRepo.save(payroll);
				} else {
					System.out.println("Failed Transaction.");
					if (response.getTransactionResponse().getErrors() != null) {
						System.out.println("Error Code: "
								+ response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
						System.out.println("Error message: "
								+ response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
					}
				}
			} else {
				System.out.println("Failed Transaction.");
				if (response.getTransactionResponse() != null
						&& response.getTransactionResponse().getErrors() != null) {
					System.out.println("Error Code: "
							+ response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
					System.out.println("Error message: "
							+ response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
				} else {
					System.out.println("Error Code: " + response.getMessages().getMessage().get(0).getCode());
					System.out.println("Error message: " + response.getMessages().getMessage().get(0).getText());
				}
			}
		} else {
			// Display the error code and message when response is null
			ANetApiResponse errorResponse = controller.getErrorResponse();
			System.out.println("Failed to get response");
			if (!errorResponse.getMessages().getMessage().isEmpty()) {
				System.out.println("Error: " + errorResponse.getMessages().getMessage().get(0).getCode() + " \n"
						+ errorResponse.getMessages().getMessage().get(0).getText());
			}
		}
		return response;
	}

}
