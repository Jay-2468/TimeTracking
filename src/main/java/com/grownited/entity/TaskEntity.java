package com.grownited.entity;

import java.time.LocalDate;

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

	public enum Priority {
		HIGH, MEDIUM, LOW
	}

	public enum Status {
		PENDING, IN_PROGRESS, COMPLETED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;

	private String taskName;

	private String description;

	@Enumerated(EnumType.STRING)
	private Priority priority; // priorities : High / Medium / Low

	private LocalDate deadline;

	@Enumerated(EnumType.STRING)
	private Status status; // status : Pending / In Progress / Completed

	@ManyToOne
	@JoinColumn(name = "module_id")
	private ModuleEntity moduleId; // FK // drop-down

	@ManyToOne
	@JoinColumn(name = "assigned_to")
	private UserEntity assignedTo; // FK // drop-down

	@ManyToOne
	@JoinColumn(name = "created_by")
	private UserEntity createdBy; // FK

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
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

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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

}
