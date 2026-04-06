package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.UserEntity.Role;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.UserRepository;


@Controller
@RequestMapping("/admin")
public class AdminProjectController {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/newProject")
	public String newProject(Model model) {
		
		List<UserEntity> userList = userRepository.findByRole(Role.PROJECT_MANAGER);
		model.addAttribute("pmList", userList);
		
		return "Admin/Project/NewProject";
	}
	
	@PostMapping("/createProject") 
	public String saveProject(ProjectEntity projectEntity){ 
		
		projectRepository.save(projectEntity);
		
		return "redirect:/admin/projectsList";
	}
	
	@GetMapping("/projectsList")
	public String projectsList(Model model) {
		
		List<ProjectEntity> projectsList = projectRepository.findAll();
		model.addAttribute("projectsList", projectsList);
		
		return "Admin/Project/ProjectsList";
	}
	
	@GetMapping("/deleteProject")
	public String deleteProject(Long projectId) { 
		
		projectRepository.deleteById(projectId);
		
		return "redirect:/admin/projectsList";
	}
	
}
