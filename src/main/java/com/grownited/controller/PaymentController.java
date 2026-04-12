package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.PayrollEntity;
import com.grownited.entity.PayrollEntity.PayrollStatus;
import com.grownited.entity.UserEntity;
import com.grownited.repository.PayrollRepository;
import com.grownited.service.PaymentService;

@Controller
@RequestMapping("/admin")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PayrollRepository payrollRepo;

	@GetMapping("/paySalary")
	public String paySalary(Long payrollId, @SessionAttribute("user") UserEntity user) {

		System.out.println("PAY BUTTON CLICKED"); // ✅ debug

		paymentService.chargeCreditCard(user.getEmail(), "4111111111111111", "1228",
				payrollRepo.findById(payrollId).get().getNetSalary(), payrollId);

		return "redirect:/admin/payrollRecords";
	}

	@PostMapping("/paySalary")
	public String processPayment(String cardNumber, String expMonth, String expYear, Long payrollId,
			@SessionAttribute("user") UserEntity user) {

		PayrollEntity payroll = payrollRepo.findById(payrollId)
				.orElseThrow(() -> new RuntimeException("Payroll not found"));

		if (payroll.getStatus() == PayrollStatus.PAID) {
			throw new RuntimeException("Salary already paid");
		}

		paymentService.chargeCreditCard(user.getEmail(), "4111111111111111", // dummy VISA test card
				"1228", payroll.getNetSalary(), payrollId);

		return "redirect:/admin/payrollRecords";
	}
}