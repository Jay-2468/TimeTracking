package com.grownited.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
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
@Table(name = "reports")
public class ReportEntity {

	public enum ReportType {
		PROJECT, PRODUCTIVITY, BILLING
	}

	public enum ReportStatus {
		PROCESSING, COMPLETED, FAILED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reportId;

	private String reportTitle;

	@Enumerated(EnumType.STRING)
	private ReportType reportType;

	@ManyToOne
	@JoinColumn(name = "generated_by")
	private UserEntity generatedBy;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectEntity project;

	private LocalDate fromDate;
	
	private LocalDate toDate;

	@Enumerated(EnumType.STRING)
	private ReportStatus reportStatus;

	private Double totalHours;
	
	private Integer totalTasks;
	
	private Integer completedTasks;
	
	private Integer pendingTasks;

	private Double productivityScore;

	private String filePath;

	@Column(columnDefinition = "TEXT")
	private String chartData;

	private Boolean isDeleted = false;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@PrePersist
	public void onCreate() {
		this.reportStatus = ReportStatus.PROCESSING;
	}

	// getters & setters
	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

	public UserEntity getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(UserEntity generatedBy) {
		this.generatedBy = generatedBy;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public ReportStatus getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(ReportStatus reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}

	public Integer getTotalTasks() {
		return totalTasks;
	}

	public void setTotalTasks(Integer totalTasks) {
		this.totalTasks = totalTasks;
	}

	public Integer getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(Integer completedTasks) {
		this.completedTasks = completedTasks;
	}

	public Integer getPendingTasks() {
		return pendingTasks;
	}

	public void setPendingTasks(Integer pendingTasks) {
		this.pendingTasks = pendingTasks;
	}

	public Double getProductivityScore() {
		return productivityScore;
	}

	public void setProductivityScore(Double productivityScore) {
		this.productivityScore = productivityScore;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getChartData() {
		return chartData;
	}

	public void setChartData(String chartData) {
		this.chartData = chartData;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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
