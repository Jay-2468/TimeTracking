package com.grownited.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	private TaskEntity task; // FK - drop down

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user; // FK

	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectEntity project;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	private LocalDate logDate;

	private LocalDateTime breakStartTime;

	private LocalDateTime breakEndTime;

	@Column(precision = 5, scale = 2)
	private BigDecimal breakDuration;

	@Column(precision = 5, scale = 2)
	private BigDecimal totalHours;

	@Enumerated(EnumType.STRING)
	private LogType logType; // log type : Auto / Manual

	@Enumerated(EnumType.STRING)
	private ApprovalStatus approvalStatus; // approval status : Approved / Rejected / Pending

	@ManyToOne
	@JoinColumn(name = "approved_by")
	private UserEntity approvedBy;

	@Column(length = 500)
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
		this.approvalStatus = ApprovalStatus.PENDING;
		calculateHours();
	}

	@PreUpdate
	public void onUpdate() {
		calculateHours();
	}

	public void calculateHours() {

		double workHours = 0;
		double breakHours = 0;

		if (startTime != null && endTime != null) {
			workHours = (double) java.time.Duration.between(startTime, endTime).toMinutes() / 60;
		}

		if (breakStartTime != null && breakEndTime != null) {
			breakHours = (double) java.time.Duration.between(breakStartTime, breakEndTime).toMinutes() / 60;

			this.breakDuration = BigDecimal.valueOf(breakHours).setScale(2, RoundingMode.HALF_UP);
		}

		double finalHours = workHours - breakHours;
		if (finalHours < 0)
			finalHours = 0;

		this.totalHours = BigDecimal.valueOf(finalHours).setScale(2, RoundingMode.HALF_UP);
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

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
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

	public LocalDateTime getBreakStartTime() {
		return breakStartTime;
	}

	public void setBreakStartTime(LocalDateTime breakStartTime) {
		this.breakStartTime = breakStartTime;
	}

	public LocalDateTime getBreakEndTime() {
		return breakEndTime;
	}

	public void setBreakEndTime(LocalDateTime breakEndTime) {
		this.breakEndTime = breakEndTime;
	}

	public BigDecimal getBreakDuration() {
		return breakDuration;
	}

	public void setBreakDuration(BigDecimal breakDuration) {
		this.breakDuration = breakDuration;
	}

	public BigDecimal getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(BigDecimal totalHours) {
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
