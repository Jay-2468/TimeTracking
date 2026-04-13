package com.grownited.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_members")
public class ProjectMembersEntity {

	public enum Status {
		ACTIVE, REMOVED, COMPLETED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamMemberId; // PK

	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectEntity project; // FK - Drop down

	@ManyToOne
	@JoinColumn(name = "assigned_to")
	private UserEntity assignedTo; // FK - Drop down

	private String roleInProject; // Developer, Tester(QA), Designer(UX/UI), etc.

	@ManyToOne
	@JoinColumn(name = "assigned_by")
	private UserEntity assignedBy; // FK

	@CreationTimestamp
	private LocalDate assignedDate;

	@Enumerated(EnumType.STRING)
	private Status status; // status: active / removed / completed

	private Boolean isRemoved;

	@PrePersist
	public void onCreate() {
		this.status = Status.ACTIVE;
		if (isRemoved == null) {
			this.isRemoved = false;
		}
	}

	public Long getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(Long teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public UserEntity getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(UserEntity assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getRoleInProject() {
		return roleInProject;
	}

	public void setRoleInProject(String roleInProject) {
		this.roleInProject = roleInProject;
	}

	public UserEntity getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(UserEntity assignedBy) {
		this.assignedBy = assignedBy;
	}

	public LocalDate getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDate assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Boolean getIsRemoved() {
		return isRemoved;
	}

	public void setIsRemoved(Boolean isRemoved) {
		this.isRemoved = isRemoved;
	}

}
