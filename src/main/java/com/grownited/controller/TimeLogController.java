package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.grownited.repository.TimeLogRepository;

@Controller
public class TimeLogController {
	
	@Autowired
	TimeLogRepository timeLogRepository;
}
