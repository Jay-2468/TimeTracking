package com.grownited.controller.ProjectManager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.TimesheetEntity;
import com.grownited.repository.TimesheetRepository;

@Controller
@RequestMapping("/pm")
public class PMTimesheetController {

	@Autowired
	private TimesheetRepository timesheetRepo;

	@GetMapping("/timesheetsList")
	public String timesheetsList(Model model) {
		
		List<TimesheetEntity> timesheetsList = timesheetRepo.findAll();
		model.addAttribute("timesheetsList", timesheetsList);
		
		return "ProjectManager/Timesheet/TimesheetsList";
	}

	@GetMapping("/approveTimesheet")
	public String approveTimesheet(Long timesheetId) {

		Optional<TimesheetEntity> opUser = timesheetRepo.findById(timesheetId);

		if (opUser.isPresent()) {
			TimesheetEntity timesheetEntity = opUser.get();
			timesheetEntity.setStatus(TimesheetEntity.Status.APPROVED);
			timesheetRepo.save(timesheetEntity);
		}

		return "redirect:/pm/timesheetsList";
	}

	@GetMapping("/rejectTimesheet")
	public String rejectTimesheet(Model model, Long timesheetId, String reason) {

		Optional<TimesheetEntity> opUser = timesheetRepo.findById(timesheetId);

		if (opUser.isPresent()) {
			TimesheetEntity timesheetEntity = opUser.get();
			timesheetEntity.setStatus(TimesheetEntity.Status.REJECTED);
			timesheetEntity.setApprovalRemark(reason);
			timesheetRepo.save(timesheetEntity);
		}

		return "redirect:/pm/timesheetsList";
	}

	@GetMapping("/archiveTimesheet")
	public String archiveTimesheet(Long timesheetId) {

		Optional<TimesheetEntity> opUser = timesheetRepo.findById(timesheetId);

		if (opUser.isPresent()) {
			TimesheetEntity timesheetEntity = opUser.get();
			timesheetEntity.setIsDeleted(true);
			timesheetRepo.save(timesheetEntity);
		}

		return "redirect:/pm/timesheetsList";
	}
}
