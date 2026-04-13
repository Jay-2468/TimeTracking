package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.ProjectMembersEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProjectMembersRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminProjectMembersController {

	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ProjectMembersRepository pmsRepo;

	@GetMapping("/assignProject")
	public String assignProject(Model model, @RequestParam(value = "projectId", required = false) Long projectId) {

		List<ProjectEntity> projects = projectRepo.findAll();
		model.addAttribute("projects", projects);

		return "Admin/Project/AssignProject";
	}

	@GetMapping("/getUsersByProject")
	@ResponseBody
	public List<UserEntity> getUsersByProject(@RequestParam Long projectId) {

		return userRepo.findAvailableUsers(projectId, List.of("ADMIN", "DEVELOPER"));
	}

	@PostMapping("/saveProjectAssignment")
	public String saveProjectAssignment(ProjectMembersEntity pmsEntity, Long projectId, Long userId,
			@SessionAttribute("user") UserEntity user) {

		ProjectEntity project = projectRepo.findById(projectId).get();
		UserEntity userEntity = userRepo.findById(userId).get();
		pmsEntity.setProject(project);
		pmsEntity.setAssignedTo(userEntity);
		pmsEntity.setAssignedBy(user);
		pmsEntity.setRoleInProject("Project Manager");
		pmsRepo.save(pmsEntity);

		return "redirect:/admin/assignProject";
	}
}
