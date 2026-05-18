package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.TimesheetEntity;
import com.grownited.entity.TimesheetEntity.Status;
import com.grownited.repository.TimesheetRepository;
import com.grownited.service.TimesheetService;
import com.grownited.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminTimesheetController {

	@Autowired
	private TimesheetRepository timesheetRepository;
	
	@Autowired
	private TimesheetService  timesheetService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/createTimesheet")
	public String createTimesheet() {
		return "Admin/Timesheet/NewTimesheet";
	}
	
	@PostMapping("/saveTimesheet")
	public String saveTimesheet(TimesheetEntity timesheetEntity) {
		timesheetEntity.setStatus(Status.SUBMITTED);
		timesheetRepository.save(timesheetEntity);
		return "redirect:/admin/timesheetsList";
	}
	
	@GetMapping("/timesheetsList")
	public String timesheetsList(Model model) {
		List<TimesheetEntity> timesheetsList = timesheetRepository.findAll();
		model.addAttribute("timesheetsList", timesheetsList);
		return "Admin/Timesheet/TimesheetsList";
	}
	
	@GetMapping("/deleteTimesheet")
	public String deleteTimesheet(Long timesheetId) {
		timesheetRepository.deleteById(timesheetId);
		return "redirect:/admin/timesheetsList";
	}
	
	
	@GetMapping("/viewTimesheet")
	public String viewTimesheet(Long timesheetId, Model model) {

	    TimesheetEntity timesheet = timesheetService.getTimesheetById(timesheetId);

	    model.addAttribute("timesheet", timesheet);

	    return "Admin/Timesheet/ViewTimesheet";
	}
	
	@GetMapping("/editTimesheet")
	public String editTimesheet(@RequestParam("timesheetId") Long timesheetId, Model model) {

	    TimesheetEntity timesheet = timesheetService.getTimesheetById(timesheetId);

	    model.addAttribute("timesheet", timesheet);

	    // Enum
	    model.addAttribute("statuses", TimesheetEntity.Status.values());

	    // Users
	    model.addAttribute("users", userService.findAll());

	    return "Admin/Timesheet/EditTimesheet";
	}
}
