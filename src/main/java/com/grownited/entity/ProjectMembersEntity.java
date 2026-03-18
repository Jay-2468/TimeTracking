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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "project_members")
public class ProjectMembersEntity {

	public enum Status {
		ACTIVE, REMOVED, COMPLETED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teamMemberId; // PK

	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectEntity project; // FK - Drop down

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user; // FK - Drop down

	@Transient
	private String roleInProject; // Developer, Tester(QA), Designer(UX/UI), etc.

	@ManyToOne
	@JoinColumn(name = "assigned_by")
	private UserEntity assignedBy; // FK

	private LocalDate assignedDate;

	@Enumerated(EnumType.STRING)
	private Status status;

	@PrePersist
	public void onCreate() {
		this.assignedDate = LocalDate.now();
	}

	public Integer getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(Integer teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
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

}
