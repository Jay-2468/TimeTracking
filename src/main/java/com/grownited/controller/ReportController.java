package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.grownited.repository.ReportRepository;

@Controller
public class ReportController {

	@Autowired
	ReportRepository reportRepository;
	
	
}
