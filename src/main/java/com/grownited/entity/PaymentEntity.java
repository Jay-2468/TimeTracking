package com.grownited.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	private Integer orderId;

	private Double amount;

	private String paymentMode;

	private String gateway;

	private String paymentStatus;

	@CreationTimestamp
	private LocalDate paymentDate;

	private String paymentGatewayTransactionId;

	private String paymentGatewayAuthCode;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentGatewayTransactionId() {
		return paymentGatewayTransactionId;
	}

	public void setPaymentGatewayTransactionId(String paymentGatewayTransactionId) {
		this.paymentGatewayTransactionId = paymentGatewayTransactionId;
	}

	public String getPaymentGatewayAuthCode() {
		return paymentGatewayAuthCode;
	}

	public void setPaymentGatewayAuthCode(String paymentGatewayAuthCode) {
		this.paymentGatewayAuthCode = paymentGatewayAuthCode;
	}

}