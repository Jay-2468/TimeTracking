package com.grownited.controller.Admin;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.PayrollEntity;
import com.grownited.entity.UserEntity;
import com.grownited.service.PayrollService;
import com.grownited.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminPayrollController {

	@Autowired
	private PayrollService payrollService;

	@Autowired
	private UserService userService;

	@GetMapping("/generatePayroll")
	public String showGeneratePayrollPage(Model model, @SessionAttribute("user") UserEntity user) {

		Long excludedUserId = user.getUserId();

		LocalDate today = LocalDate.now();

		// Previous month
		LocalDate previousMonth = today.minusMonths(1);

		// Start of previous month
		LocalDate startDate = previousMonth.withDayOfMonth(1);

		// End of previous month
		LocalDate endDate = previousMonth.withDayOfMonth(previousMonth.lengthOfMonth());

		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);

		// employees list already sending
		model.addAttribute("employees", userService.getAllUnpaidUsersByUserIdNot(excludedUserId));

		return "Admin/Payroll/GeneratePayroll";
	}

	@PostMapping("/generatePayroll")
	public String generatePayroll(Long userId, String periodStartDate, String periodEndDate,
			@SessionAttribute("user") UserEntity user) {

		System.out.println(userId);
		System.out.println(periodStartDate);
		System.out.println(periodEndDate);

		payrollService.generatePayroll(userId, periodStartDate, periodEndDate, user);

		return "redirect:/admin/payrollRecords";
	}

	@GetMapping("/payrollRecords")
	public String payrollRecords(Model model) {

		model.addAttribute("payrolls", payrollService.getAllPayrollEntries());

		return "Admin/Payroll/PayrollRecords";
	}

	@GetMapping("/archivePayroll")
	public String archivePayroll(Long payrollId) {

		payrollService.archivePayroll(payrollId);

		return "redirect:/admin/payrollRecords";
	}

	@GetMapping("/editPayroll")
	public String editPayroll(@RequestParam("payrollId") Long payrollId, Model model) {

		PayrollEntity payroll = payrollService.findById(payrollId);

		model.addAttribute("payroll", payroll);

		// Enum
		model.addAttribute("statuses", PayrollEntity.PayrollStatus.values());

		// Users for dropdowns
		model.addAttribute("users", userService.findAll());

		return "Admin/Payroll/EditPayroll";
	}

	@PostMapping("/updatePayroll")
	public String updatePayroll(PayrollEntity payroll) {
		payrollService.updatePayroll(payroll);
		return "redirect:/payrollRecords";
	}
}
