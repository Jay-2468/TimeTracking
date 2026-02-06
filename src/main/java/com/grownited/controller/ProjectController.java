package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ProjectEntity;
import com.grownited.repository.ProjectRepository;


@Controller
public class ProjectController {

	@Autowired
	ProjectRepository projectRepository;
	
	@GetMapping("/newProject")
	public String newProject() {
		return "NewProject";
	}
	
	@PostMapping("/createProject") 
	public String saveProject(ProjectEntity projectEntity){ 
		
		projectRepository.save(projectEntity);
		
		return "AdminDashboard";
	}
	
	@GetMapping("/projectList")
	public String projectList(Model model) {
		List<ProjectEntity> projectList = projectRepository.findAll();
		model.addAttribute("projectList", projectList);
		
		return "ProjectList";
	}
}
