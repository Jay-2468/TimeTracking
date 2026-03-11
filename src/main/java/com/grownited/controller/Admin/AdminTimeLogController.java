package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.TimeLogEntity;
import com.grownited.repository.TimeLogRepository;

@Controller
@RequestMapping("/admin")
public class AdminTimeLogController {
	
	@Autowired
	TimeLogRepository timeLogRepository;
	
	@GetMapping("/createTimeLog")
	public String createTimeLog() {
		return "Admin/TimeLog/NewTimeLog";
	}
	
	@PostMapping("/saveTimeLog")
	public String saveTimeLog(TimeLogEntity timeLogEntity) {
		timeLogRepository.save(timeLogEntity);
		return "redirect:/admin/timeLogsList";
	}
	
	@GetMapping("/timeLogsList")
	public String timeLogsList(Model model) {
		List<TimeLogEntity> timeLogsList = timeLogRepository.findAll();
		model.addAttribute("timeLogsList", timeLogsList);
		return "Admin/TimeLog/TimeLogsList";
	}
	
	@GetMapping("/deleteTimeLog")
	public String deleteTimeLog(Integer logId) {
		timeLogRepository.deleteById(logId);
		return "redirect:/admin/timeLogsList";
	}
}
