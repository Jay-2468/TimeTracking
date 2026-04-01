package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.dto.ProjectDto;
import com.grownited.entity.InvoiceEntity;
import com.grownited.entity.InvoiceEntity.PaymentStatus;
import com.grownited.entity.TimesheetEntity.Status;
import com.grownited.repository.InvoiceRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.TimesheetRepository;
import com.grownited.repository.UserRepository;
import com.grownited.service.ProjectService;

import tools.jackson.databind.ObjectMapper;

@Controller
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private TimesheetRepository timesheetRepository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping(value = {"/admin-dashboard", "/"})
	public String adminDashboard(Model model, InvoiceEntity invoiceEntity) {
		model.addAttribute("totalUsers", userRepository.count());
		model.addAttribute("totalProjects", projectRepository.count());
		model.addAttribute("pendingTimesheets", timesheetRepository.findByStatus(Status.SUBMITTED).size());
		model.addAttribute("unpaidInvoices", invoiceRepository.findByPaymentStatus(PaymentStatus.UNPAID).size());
		
//		model.addAttribute("recentActivities", activityService.getRecentActivities());
		
		ObjectMapper mapper = new ObjectMapper();

		// Example Weekly Data
		List<ProjectDto> projects = projectService.getAllProjects();
		
		// String revenueJson = mapper.writeValueAsString(revenue);

	    // For charts
		model.addAttribute("projects", projects);
		
		return "Admin/AdminDashboard";
	}
}
