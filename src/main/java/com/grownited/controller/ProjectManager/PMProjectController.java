package com.grownited.controller.ProjectManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.UserEntity.Role;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class PMProjectController {

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/pm/newProject")
	public String newProject(Model model) {
		List<UserEntity> userList = userRepository.findByRole(Role.PROJECT_MANAGER);
		model.addAttribute("pmList", userList);
		
		return "ProjectManager/Project/NewProject";
	}
	
	@PostMapping("/pm/createProject") 
	public String saveProject(ProjectEntity projectEntity){ 
		
		projectRepository.save(projectEntity);
		
		return "redirect:/pm/projectsList";
	}
	
	@GetMapping("/pm/projectsList")
	public String projectsList(ProjectEntity projectEntity, Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<ProjectEntity> projectsList = projectRepository.findByAssignedTo(user.getUserId());
		
		return "ProjectManager/Project/ProjectsList";
	}
	
	@GetMapping("/pm/deleteProject")
	public String deleteProject(Integer projectId) { 
		projectRepository.deleteById(projectId);
		
		return "redirect:/pm/projectsList";
	}
}
