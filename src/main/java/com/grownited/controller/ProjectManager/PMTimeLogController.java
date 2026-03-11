package com.grownited.controller.ProjectManager;

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
@RequestMapping("/pm")
public class PMTimeLogController {
	
	@Autowired
	TimeLogRepository timeLogRepository;
	
	@GetMapping("/createTimeLog")
	public String createTimeLog() {
		return "ProjectManager/TimeLog/NewTimeLog";
	}
	
	@PostMapping("/saveTimeLog")
	public String saveTimeLog(TimeLogEntity timeLogEntity) {
		timeLogRepository.save(timeLogEntity);
		return "redirect:/pm/timeLogsList";
	}
	
	@GetMapping("/timeLogsList")
	public String timeLogsList(Model model) {
		List<TimeLogEntity> timeLogsList = timeLogRepository.findAll();
		model.addAttribute("timeLogsList", timeLogsList);
		return "ProjectManager/TimeLog/TimeLogsList";
	}
	
	@GetMapping("/deleteTimeLog")
	public String deleteTimeLog(Integer logId) {
		timeLogRepository.deleteById(logId);
		return "redirect:/pm/timeLogsList";
	}
}
