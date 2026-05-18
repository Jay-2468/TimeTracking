package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.TimeLogEntity;
import com.grownited.repository.TimeLogRepository;
import com.grownited.service.ProjectService;
import com.grownited.service.TaskService;
import com.grownited.service.TimeLogService;
import com.grownited.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminTimeLogController {

	@Autowired
	private TimeLogRepository timeLogRepository;
	
	@Autowired
	private TimeLogService timeLogService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;

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

	@GetMapping(" archiveTimeLog")
	public String archiveTimeLog(Long logId) {

		timeLogRepository.deleteById(logId);

		return "redirect:/admin/timeLogsList";
	}

	@GetMapping("/viewTimeLog")
	public String viewTimeLog(Long logId, Model model) {

		TimeLogEntity timeLog = timeLogService.getTimeLogById(logId);

		model.addAttribute("timeLog", timeLog);

		return "Admin/TimeLog/ViewTimeLog";
	}
	
	@GetMapping("/editTimeLog")
	public String editTimeLog(@RequestParam("logId") Long logId, Model model) {

	    TimeLogEntity log = timeLogService.findById(logId);

	    model.addAttribute("log", log);

	    // Enums
	    model.addAttribute("logTypes", TimeLogEntity.LogType.values());
	    model.addAttribute("approvalStatuses", TimeLogEntity.ApprovalStatus.values());

	    // Dropdowns
	    model.addAttribute("tasks", taskService.findAll());
	    model.addAttribute("projects", projectService.findAll());
	    model.addAttribute("users", userService.findAll());

	    return "Admin/TimeLog/EditTimeLog";
	}
}
