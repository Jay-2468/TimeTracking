package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.grownited.repository.TimeSheetRepository;

@Controller
public class TimeSheetController {

	@Autowired
	TimeSheetRepository timeSheetRepository;
	
	
}
