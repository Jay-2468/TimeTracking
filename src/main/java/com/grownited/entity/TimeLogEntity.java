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
	private Integer task_id; // FK
	private Integer user_id; // FK
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	private Double total_hours;
	@Enumerated(EnumType.STRING)
	private LogType log_type; // log type : Auto / Manual
	@Enumerated(EnumType.STRING)
	private ApprovalStatus approval_status; // approval status : Approved / Rejected / Pending

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public LocalDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}

	public LocalDateTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}

	public Double getTotal_hours() {
		return total_hours;
	}

	public void setTotal_hours(Double total_hours) {
		this.total_hours = total_hours;
	}

	public LogType getLog_type() {
		return log_type;
	}

	public void setLog_type(LogType log_type) {
		this.log_type = log_type;
	}

	public ApprovalStatus getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(ApprovalStatus approval_status) {
		this.approval_status = approval_status;
	}

}
