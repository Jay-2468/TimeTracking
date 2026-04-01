package com.grownited.dto;

import java.time.LocalDateTime;

import com.grownited.entity.ReportEntity;

public class ReportDto {

	private Long reportId;

	private String reportTitle;

	private ReportEntity.ReportType reportType;

	private Long generatedByUserId;

	private LocalDateTime generatedDate;

	private LocalDateTime fromDate;

	private LocalDateTime toDate;

	private ReportEntity.ReportStatus reportStatus;

	private String reportData;

	private Boolean isDeleted;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

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

	public ReportEntity.ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportEntity.ReportType reportType) {
		this.reportType = reportType;
	}

	public Long getGeneratedByUserId() {
		return generatedByUserId;
	}

	public void setGeneratedByUserId(Long generatedByUserId) {
		this.generatedByUserId = generatedByUserId;
	}

	public LocalDateTime getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(LocalDateTime generatedDate) {
		this.generatedDate = generatedDate;
	}

	public LocalDateTime getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDateTime getToDate() {
		return toDate;
	}

	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}

	public ReportEntity.ReportStatus getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(ReportEntity.ReportStatus reportStatus) {
		this.reportStatus = reportStatus;
	}

	public String getReportData() {
		return reportData;
	}

	public void setReportData(String reportData) {
		this.reportData = reportData;
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