package com.grownited.controller.ProjectManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.TimesheetEntity;
import com.grownited.entity.TimesheetEntity.Status;
import com.grownited.repository.TimesheetRepository;

@Controller
public class PMTimesheetController {

	@Autowired
	TimesheetRepository timesheetRepository;
	
	@GetMapping("/pm/createTimesheet")
	public String createTimesheet() {
		return "ProjectManager/Timesheet/NewTimesheet";
	}
	
	@PostMapping("/pm/saveTimesheet")
	public String saveTimesheet(TimesheetEntity timesheetEntity) {
		timesheetEntity.setStatus(Status.SUBMITTED);
		timesheetRepository.save(timesheetEntity);
		return "redirect:/pm/timesheetsList";
	}
	
	@GetMapping("/pm/timesheetsList")
	public String timesheetsList(Model model) {
		List<TimesheetEntity> timesheetsList = timesheetRepository.findAll();
		model.addAttribute("timesheetsList", timesheetsList);
		return "ProjectManager/Timesheet/TimesheetsList";
	}
	
	@GetMapping("/pm/deleteTimesheet")
	public String deleteTimesheet(Integer timesheetId) {
		timesheetRepository.deleteById(timesheetId);
		return "redirect:/pm/timesheetsList";
	}
}
