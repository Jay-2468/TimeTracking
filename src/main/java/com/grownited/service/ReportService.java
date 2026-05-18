package com.grownited.service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grownited.entity.ProjectEntity;
import com.grownited.entity.ReportEntity;
import com.grownited.entity.TaskEntity;
import com.grownited.entity.TaskEntity.TaskStatus;
import com.grownited.entity.TimeLogEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.ReportRepository;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.TimeLogRepository;

// OpenPDF imports
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.util.Base64;

@Service
public class ReportService {

	@Autowired
	private ReportRepository reportRepo;

	@Autowired
	private TimeLogRepository timeLogRepo;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private ChartGeneratorService chartGeneratorService; // ← NEW

	// ─────────────────────────────────────────────────────────────────────────
	// Generate Project Report
	// ─────────────────────────────────────────────────────────────────────────
	public ReportEntity generateProjectReport(ReportEntity report, Long projectId, UserEntity user) {
		try {
			ProjectEntity project = projectRepo.findById(projectId).get();
			report.setProject(project);
			report.setReportType(ReportEntity.ReportType.PROJECT);
			report.setGeneratedBy(user);

			// ── 1. Time logs ──────────────────────────────────────────────
			List<TimeLogEntity> logs = timeLogRepo.findByProjectAndDateBetween(projectId, report.getFromDate(),
					report.getToDate());
			double totalHours = logs.stream().mapToDouble(log -> log.getTotalHours().doubleValue()).sum();
			report.setTotalHours(totalHours);

			// ── 2. Tasks ──────────────────────────────────────────────────
			List<TaskEntity> tasks = taskRepository.findByProject(projectId);
			int totalTasks = tasks.size();
			int completed = (int) tasks.stream().filter(t -> t.getStatus() == TaskStatus.COMPLETED).count();
			int pending = totalTasks - completed;

			report.setTotalTasks(totalTasks);
			report.setCompletedTasks(completed);
			report.setPendingTasks(pending);

			// ── 3. Productivity score ─────────────────────────────────────
			double productivity = totalTasks == 0 ? 0 : (double) completed / totalTasks * 100;
			report.setProductivityScore(productivity);

			// ── 4. Daily hours map (sorted by date) ───────────────────────
			Map<LocalDate, Double> rawDailyHours = logs.stream().collect(Collectors.groupingBy(
					TimeLogEntity::getLogDate, Collectors.summingDouble(log -> log.getTotalHours().doubleValue())));

			// Sort by date for clean chart display
			Map<String, Double> dailyHours = rawDailyHours.entrySet().stream().sorted(Map.Entry.comparingByKey())
					.collect(Collectors.toMap(e -> e.getKey().toString(), Map.Entry::getValue, (a, b) -> a,
							LinkedHashMap::new));

			// ── 5. Chart — Bar chart (Hours per Day) ──────────────────────
			String chartBase64 = chartGeneratorService.generateBarChartBase64(dailyHours);
			report.setChartData(chartBase64); // stored as raw Base64 PNG

			// ── 6. Also store labels/data JSON for JSP Chart.js fallback ──
			// (kept for backward compatibility if needed)
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> chartJson = new HashMap<>();
			chartJson.put("labels", new ArrayList<>(dailyHours.keySet()));
			chartJson.put("data", new ArrayList<>(dailyHours.values()));
			chartJson.put("type", "bar");
			// We store the Base64 directly in chartData, chartJson is optional extra
			// metadata

			// ── 7. Generate PDF (with chart image embedded) ───────────────
			String filePath = generatePdf(report);
			report.setFilePath(filePath);
			report.setReportStatus(ReportEntity.ReportStatus.COMPLETED);

			System.out.println("Project ID    : " + projectId);
			System.out.println("Logs size     : " + logs.size());
			System.out.println("Tasks size    : " + tasks.size());
			System.out.println("Total Hours   : " + totalHours);
			System.out.println("Productivity  : " + productivity + "%");
			System.out.println("Chart Base64 length: " + chartBase64.length());

		} catch (Exception e) {
			e.printStackTrace();
			report.setReportStatus(ReportEntity.ReportStatus.FAILED);
		}

		return reportRepo.save(report);
	}

	// ─────────────────────────────────────────────────────────────────────────
	// Generate Productivity Report
	// ─────────────────────────────────────────────────────────────────────────
	public ReportEntity generateProductivityReport(ReportEntity report, Long projectId, UserEntity user) {
		try {
			ProjectEntity project = projectRepo.findById(projectId).get();
			report.setProject(project);
			report.setReportType(ReportEntity.ReportType.PRODUCTIVITY);
			report.setGeneratedBy(user);

			List<TaskEntity> tasks = taskRepository.findByProject(projectId);
			int totalTasks = tasks.size();
			int completed = (int) tasks.stream().filter(t -> t.getStatus() == TaskStatus.COMPLETED).count();
			int pending = totalTasks - completed;

			List<TimeLogEntity> logs = timeLogRepo.findByProjectAndDateBetween(projectId, report.getFromDate(),
					report.getToDate());
			double totalHours = logs.stream().mapToDouble(l -> l.getTotalHours().doubleValue()).sum();
			double productivity = totalTasks == 0 ? 0 : (double) completed / totalTasks * 100;

			report.setTotalHours(totalHours);
			report.setTotalTasks(totalTasks);
			report.setCompletedTasks(completed);
			report.setPendingTasks(pending);
			report.setProductivityScore(productivity);

			// Pie chart for productivity reports
			String chartBase64 = chartGeneratorService.generatePieChartBase64(completed, pending);
			report.setChartData(chartBase64);

			String filePath = generatePdf(report);
			report.setFilePath(filePath);
			report.setReportStatus(ReportEntity.ReportStatus.COMPLETED);

		} catch (Exception e) {
			e.printStackTrace();
			report.setReportStatus(ReportEntity.ReportStatus.FAILED);
		}

		return reportRepo.save(report);
	}

	// ─────────────────────────────────────────────────────────────────────────
	// Generate PDF — OpenPDF with chart image embedded
	// ─────────────────────────────────────────────────────────────────────────
	public String generatePdf(ReportEntity report) throws Exception {

		// Ensure output directory exists
		File dir = new File("uploads/reports/");
		if (!dir.exists())
			dir.mkdirs();

		String fileName = "report_" + System.currentTimeMillis() + ".pdf";
		String filePath = "uploads/reports/" + fileName;

		Document document = new Document(PageSize.A4, 50, 50, 60, 60);
		PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();

		// ── Fonts ──────────────────────────────────────────────────────────
		Font fontTitle = new Font(Font.HELVETICA, 20, Font.BOLD, new Color(33, 37, 41));
		Font fontHeading = new Font(Font.HELVETICA, 13, Font.BOLD, new Color(52, 58, 64));
		Font fontLabel = new Font(Font.HELVETICA, 11, Font.BOLD, new Color(73, 80, 87));
		Font fontValue = new Font(Font.HELVETICA, 11, Font.NORMAL, new Color(33, 37, 41));

		// ── Title ──────────────────────────────────────────────────────────
		Paragraph title = new Paragraph(report.getReportTitle(), fontTitle);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingAfter(4f);
		document.add(title);

		// Report type subtitle
		String reportTypeLabel = report.getReportType() == ReportEntity.ReportType.PROJECT ? "Project Report"
				: "Productivity Report";
		Paragraph subtitle = new Paragraph(reportTypeLabel, fontHeading);
		subtitle.setAlignment(Element.ALIGN_CENTER);
		subtitle.setSpacingAfter(16f);
		document.add(subtitle);

		// ── Divider line ───────────────────────────────────────────────────
		addDivider(document);

		// ── Report Details Table ───────────────────────────────────────────
		Paragraph detailsHeading = new Paragraph("Report Summary", fontHeading);
		detailsHeading.setSpacingBefore(14f);
		detailsHeading.setSpacingAfter(8f);
		document.add(detailsHeading);

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.setWidths(new float[] { 2f, 3f });
		table.setSpacingAfter(16f);

		Color headerBg = new Color(52, 58, 64);
		Color rowBg1 = new Color(248, 249, 250);
		Color rowBg2 = Color.WHITE;

		addTableRow(table, "Report Type", report.getReportType().name(), fontLabel, fontValue, rowBg1);
		addTableRow(table, "Status", report.getReportStatus().name(), fontLabel, fontValue, rowBg2);
		addTableRow(table, "From Date", report.getFromDate() != null ? report.getFromDate().toString() : "-", fontLabel,
				fontValue, rowBg1);
		addTableRow(table, "To Date", report.getToDate() != null ? report.getToDate().toString() : "-", fontLabel,
				fontValue, rowBg2);
		addTableRow(table, "Total Hours", String.format("%.2f hrs", report.getTotalHours()), fontLabel, fontValue,
				rowBg1);
		addTableRow(table, "Total Tasks", String.valueOf(report.getTotalTasks()), fontLabel, fontValue, rowBg2);
		addTableRow(table, "Completed Tasks", String.valueOf(report.getCompletedTasks()), fontLabel, fontValue, rowBg1);
		addTableRow(table, "Pending Tasks", String.valueOf(report.getPendingTasks()), fontLabel, fontValue, rowBg2);
		addTableRow(table, "Productivity Score", String.format("%.1f%%", report.getProductivityScore()), fontLabel,
				fontValue, rowBg1);

		document.add(table);
		addDivider(document);

		// ── Chart Image ────────────────────────────────────────────────────
		if (report.getChartData() != null && !report.getChartData().isEmpty()) {
			Paragraph chartHeading = new Paragraph("Report Chart", fontHeading);
			chartHeading.setSpacingBefore(14f);
			chartHeading.setSpacingAfter(10f);
			document.add(chartHeading);

			try {
				byte[] imgBytes = Base64.getDecoder().decode(report.getChartData());
				Image chartImage = Image.getInstance(imgBytes);
				chartImage.scaleToFit(500, 280); // fit nicely on A4
				chartImage.setAlignment(Element.ALIGN_CENTER);
				chartImage.setSpacingBefore(6f);
				document.add(chartImage);
			} catch (Exception imgEx) {
				System.err.println("Failed to embed chart in PDF: " + imgEx.getMessage());
			}
		}

		document.close();
		return filePath;
	}

	// ─────────────────────────────────────────────────────────────────────────
	// Helpers
	// ─────────────────────────────────────────────────────────────────────────

	private void addTableRow(PdfPTable table, String label, String value, Font labelFont, Font valueFont, Color bg) {
		PdfPCell labelCell = new PdfPCell(new Phrase(label, labelFont));
		labelCell.setBackgroundColor(bg);
		labelCell.setPadding(7f);
		labelCell.setBorderColor(new Color(222, 226, 230));

		PdfPCell valueCell = new PdfPCell(new Phrase(value, valueFont));
		valueCell.setBackgroundColor(bg);
		valueCell.setPadding(7f);
		valueCell.setBorderColor(new Color(222, 226, 230));

		table.addCell(labelCell);
		table.addCell(valueCell);
	}

	private void addDivider(Document document) throws DocumentException {
		Paragraph divider = new Paragraph(" ");
		divider.setSpacingBefore(2f);
		divider.setSpacingAfter(2f);
		document.add(divider);
	}

	// ─────────────────────────────────────────────────────────────────────────
	// Standard CRUD
	// ─────────────────────────────────────────────────────────────────────────

	public List<ReportEntity> getAllReports() {
		return reportRepo.findAll();
	}

	public ReportEntity getReportById(Long reportId) {

		ReportEntity report = reportRepo.findById(reportId).orElseThrow(() -> new RuntimeException("Report not found"));

		// Avoid Lazy Loading
		report.getGeneratedBy().getFirstName();

		if (report.getProject() != null) {
			report.getProject().getProjectName();
		}

		return report;
	}

}