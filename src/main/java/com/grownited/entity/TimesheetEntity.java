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
import jakarta.persistence.Table;

@Entity
@Table(name = "timesheets")
public class TimesheetEntity {

	public enum Status {
		SUBMITTED, APPROVED, REJECTED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long timesheetId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user; // FK

	private LocalDate weekStart;

	private LocalDate weekEnd;

	@Column(precision = 5, scale = 2)
	private BigDecimal totalHours;

	@Enumerated(EnumType.STRING)
	private Status status; // status : Submitted / Approved / Rejected

	@ManyToOne
	@JoinColumn(name = "approved_by")
	private UserEntity approvedBy; // FK

	private LocalDateTime approvedAt;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void onCreate() {
		this.status = Status.SUBMITTED;
	}

	public Long getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(Long timesheetId) {
		this.timesheetId = timesheetId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public LocalDate getWeekStart() {
		return weekStart;
	}

	public void setWeekStart(LocalDate weekStart) {
		this.weekStart = weekStart;
	}

	public LocalDate getWeekEnd() {
		return weekEnd;
	}

	public void setWeekEnd(LocalDate weekEnd) {
		this.weekEnd = weekEnd;
	}

	public BigDecimal getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(BigDecimal totalHours) {
		this.totalHours = totalHours;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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

	public UserEntity getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(UserEntity approvedBy) {
		this.approvedBy = approvedBy;
	}

	public LocalDateTime getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(LocalDateTime approvedAt) {
		this.approvedAt = approvedAt;
	}

}
