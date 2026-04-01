package com.grownited.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.grownited.entity.TimeLogEntity;

public class TimeLogDto {

	private Long logId;

	private Long taskId; // FK reference to TaskEntity

	private Long userId; // FK reference to UserEntity

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	private LocalDate logDate;

	private Double breakHours;

	private Double totalHours;

	private TimeLogEntity.LogType logType; // AUTO / MANUAL

	private TimeLogEntity.ApprovalStatus approvalStatus; // APPROVED / REJECTED / PENDING

	private Long approvedByUserId; // FK reference to UserEntity

	private String approvalRemark;

	private Boolean isDeleted;

	private Boolean isEditable;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public LocalDate getLogDate() {
		return logDate;
	}

	public void setLogDate(LocalDate logDate) {
		this.logDate = logDate;
	}

	public Double getBreakHours() {
		return breakHours;
	}

	public void setBreakHours(Double breakHours) {
		this.breakHours = breakHours;
	}

	public Double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}

	public TimeLogEntity.LogType getLogType() {
		return logType;
	}

	public void setLogType(TimeLogEntity.LogType logType) {
		this.logType = logType;
	}

	public TimeLogEntity.ApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(TimeLogEntity.ApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Long getApprovedByUserId() {
		return approvedByUserId;
	}

	public void setApprovedByUserId(Long approvedByUserId) {
		this.approvedByUserId = approvedByUserId;
	}

	public String getApprovalRemark() {
		return approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
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