package com.grownited.controller.Developer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeveloperController {

	@GetMapping("/developer-dashboard")
	public String developerDashboard() {
		return "Developer/DeveloperDashboard";
	}
}
