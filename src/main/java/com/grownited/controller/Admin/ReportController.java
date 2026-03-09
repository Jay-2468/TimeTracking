package com.grownited.controller.Admin;

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
public class ReportController {

	@Autowired
	ReportRepository reportRepository;
	
	@GetMapping("/admin/createReport")
	public String createReport() {
		return "Admin/Report/GenerateReport";
	}
	
	@PostMapping("/admin/generateReport")
	public String generateReport(ReportEntity reportEntity, HttpSession session) {
		reportRepository.save(reportEntity);
		return "redirect:/admin/reportsList";
	}
	
	@GetMapping("/admin/reportsList")
	public String reportstList(Model model) {
		List<ReportEntity> reports = reportRepository.findAll();
		model.addAttribute("reports", reports); 
		return "Admin/Report/ReportsList";
	}
	
	@GetMapping("/admin/deleteReport")
	public String deleteReport(Integer reportId) {
		reportRepository.deleteById(reportId);
		return "redirect:/admin/reportsList";
	}
	
}
