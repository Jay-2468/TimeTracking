package com.grownited.controller.ProjectManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ReportEntity;
import com.grownited.repository.ReportRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class PMReportController {

	@Autowired
	ReportRepository reportRepository;
	
	@GetMapping("/pm/createReport")
	public String createReport() {
		return "ProjectManager/Report/GenerateReport";
	}
	
	@PostMapping("/pm/generateReport")
	public String generateReport(ReportEntity reportEntity, HttpSession session) {
		reportRepository.save(reportEntity);
		return "redirect:/pm/reportsList";
	}
	
	@GetMapping("/pm/reportsList")
	public String reportstList(Model model) {
		List<ReportEntity> reports = reportRepository.findAll();
		model.addAttribute("reports", reports); 
		return "ProjectManager/Report/ReportsList";
	}
	
	@GetMapping("/pm/deleteReport")
	public String deleteReport(Integer reportId) {
		reportRepository.deleteById(reportId);
		return "redirect:/pm/reportsList";
	}
	
}
