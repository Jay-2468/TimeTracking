package com.grownited.controller.Admin;

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
public class TimesheetController {

	@Autowired
	TimesheetRepository timesheetRepository;
	
	@GetMapping("/admin/createTimesheet")
	public String createTimesheet() {
		return "Admin/Timesheet/NewTimesheet";
	}
	
	@PostMapping("/admin/saveTimesheet")
	public String saveTimesheet(TimesheetEntity timesheetEntity) {
		timesheetEntity.setStatus(Status.SUBMITTED);
		timesheetRepository.save(timesheetEntity);
		return "redirect:/admin/timesheetsList";
	}
	
	@GetMapping("/admin/timesheetsList")
	public String timesheetsList(Model model) {
		List<TimesheetEntity> timesheetsList = timesheetRepository.findAll();
		model.addAttribute("timesheetsList", timesheetsList);
		return "Admin/Timesheet/TimesheetsList";
	}
	
	@GetMapping("/admin/deleteTimesheet")
	public String deleteTimesheet(Integer timesheetId) {
		timesheetRepository.deleteById(timesheetId);
		return "redirect:/admin/timesheetsList";
	}
}
