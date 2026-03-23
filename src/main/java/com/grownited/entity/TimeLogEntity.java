package com.grownited.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "time_logs")
public class TimeLogEntity {

	public enum LogType {
		AUTO, MANUAL
	}

	public enum ApprovalStatus {
		APPROVED, REJECTED, PENDING
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logId;

	@ManyToOne
	@JoinColumn(name = "task_id")
	private TaskEntity task; // FK

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user; // FK

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	private LocalDate logDate;

	private Double breakHours;

	private Double totalHours;

	@Enumerated(EnumType.STRING)
	private LogType logType; // log type : Auto / Manual

	@Enumerated(EnumType.STRING)
	private ApprovalStatus approvalStatus; // approval status : Approved / Rejected / Pending

	@ManyToOne
	@JoinColumn(name = "approved_by")
	private UserEntity approvedBy;

	private String approvalRemark;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	private Boolean isDeleted = false;

	private Boolean isEditable = false;

	@PrePersist
	public void onCreate() {
		this.logDate = startTime.toLocalDate();
		calculateHours();
	}

	@PreUpdate
	public void calculateHours() {
		if (startTime != null && endTime != null) {
			this.totalHours = (double) java.time.Duration.between(startTime, endTime).toMinutes() / 60;
		}
	}

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public TaskEntity getTask() {
		return task;
	}

	public void setTask(TaskEntity task) {
		this.task = task;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
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

	public LogType getLogType() {
		return logType;
	}

	public void setLogType(LogType logType) {
		this.logType = logType;
	}

	public ApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(ApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public UserEntity getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(UserEntity approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovalRemark() {
		return approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
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
