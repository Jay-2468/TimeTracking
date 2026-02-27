package com.grownited.controller.ProjectManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PMController {

	@GetMapping("/pm-dashboard")
	public String pmDashboard() {
		return "ProjectManager/PMDashboard";
	}
	
}
