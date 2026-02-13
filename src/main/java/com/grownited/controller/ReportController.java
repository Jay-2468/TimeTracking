package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ReportEntity;
import com.grownited.repository.ReportRepository;

@Controller
public class ReportController {

	@Autowired
	ReportRepository reportRepository;
	
	@GetMapping("/createReport")
	public String createReport() {
		return "Report/GenerateReport";
	}
	
	@PostMapping("/generateReport")
	public String generateReport(ReportEntity reportEntity) {
		reportRepository.save(reportEntity);
		return "redirect:/reportsList";
	}
	
	@GetMapping("/reportsList")
	public String reportstList(Model model) {
		List<ReportEntity> reportsList = reportRepository.findAll();
		model.addAttribute("reportsList", reportsList);
		return "Report/ReportsList";
	}
	
	@GetMapping("/deleteReport")
	public String deleteReport(Integer reportId) {
		reportRepository.deleteById(reportId);
		return "redirect:/reportsList";
	}
	
}
