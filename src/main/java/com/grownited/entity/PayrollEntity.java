package com.grownited.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payroll")
public class PayrollEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer payrollId;
	private Integer userId; // FK // drop-down
	private Double totalHours;
	private Double salaryAmount;
	private LocalDate paymentDate;
	
	
	public Integer getPayrollId() {
		return payrollId;
	}
	public void setPayrollId(Integer payrollId) {
		this.payrollId = payrollId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}
	public Double getSalaryAmount() {
		return salaryAmount;
	}
	public void setSalaryAmount(Double salaryAmount) {
		this.salaryAmount = salaryAmount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
