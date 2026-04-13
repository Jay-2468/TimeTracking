package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.UserEntity.Role;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.UserRepository;
import com.grownited.service.ProjectMembersService;
import com.grownited.service.ProjectService;
import com.grownited.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminProjectController {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectMembersService pmsService;

	@Autowired
	private UserService userService;

	@GetMapping("/newProject")
	public String newProject(Model model) {

		List<UserEntity> userList = userRepository.findByRole(Role.PROJECT_MANAGER);
		model.addAttribute("pmList", userList);

		return "Admin/Project/NewProject";
	}

	@PostMapping("/createProject")
	public String saveProject(ProjectEntity projectEntity) {

		projectRepository.save(projectEntity);

		return "redirect:/admin/projectsList";
	}

	@GetMapping("/projectsList")
	public String projectsList(Model model) {

		model.addAttribute("projectsList", projectService.getAllProjectsNotDeleted());

		return "Admin/Project/ProjectsList";
	}

	@GetMapping("/archiveProject")
	public String archiveProject(Long projectId) {

		projectService.archiveProject(projectId);

		return "redirect:/admin/projectsList";
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
			return "Admin/Project/ViewProject";
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

		return "Admin/Project/EditProjectDetails";
	}

	@PostMapping("/updateProject")
	public String updateProject(ProjectEntity project) {
		projectService.updateProject(project);
		return "redirect:/admin/projectsList";
	}

}
