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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reports")
@Getter
@Setter
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

}
