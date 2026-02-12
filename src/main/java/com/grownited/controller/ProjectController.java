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
		return "Project/NewProject";
	}
	
	@PostMapping("/createProject") 
	public String saveProject(ProjectEntity projectEntity){ 
		
		projectRepository.save(projectEntity);
		
		return "redirect:/projectList";
	}
	
	@GetMapping("/projectList")
	public String projectList(Model model) {
		List<ProjectEntity> projectList = projectRepository.findAll();
		model.addAttribute("projectList", projectList);
		
		return "Project/ProjectList";
	}
	
	@GetMapping("/deleteProject")
	public String deleteProject(Integer projectId) { 
		projectRepository.deleteById(projectId);
		
		return "redirect:/projectList";
	}
}
