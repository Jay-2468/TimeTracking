package com.grownited.controller.Admin;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grownited.entity.ReportEntity;
import com.grownited.entity.UserEntity;
import com.grownited.service.ProjectService;
import com.grownited.service.ReportService;

@Controller
@RequestMapping("/admin")
public class AdminReportController {

	@Autowired
	private ReportService reportService;

	@Autowired
	private ProjectService projectService;

	// Show Form
	@GetMapping("/generateReport")
	public String generateForm(Model model) {

		model.addAttribute("projects", projectService.getAllProjects());

		return "Admin/Report/GenerateReport";
	}

	// Generate Report
	// Replace the generateReport POST method only:

	@PostMapping("/generateReport")
	public String generateReport(@ModelAttribute ReportEntity report, @RequestParam("projectId") String projectId,
			@RequestParam("reportType") String reportType, @SessionAttribute("user") UserEntity user) {
		
		if (projectId == null || projectId.trim().isEmpty()) {
			throw new RuntimeException("Project must be selected");
		}

		Long pid = Long.parseLong(projectId);

		if ("PRODUCTIVITY".equalsIgnoreCase(reportType)) {
			reportService.generateProductivityReport(report, pid, user);
		} else {
			reportService.generateProjectReport(report, pid, user);
		}

		return "redirect:/admin/listReports";
	}

	// List Reports
	@GetMapping("/listReports")
	public String listReports(Model model) throws Exception {

		List<ReportEntity> reports = reportService.getAllReports();

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();

		String reportsJson = mapper.writeValueAsString(reports);

		model.addAttribute("reports", reports);
		model.addAttribute("reportsJson", reportsJson);

		return "Admin/Report/ReportsList";
	}

	// Download PDF
	@GetMapping("/downloadReport")
	public ResponseEntity<Resource> downloadReport(@RequestParam Long reportId) throws Exception {

		ReportEntity report = reportService.getReportById(reportId);

		Path path = Paths.get(report.getFilePath());

		Resource resource = new UrlResource(path.toUri());

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + path.getFileName().toString())
				.body(resource);
	}

	@GetMapping("/viewReport")
	public String viewReport(Long reportId, Model model) {

		ReportEntity report = reportService.getReportById(reportId);

		model.addAttribute("report", report);

		return "Admin/Report/ViewReport";
	}
}