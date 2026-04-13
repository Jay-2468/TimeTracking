package com.grownited.controller.Developer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.ProjectMembersEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProjectMembersRepository;
import com.grownited.service.ProjectMembersService;
import com.grownited.service.ProjectService;


@Controller
@RequestMapping("/developer")
public class DeveloperProjectController {

	@Autowired
	private ProjectMembersRepository projectMembersRepository;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectMembersService pmsService;
	
	@GetMapping("/projectsList")
	public String projectsList(Model model, @SessionAttribute("user") UserEntity user) {
		
		List<ProjectMembersEntity> projectsList = projectMembersRepository.findByAssignedTo(user);
		model.addAttribute("projectsList", projectsList);
		 
		return "Developer/Project/ProjectsList";
	}
	
	@GetMapping("/viewProject")
	public String viewProject(Long projectId, Model model) {

		ProjectEntity project = projectService.getProjectById(projectId);
		if (project == null) {
			return "";
		} else {
			model.addAttribute("project", project);
			model.addAttribute("teamMembers", pmsService.getTeamMembersByProject(projectId));
			model.addAttribute("totalTeamMembers", pmsService.getTotalTeamMembers(projectId));
			return "Developer/Project/ViewProject";
		}
	}
	
}
