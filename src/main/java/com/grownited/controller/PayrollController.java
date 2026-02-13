package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.PayrollEntity;
import com.grownited.repository.PayrollRepository;

@Controller
public class PayrollController {

	@Autowired
	PayrollRepository payrollRepository;
	
	@GetMapping("/createPayroll")
	public String createPayroll() {
		return "Payroll/GeneratePayroll";
	}
	
	@PostMapping("/generatePayroll")
	public String generatePayroll(PayrollEntity payrollEntity) {
		payrollRepository.save(payrollEntity);
		return "redirect:/payrollRecords";
	}
	
	@GetMapping("/payrollRecords")
	public String payrollRecords(Model model) {
		List<PayrollEntity> payrolls = payrollRepository.findAll();
		model.addAttribute("payrolls", payrolls);
		return "Payroll/PayrollRecords";
	}
	
	@GetMapping("/deletePayroll")
	public String deletePayroll(Integer payrollId) {
		payrollRepository.deleteById(payrollId);
		return "redirect:/payrollRecords";
	}
}
