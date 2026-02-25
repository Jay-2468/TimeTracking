package com.grownited.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.PayrollEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.PayrollRepository;
import com.grownited.repository.UserRepository;

@Controller
public class PayrollController {

	@Autowired
	PayrollRepository payrollRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/createPayroll")
	public String createPayroll(Model model) {
		List<UserEntity> users = userRepository.findAll();
		model.addAttribute("users", users);
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
		List<UserEntity> userList = userRepository.findAll();
		Map<Integer, String> userMap = new HashMap<>();
		for (UserEntity user : userList) {
			userMap.put(user.getUserId(), user.getFullUserName());
		}
		model.addAttribute("userMap", userMap);
		return "Payroll/PayrollRecords";
	}

	@GetMapping("/deletePayroll")
	public String deletePayroll(Integer payrollId) {
		payrollRepository.deleteById(payrollId);
		return "redirect:/payrollRecords";
	}
}
