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
@Table(name = "projects")
public class ProjectEntity {

	public enum Status {
		PLANNED, ONGOING, COMPLETED
	}

	public enum Priority {
		LOW, MEDIUM, HIGH
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;

	private String projectName;

	private String description;

	@ManyToOne
	@JoinColumn(name = "assigned_by")
	private UserEntity assignedBy; // FK

	@ManyToOne
	@JoinColumn(name = "assigned_to")
	private UserEntity assignedTo; // FK - Drop Down

	@ManyToOne
	@JoinColumn(name = "manager_id")
	public UserEntity manager; // FK

	private LocalDate startDate;

	private LocalDate endDate;

	@Enumerated(EnumType.STRING)
	private Status status; // status : Planned / Ongoing / Completed

	@Enumerated(EnumType.STRING)
	private Priority priority; // priority : Low / Medium / High

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	private Integer progress; // 0-100%

	private Integer estimatedHours;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserEntity getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(UserEntity assignedTo) {
		this.assignedTo = assignedTo;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UserEntity getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(UserEntity assignedBy) {
		this.assignedBy = assignedBy;
	}

	public UserEntity getManager() {
		return manager;
	}

	public void setManager(UserEntity manager) {
		this.manager = manager;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
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

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public Integer getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(Integer estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

}
