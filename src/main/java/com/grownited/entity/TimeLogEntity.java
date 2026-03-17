package com.grownited.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "time_logs")
@Getter
@Setter
public class TimeLogEntity {

	public enum LogType {
		AUTO, MANUAL
	}

	public enum ApprovalStatus {
		APPROVED, REJECTED, PENDING
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer logId;
	
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
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;

	private Boolean isDeleted = false;

	private Boolean isEditable = false;
	
	
	@PrePersist
	public void onCreate() {
		this.logDate = startTime.toLocalDate();
		this.createdAt = LocalDateTime.now();
		calculateHours();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
		calculateHours();
	}
	
	public void calculateHours() {
	    if (startTime != null && endTime != null) {
	        this.totalHours = (double) java.time.Duration.between(startTime, endTime).toMinutes() / 60;
	    }
	}
	
}
