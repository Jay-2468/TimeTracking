package com.grownited.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "payrolls")
public class PayrollEntity {

	public enum PayrollStatus {
		GENERATED, PAID, HOLD, CANCELLED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payrollId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user; // FK // drop-down

	private Double totalHours;

	@Column(precision = 10, scale = 2)
	private BigDecimal hourlyRate;

	@Column(precision = 10, scale = 2)
	private BigDecimal bonus;

	@Column(precision = 10, scale = 2)
	private BigDecimal deductions;

	@Column(precision = 10, scale = 2)
	private BigDecimal netSalary;

	private LocalDate paymentDate;

	private LocalDate periodStartDate;

	private LocalDate periodEndDate;

	@Enumerated(EnumType.STRING)
	private PayrollStatus status;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@PrePersist
	public void onCreate() {
		this.status = PayrollStatus.GENERATED;
		calculateNetSalary();
	}

	@PreUpdate
	public void calculateNetSalary() {
		if (hourlyRate != null && totalHours != null) {
			BigDecimal gross = hourlyRate.multiply(BigDecimal.valueOf(totalHours));
			BigDecimal totalBonus = bonus != null ? bonus : BigDecimal.ZERO;
			BigDecimal totalDeduction = deductions != null ? deductions : BigDecimal.ZERO;

			this.netSalary = gross.add(totalBonus).subtract(totalDeduction);
		}
	}

	public Long getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(Long payrollId) {
		this.payrollId = payrollId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}

	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public BigDecimal getDeductions() {
		return deductions;
	}

	public void setDeductions(BigDecimal deductions) {
		this.deductions = deductions;
	}

	public BigDecimal getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(BigDecimal netSalary) {
		this.netSalary = netSalary;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public LocalDate getPeriodStartDate() {
		return periodStartDate;
	}

	public void setPeriodStartDate(LocalDate periodStartDate) {
		this.periodStartDate = periodStartDate;
	}

	public LocalDate getPeriodEndDate() {
		return periodEndDate;
	}

	public void setPeriodEndDate(LocalDate periodEndDate) {
		this.periodEndDate = periodEndDate;
	}

	public PayrollStatus getStatus() {
		return status;
	}

	public void setStatus(PayrollStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
