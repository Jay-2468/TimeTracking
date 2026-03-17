package com.grownited.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payroll")
@Getter
@Setter
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

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.status = PayrollStatus.GENERATED;
		calculateNetSalary();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
		calculateNetSalary();
	}

	public void calculateNetSalary() {
		if (hourlyRate != null && totalHours != null) {
			BigDecimal gross = hourlyRate.multiply(BigDecimal.valueOf(totalHours));
			BigDecimal totalBonus = bonus != null ? bonus : BigDecimal.ZERO;
			BigDecimal totalDeduction = deductions != null ? deductions : BigDecimal.ZERO;

			this.netSalary = gross.add(totalBonus).subtract(totalDeduction);
		}
	}
}
