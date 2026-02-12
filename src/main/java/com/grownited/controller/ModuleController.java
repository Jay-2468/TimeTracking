package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ModuleEntity;
import com.grownited.entity.ProjectEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;

@Controller
public class ModuleController {
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@GetMapping("/newModule")
	public String newModule(Model model) { 
		List<ProjectEntity> projectList = projectRepository.findAll();
		model.addAttribute("projectList", projectList);
		return "Module/NewModule";
	}
	
	@PostMapping("/createModule")
	public String createModule(ModuleEntity moduleEntity) {
		moduleRepository.save(moduleEntity);
		return "redirect:/moduleList";
	}
	
	@GetMapping("/moduleList")
	public String moduleList(Model model) {
		List<ModuleEntity> moduleList = moduleRepository.findAll();
		model.addAttribute("moduleList", moduleList);		
		return "Module/ModuleList";
	}
	
	@GetMapping("/deleteModule")
	public String deleteModule(Integer moduleId) {
		moduleRepository.deleteById(moduleId);
		return "redirect:/moduleList";
	}
	
}
