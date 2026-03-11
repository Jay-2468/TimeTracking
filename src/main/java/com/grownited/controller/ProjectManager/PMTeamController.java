package com.grownited.controller.ProjectManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.UserEntity.Role;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.UserRepository;

@Controller
@RequestMapping("/pm")
public class PMTeamController {

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/addTeamMember")
	public String addTeamMember(Model model, @SessionAttribute("user") UserEntity user) {
		
		List<ProjectEntity> projects = projectRepository.findByAssignedTo(user.getUserId());
		List<UserEntity> developers = userRepository.findByRole(Role.DEVELOPER);
		model.addAttribute("projects", projects);
		model.addAttribute("developers", developers);
		
		return "ProjectManager/Team/AddTeamMember";
	}
	
	@PostMapping("/saveTeamMember")
	public String saveTeamMember() {
		return "";
	}
	
	@GetMapping("/viewTeamMembers")
	public String viewTeamMembers() {
		return "ProjectManager/Team/ViewTeamMembers";
	}
}
