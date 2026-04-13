package com.grownited.controller.ProjectManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.UserEntity;
import com.grownited.service.ProjectMembersService;
import com.grownited.service.ProjectService;
import com.grownited.service.UserService;

@Controller
@RequestMapping("/pm")
public class PMProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectMembersService pmsService;

	@Autowired
	private UserService userService;
	
	@GetMapping("/projectsList")
	public String projectsList(Model model, @SessionAttribute("user") UserEntity user) {

		model.addAttribute("projectsList", pmsService.getProjectsAssignedToUser(user));

		return "ProjectManager/Project/ProjectsList";
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
			return "ProjectManager/Project/ViewProject";
		}
	}

	@GetMapping("/editProject")
	public String editProject(@RequestParam("projectId") Long projectId, Model model) {

		ProjectEntity project = projectService.findById(projectId);

		model.addAttribute("project", project);

		// Enums
		model.addAttribute("statuses", ProjectEntity.Status.values());
		model.addAttribute("priorities", ProjectEntity.Priority.values());

		// Users for dropdowns
		model.addAttribute("users", userService.findAll());

		return "ProjectManager/Project/EditProjectDetails";
	}

	@PostMapping("/updateProject")
	public String updateProject(ProjectEntity project) {
		projectService.updateProject(project);
		return "redirect:/projectsList";
	}

}
