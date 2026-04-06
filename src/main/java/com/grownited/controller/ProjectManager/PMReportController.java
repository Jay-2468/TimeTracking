package com.grownited.controller.ProjectManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.ReportEntity;
import com.grownited.repository.ReportRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/pm")
public class PMReportController {

	@Autowired
	private ReportRepository reportRepository;
	
	@GetMapping("/createReport")
	public String createReport() {
		
		return "ProjectManager/Report/GenerateReport";
	}
	
	@PostMapping("/generateReport")
	public String generateReport(ReportEntity reportEntity, HttpSession session) {

		reportRepository.save(reportEntity);

		return "redirect:/pm/reportsList";
	}
	
	@GetMapping("/reportsList")
	public String reportstList(Model model) {
		
		List<ReportEntity> reports = reportRepository.findAll();
		model.addAttribute("reports", reports); 
		
		return "ProjectManager/Report/ReportsList";
	}
	
	@GetMapping("/archiveReport")
	public String archiveReport(Integer reportId) {
		
		// reportRepository.deleteById(reportId);
		
		return "redirect:/pm/reportsList";
	}
	
}
