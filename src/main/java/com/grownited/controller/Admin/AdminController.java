package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.InvoiceEntity;
import com.grownited.entity.InvoiceEntity.PaymentStatus;
import com.grownited.entity.TimesheetEntity.Status;
import com.grownited.repository.InvoiceRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.TimesheetRepository;
import com.grownited.repository.UserRepository;

import tools.jackson.databind.ObjectMapper;

@Controller
public class AdminController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	TimesheetRepository timesheetRepository;
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@GetMapping(value = {"/admin-dashboard", "/"})
	public String adminDashboard(Model model, InvoiceEntity invoiceEntity) {
		model.addAttribute("totalUsers", userRepository.count());
		model.addAttribute("totalProjects", projectRepository.count());
		model.addAttribute("pendingTimesheets", timesheetRepository.findByStatus(Status.SUBMITTED).size());
		model.addAttribute("unpaidInvoices", invoiceRepository.findByPaymentStatus(PaymentStatus.UNPAID).size());
		
//		model.addAttribute("recentActivities", activityService.getRecentActivities());
		
		ObjectMapper mapper = new ObjectMapper();

		// Example Weekly Data
		List<String> weekLabels = List.of("Mon", "Tue", "Wed", "Thu", "Fri");
		List<Integer> weekHours = List.of(8, 6, 7, 9, 5);

		String weekLabelsJson = mapper.writeValueAsString(weekLabels);
		String weekHoursJson = mapper.writeValueAsString(weekHours);

		// Example Monthly Revenue
		List<String> monthLabels = List.of("Jan", "Feb", "Mar", "Apr");
		List<Integer> revenue = List.of(50000, 75000, 62000, 90000);

		String monthLabelsJson = mapper.writeValueAsString(monthLabels);
		String revenueJson = mapper.writeValueAsString(revenue);

	    // For charts
		model.addAttribute("weekLabels", weekLabelsJson);
		model.addAttribute("weekHours", weekHoursJson);
		model.addAttribute("monthLabels", monthLabelsJson);
		model.addAttribute("monthlyRevenue", revenueJson);
		 		
		return "Admin/AdminDashboard";
	}
}
