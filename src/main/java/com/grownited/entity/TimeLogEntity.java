package com.grownited.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "time_logs")
public class TimeLogEntity {

	private enum LogType {
		AUTO, MANUAL
	}

	private enum ApprovalStatus {
		APPROVED, REJECTED, PENDING
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer logId;
	private Integer taskId; // FK
	private Integer userId; // FK
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Double totalHours;
	@Enumerated(EnumType.STRING)
	private LogType logType; // log type : Auto / Manual
	@Enumerated(EnumType.STRING)
	private ApprovalStatus approvalStatus; // approval status : Approved / Rejected / Pending

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

}
