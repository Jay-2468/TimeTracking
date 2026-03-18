package com.grownited.entity;

import java.time.LocalDateTime;

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
	private ReportType reportType; // report types : Project / Productivity / Billing

	@ManyToOne
	@JoinColumn(name = "generated_by")
	private UserEntity generatedBy; // FK

	private LocalDateTime generatedDate;

	private LocalDateTime fromDate;

	private LocalDateTime toDate;

	@Enumerated(EnumType.STRING)
	private ReportStatus reportStatus; // report status : Processing / Completed / Failed

	@Column(columnDefinition = "TEXT")
	private String reportData;

	private Boolean isDeleted = false; // archive // soft delete

	@PrePersist
	public void onCreate() {
		this.generatedDate = LocalDateTime.now();
		this.reportStatus = ReportStatus.PROCESSING;
	}

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

	public ReportStatus getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(ReportStatus reportStatus) {
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

}
