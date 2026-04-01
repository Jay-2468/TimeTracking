package com.grownited.dto;

import java.time.LocalDate;

import com.grownited.entity.ProjectMembersEntity;

public class ProjectMembersDto {

    private Long teamMemberId;
    
    private Long projectId;
    
    private Long userId;

    private String roleInProject;
    
    private Long assignedBy;
    
    private LocalDate assignedDate;
    
    private ProjectMembersEntity.Status status; 

    // Getters and Setters

    public Long getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(Long teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleInProject() {
        return roleInProject;
    }

    public void setRoleInProject(String roleInProject) {
        this.roleInProject = roleInProject;
    }

    public Long getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Long assignedBy) {
        this.assignedBy = assignedBy;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public ProjectMembersEntity.Status getStatus() {
        return status;
    }

    public void setStatus(ProjectMembersEntity.Status status) {
        this.status = status;
    }
}