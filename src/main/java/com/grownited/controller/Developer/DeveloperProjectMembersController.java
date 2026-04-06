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

@Controller
@RequestMapping("/developer")
public class DeveloperProjectMembersController {

	@Autowired
	private ProjectMembersRepository projectMembersRepo;

	@GetMapping("/viewTeamMembers")
	public String viewTeamMembers(Model model, @SessionAttribute("user") UserEntity user) {

		List<ProjectMembersEntity> myProjectAssignments = projectMembersRepo.findByUser(user);

		List<ProjectEntity> myProjects = myProjectAssignments.stream().map(ProjectMembersEntity::getProject).toList();

		List<ProjectMembersEntity> teamMembers = projectMembersRepo.findByProjectIn(myProjects);

		model.addAttribute("teamMembers", teamMembers);

		return "Developer/Team/ViewTeamMembers";
	}

}
