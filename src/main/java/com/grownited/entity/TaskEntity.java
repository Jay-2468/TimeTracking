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
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class TaskEntity {

	public enum TaskPriority {
		HIGH, MEDIUM, LOW
	}

	public enum TaskStatus {
		PENDING, IN_PROGRESS, COMPLETED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;

	private String taskName;

	private String description;

	@Enumerated(EnumType.STRING)
	private TaskPriority priority; // priorities : High / Medium / Low

	private LocalDate deadline;

	@Enumerated(EnumType.STRING)
	private TaskStatus status; // status : Pending / In Progress / Completed

	@ManyToOne
	@JoinColumn(name = "module_id")
	private ModuleEntity moduleId; // FK // drop-down

	@ManyToOne
	@JoinColumn(name = "assigned_to")
	private UserEntity assignedTo; // FK // drop-down

	@ManyToOne
	@JoinColumn(name = "created_by")
	private UserEntity createdBy; // FK

	private Integer progress; // 0-100%

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public ModuleEntity getModuleId() {
		return moduleId;
	}

	public void setModuleId(ModuleEntity moduleId) {
		this.moduleId = moduleId;
	}

	public UserEntity getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(UserEntity assignedTo) {
		this.assignedTo = assignedTo;
	}

	public UserEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
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
