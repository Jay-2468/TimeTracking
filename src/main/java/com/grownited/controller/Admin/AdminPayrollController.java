package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.PayrollEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.PayrollRepository;
import com.grownited.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminPayrollController {

	@Autowired
	PayrollRepository payrollRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/createPayroll")
	public String createPayroll(Model model) {
		
		List<UserEntity> users = userRepository.findAll();
		model.addAttribute("users", users);
		
		return "Admin/Payroll/GeneratePayroll";
	}

	@PostMapping("/generatePayroll")
	public String generatePayroll(PayrollEntity payrollEntity) {
		
		payrollRepository.save(payrollEntity);
	
		return "redirect:/admin/payrollRecords";
	}

	@GetMapping("/payrollRecords")
	public String payrollRecords(Model model) {
		
		List<PayrollEntity> payrolls = payrollRepository.findAll();
		model.addAttribute("payrolls", payrolls);
		
		return "Admin/Payroll/PayrollRecords";
	}

	@GetMapping("/deletePayroll")
	public String deletePayroll(Integer payrollId) {
		
		payrollRepository.deleteById(payrollId);
		
		return "redirect:/admin/payrollRecords";
	}
}
