package com.grownited.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class TeamMembersEntity {

	public enum Status {
		ACTIVE, REMOVED, COMPLETED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teamMemberId; // PK
	private Integer projectId; // FK - Drop down
	private Integer userId; // FK - Drop down
	@Transient
	private String roleInProject; // Developer, Tester(QA), Designer(UX/UI), etc.
	private Integer assignedBy; // FK
	private LocalDate assignedDate;
	@Enumerated(EnumType.STRING)
	private Status status;

	public Integer getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(Integer teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRoleInProject() {
		return roleInProject;
	}

	public void setRoleInProject(String roleInProject) {
		this.roleInProject = roleInProject;
	}

	public Integer getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(Integer assignedBy) {
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
