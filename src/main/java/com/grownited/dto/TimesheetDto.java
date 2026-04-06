package com.grownited.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.grownited.entity.TimesheetEntity;

public class TimesheetDto {

	private Long timesheetId;

	private Long userId; // FK reference to UserEntity

	private LocalDate weekStart;

	private LocalDate weekEnd;

	private Double totalHours;

	private TimesheetEntity.Status status; // SUBMITTED / APPROVED / REJECTED

	private String approvalRemark;

	private Long approvedByUserId; // FK reference to UserEntity

	private LocalDateTime approvedAt;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private Boolean isDeleted;

	private Boolean isEditable;

	public Long getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(Long timesheetId) {
		this.timesheetId = timesheetId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}

	public TimesheetEntity.Status getStatus() {
		return status;
	}

	public void setStatus(TimesheetEntity.Status status) {
		this.status = status;
	}

	public String getApprovalRemark() {
		return approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
	}

	public Long getApprovedByUserId() {
		return approvedByUserId;
	}

	public void setApprovedByUserId(Long approvedByUserId) {
		this.approvedByUserId = approvedByUserId;
	}

	public LocalDateTime getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(LocalDateTime approvedAt) {
		this.approvedAt = approvedAt;
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(Boolean isEditable) {
		this.isEditable = isEditable;
	}

}