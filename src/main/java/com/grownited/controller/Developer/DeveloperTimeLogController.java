package com.grownited.controller.Developer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.TaskEntity;
import com.grownited.entity.TimeLogEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.TimeLogRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/developer")
public class DeveloperTimeLogController {
	
	@Autowired
	private TimeLogRepository timeLogRepo;
	
	@Autowired
	private TaskRepository taskRepo;
	
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
	
}
