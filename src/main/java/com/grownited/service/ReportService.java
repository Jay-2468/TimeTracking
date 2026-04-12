package com.grownited.service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.ReportRepository;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.TimeLogRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ReportService {

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private TimeLogRepository timeLogRepository;

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ProjectRepository projectRepo;

	public ReportEntity generateProjectReport(ReportEntity report, Long projectId) {

		try {

			ProjectEntity project = projectRepo.findById(projectId).get();
			
			report.setProject(project);

			// Fetch time logs
			List<TimeLogEntity> logs = timeLogRepository.findByProjectAndDateBetween(projectId, report.getFromDate(),
					report.getToDate());

			double totalHours = logs.stream().mapToDouble(log -> log.getTotalHours().doubleValue()).sum();

			report.setTotalHours(totalHours);

			// Fetch tasks
			List<TaskEntity> tasks = taskRepository.findByProject(projectId);

			int totalTasks = tasks.size();
			int completed = (int) tasks.stream().filter(t -> t.getStatus() == TaskStatus.COMPLETED).count();

			int pending = totalTasks - completed;

			report.setTotalTasks(totalTasks);
			report.setCompletedTasks(completed);
			report.setPendingTasks(pending);

			// Productivity
			double productivity = totalTasks == 0 ? 0 : (double) completed / totalTasks * 100;

			report.setProductivityScore(productivity);

			// Chart Data (Hours per Day)
			Map<LocalDate, Double> dailyHours = logs.stream().collect(Collectors.groupingBy(TimeLogEntity::getLogDate,
					Collectors.summingDouble(log -> log.getTotalHours().doubleValue())));

			// Convert to JSON
			ObjectMapper mapper = new ObjectMapper();

			List<String> labels = new ArrayList<>();
			List<Double> data = new ArrayList<>();

			for (Map.Entry<LocalDate, Double> entry : dailyHours.entrySet()) {
				labels.add(entry.getKey().toString());
				data.add(entry.getValue());
			}

			Map<String, Object> chart = new HashMap<>();
			chart.put("labels", labels);
			chart.put("data", data);

			report.setChartData(mapper.writeValueAsString(chart));

			// PDF
			String filePath = generatePdf(report);
			report.setFilePath(filePath);

			report.setReportStatus(ReportEntity.ReportStatus.COMPLETED);
			
			System.out.println("Project ID: " + projectId);
			System.out.println("Logs size: " + logs.size());
			System.out.println("Tasks size: " + tasks.size());
			System.out.println("Chart Data: " + report.getChartData());

		} catch (Exception e) {
			e.printStackTrace();
			report.setReportStatus(ReportEntity.ReportStatus.FAILED);
		}

		return reportRepository.save(report);
	}

	public String generatePdf(ReportEntity report) throws Exception {

		File dir = new File("uploads/reports/");
		if (!dir.exists()) {
			dir.mkdirs();
		}

		String fileName = "report_" + System.currentTimeMillis() + ".pdf";
		String filePath = "uploads/reports/" + fileName;

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(filePath));

		document.open();

		Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD);
		Font normalFont = new Font(Font.HELVETICA, 12);

		document.add(new Paragraph("Project Report", titleFont));
		document.add(new Paragraph(" "));

		document.add(new Paragraph("Report Title: " + report.getReportTitle(), normalFont));
		document.add(new Paragraph("Total Hours: " + report.getTotalHours(), normalFont));
		document.add(new Paragraph("Total Tasks: " + report.getTotalTasks(), normalFont));
		document.add(new Paragraph("Completed Tasks: " + report.getCompletedTasks(), normalFont));
		document.add(new Paragraph("Pending Tasks: " + report.getPendingTasks(), normalFont));
		document.add(new Paragraph("Productivity: " + report.getProductivityScore() + "%", normalFont));

		document.close();

		return filePath;
	}

	public List<ReportEntity> getAllReports() {
		return reportRepository.findAll();
	}

	public Optional<ReportEntity> getReportById(Long reportId) {
		return reportRepository.findById(reportId);
	}
}