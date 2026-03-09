package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.TimeLogEntity;
import com.grownited.repository.TimeLogRepository;

@Controller
public class TimeLogController {
	
	@Autowired
	TimeLogRepository timeLogRepository;
	
	@GetMapping("/admin/createTimeLog")
	public String createTimeLog() {
		return "Admin/TimeLog/NewTimeLog";
	}
	
	@PostMapping("/admin/saveTimeLog")
	public String saveTimeLog(TimeLogEntity timeLogEntity) {
		timeLogRepository.save(timeLogEntity);
		return "redirect:/admin/timeLogsList";
	}
	
	@GetMapping("/admin/timeLogsList")
	public String timeLogsList(Model model) {
		List<TimeLogEntity> timeLogsList = timeLogRepository.findAll();
		model.addAttribute("timeLogsList", timeLogsList);
		return "Admin/TimeLog/TimeLogsList";
	}
	
	@GetMapping("/admin/deleteTimeLog")
	public String deleteTimeLog(Integer logId) {
		timeLogRepository.deleteById(logId);
		return "redirect:/admin/timeLogsList";
	}
}
