package com.grownited.controller.ProjectManager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.TimeLogEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.TimeLogRepository;
import com.grownited.service.ProjectService;
import com.grownited.service.TaskService;
import com.grownited.service.TimeLogService;
import com.grownited.service.UserService;

@Controller
@RequestMapping("/pm")
public class PMTimeLogController {

	@Autowired
	private TimeLogRepository timeLogRepo;

	@Autowired
	private TimeLogService timeLogService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/timeLogsList")
	public String timeLogsList(Model model, @SessionAttribute("user") UserEntity user) {

		List<TimeLogEntity> timeLogsList = timeLogRepo.findByTask_CreatedByAndIsDeletedFalse(user);
		model.addAttribute("timeLogsList", timeLogsList);

		return "ProjectManager/TimeLog/TimeLogsList";
	}

	@GetMapping("/approveTimeLog")
	public String approveTimeLog(Long logId) {

		Optional<TimeLogEntity> opUser = timeLogRepo.findById(logId);

		if (opUser.isPresent()) {
			TimeLogEntity timeLogEntity = opUser.get();
			timeLogEntity.setApprovalStatus(TimeLogEntity.ApprovalStatus.APPROVED);
			timeLogRepo.save(timeLogEntity);
		}

		return "redirect:/pm/timeLogsList";
	}

	@GetMapping("/rejectTimeLog")
	public String rejectTimeLog(Model model, Long logId, String reason) {

		Optional<TimeLogEntity> opUser = timeLogRepo.findById(logId);

		if (opUser.isPresent()) {
			TimeLogEntity timeLogEntity = opUser.get();
			timeLogEntity.setApprovalStatus(TimeLogEntity.ApprovalStatus.REJECTED);
			timeLogEntity.setApprovalRemark(reason);
			timeLogRepo.save(timeLogEntity);
		}

		return "redirect:/pm/timeLogsList";
	}

	@GetMapping("/archiveTimeLog")
	public String archiveTimeLog(Long logId) {

		Optional<TimeLogEntity> opUser = timeLogRepo.findById(logId);

		if (opUser.isPresent()) {
			TimeLogEntity timeLogEntity = opUser.get();
			timeLogEntity.setIsDeleted(true);
			timeLogRepo.save(timeLogEntity);
		}

		return "redirect:/pm/timeLogsList";
	}

	@GetMapping("/viewTimeLog")
	public String viewTimeLog(Long logId, Model model) {

		TimeLogEntity timeLog = timeLogService.getTimeLogById(logId);

		model.addAttribute("timeLog", timeLog);

		return "ProjectManager/TimeLog/ViewTimeLog";
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

	    return "ProjectManager/TimeLog/EditTimeLog";
	}
}
