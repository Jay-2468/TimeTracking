package com.grownited.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reports")
public class ReportEntity {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer reportId;
	private String reportType; // report types : Project / Productivity / Billing
	private Integer generatedBy; // FK
	private LocalDateTime generatedDate;
	private String reportData;
	
	
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public Integer getGeneratedBy() {
		return generatedBy;
	}
	public void setGeneratedBy(Integer generatedBy) {
		this.generatedBy = generatedBy;
	}
	public LocalDateTime getGeneratedDate() {
		return generatedDate;
	}
	public void setGeneratedDate(LocalDateTime generatedDate) {
		this.generatedDate = generatedDate;
	}
	public String getReportData() {
		return reportData;
	}
	public void setReportData(String reportData) {
		this.reportData = reportData;
	}
	
	
}
