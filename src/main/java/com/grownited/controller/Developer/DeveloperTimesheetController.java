package com.grownited.controller.Developer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.TimesheetEntity;
import com.grownited.repository.TimesheetRepository;

@Controller
@RequestMapping("/developer")
public class DeveloperTimesheetController {

	@Autowired
	TimesheetRepository timesheetRepository;
	
	@GetMapping("/createTimesheet")
	public String createTimesheet() {
		
		return "Developer/Timesheet/NewTimesheet";
	}
	
	@GetMapping("/timesheetsList")
	public String timesheetsList(Model model) {
		List<TimesheetEntity> timesheetsList = timesheetRepository.findAll();
		model.addAttribute("timesheetsList", timesheetsList);
		return "Developer/Timesheet/TimesheetsList";
	}
	
	@GetMapping("/deleteTimesheet")
	public String deleteTimesheet(Integer timesheetId) {
		timesheetRepository.deleteById(timesheetId);
		return "redirect:/develpoper/timesheetsList";
	}
}
