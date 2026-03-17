package com.grownited.controller.Developer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.TimeLogEntity;
import com.grownited.repository.TimeLogRepository;

@Controller
@RequestMapping("/developer")
public class DeveloperTimeLogController {
	
	@Autowired
	TimeLogRepository timeLogRepository;
	
	
	@GetMapping("/createTimeLog")
	public String createTimeLog() {
		
		return "Developer/TimeLog/NewTimeLog";
	}
	
	@GetMapping("/timeLogsList")
	public String timeLogsList(Model model) {
		List<TimeLogEntity> timeLogsList = timeLogRepository.findAll();
		model.addAttribute("timeLogsList", timeLogsList);
		return "Developer/TimeLog/TimeLogsList";
	}
	
}
