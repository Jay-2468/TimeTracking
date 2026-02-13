package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.TimeSheetEntity;
import com.grownited.repository.TimeSheetRepository;

@Controller
public class TimeSheetController {

	@Autowired
	TimeSheetRepository timeSheetRepository;
	
	@GetMapping("/createTimeSheet")
	public String createTimeSheet() {
		return "TimeSheet/NewTimeSheet";
	}
	
	@PostMapping("/saveTimeSheet")
	public String saveTimeSheet(TimeSheetEntity timeSheetEntity) {
		timeSheetRepository.save(timeSheetEntity);
		return "redirect:/timeSheetsList";
	}
	
	@GetMapping("/timeSheetsList")
	public String timeSheetsList(Model model) {
		List<TimeSheetEntity> timeSheetsList = timeSheetRepository.findAll();
		model.addAttribute("timeSheetsList", timeSheetsList);
		return "TimeSheet/TimeSheetsList";
	}
	
	@GetMapping("/deleteTimeSheet")
	public String deleteTimeSheet(Integer timeSheetId) {
		timeSheetRepository.deleteById(timeSheetId);
		return "redirect:/timeSheetsList";
	}
}
