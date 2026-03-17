package com.grownited.controller.ProjectManager;

import com.grownited.entity.TimesheetEntity.Status;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.TimesheetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class PMController {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	TimesheetRepository timesheetRepository;
	

	@GetMapping("/pm-dashboard")
	public String pmDashboard(Model model, @SessionAttribute("user") UserEntity user) {
		
		model.addAttribute("totalProjects", projectRepository.findByAssignedTo(user).size());
		model.addAttribute("totalModules", moduleRepository.count());
		model.addAttribute("totalTeamMembers", 0);
		model.addAttribute("totalPendingTimesheets", timesheetRepository.findByStatus(Status.SUBMITTED).size());
		
		return "ProjectManager/PMDashboard";
	}
	
}
