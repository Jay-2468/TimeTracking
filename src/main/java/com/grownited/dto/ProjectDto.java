package com.grownited.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.grownited.entity.ProjectEntity;

public class ProjectDto {

	private Long projectId;

	private String projectName;

	private String description;

	private Long assignedById;

	private Long assignedToId;

	private Long managerId;

	private LocalDate startDate;

	private LocalDate endDate;

	private ProjectEntity.Status status; // PLANNED, ONGOING, COMPLETED

	private ProjectEntity.Priority priority; // LOW, MEDIUM, HIGH

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private Integer progress;

	private Integer estimatedHours;

	// Getters and Setters

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

	public Long getAssignedById() {
		return assignedById;
	}

	public void setAssignedById(Long assignedById) {
		this.assignedById = assignedById;
	}

	public Long getAssignedToId() {
		return assignedToId;
	}

	public void setAssignedToId(Long assignedToId) {
		this.assignedToId = assignedToId;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
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

	public ProjectEntity.Status getStatus() {
		return status;
	}

	public void setStatus(ProjectEntity.Status status) {
		this.status = status;
	}

	public ProjectEntity.Priority getPriority() {
		return priority;
	}

	public void setPriority(ProjectEntity.Priority priority) {
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