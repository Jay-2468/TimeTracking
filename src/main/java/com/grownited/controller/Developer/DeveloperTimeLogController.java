package com.grownited.controller.Developer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.TaskEntity;
import com.grownited.entity.TimeLogEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.TimeLogRepository;
import com.grownited.service.ProjectService;
import com.grownited.service.TaskService;
import com.grownited.service.TimeLogService;
import com.grownited.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/developer")
public class DeveloperTimeLogController {

	@Autowired
	private TimeLogRepository timeLogRepo;

	@Autowired
	private TaskRepository taskRepo;

	@Autowired
	private TimeLogService timeLogService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserService userService;

	@GetMapping("/createTimeLog")
	public String createTimeLog(Model model, @SessionAttribute("user") UserEntity user) {

		List<TaskEntity> tasksList = taskRepo.findByAssignedTo(user);
		model.addAttribute("tasksList", tasksList);
		model.addAttribute("logTypes", TimeLogEntity.LogType.values());

		return "Developer/TimeLog/NewTimeLog";
	}

	@PostMapping("/saveTimeLog")
	public String saveTimeLog(TimeLogEntity timeLogEntity, Long taskId, @SessionAttribute("user") UserEntity user) {

		TaskEntity task = taskRepo.findById(taskId).orElse(null);
		timeLogEntity.setTask(task);
		timeLogEntity.setUser(user);
		timeLogRepo.save(timeLogEntity);

		return "redirect:/developer/timeLogsList";
	}

	@GetMapping("/timeLogsList")
	public String timeLogsList(Model model, @SessionAttribute("user") UserEntity user) {

		List<TimeLogEntity> timeLogsList = timeLogRepo.findByUser(user);
		model.addAttribute("timeLogsList", timeLogsList);

		return "Developer/TimeLog/TimeLogsList";
	}

	@GetMapping("/viewTimeLog")
	public String viewTimeLog(Long logId, Model model) {

		TimeLogEntity timeLog = timeLogService.getTimeLogById(logId);

		model.addAttribute("timeLog", timeLog);

		return "Developer/TimeLog/ViewTimeLog";
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

		return "Developer/TimeLog/EditTimeLog";
	}

}
