package com.grownited.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.grownited.entity.TaskEntity;

public class TaskDto {

	private Long taskId;

	private String taskName;

	private String description;

	private TaskEntity.TaskPriority priority;

	private LocalDate deadline;

	private TaskEntity.TaskStatus status;

	private Long moduleId; // FK reference to ModuleEntity

	private Long assignedToUserId; // FK reference to UserEntity

	private Long createdByUserId; // FK reference to UserEntity

	private Integer progress; // 0-100%

	private LocalDateTime createdAt;

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

	public TaskEntity.TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskEntity.TaskPriority priority) {
		this.priority = priority;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public TaskEntity.TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskEntity.TaskStatus status) {
		this.status = status;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public Long getAssignedToUserId() {
		return assignedToUserId;
	}

	public void setAssignedToUserId(Long assignedToUserId) {
		this.assignedToUserId = assignedToUserId;
	}

	public Long getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(Long createdByUserId) {
		this.createdByUserId = createdByUserId;
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