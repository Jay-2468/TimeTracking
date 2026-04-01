package com.grownited.controller.ProjectManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.ModuleEntity;
import com.grownited.entity.ProjectEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;

@Controller
@RequestMapping("/pm")
public class PMModuleController {

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@GetMapping("/newModule")
	public String newModule(Model model, @SessionAttribute("user") UserEntity user) {
		
		List<ProjectEntity> projectsList = projectRepository.findByAssignedTo(user);
		model.addAttribute("projectsList", projectsList);
		
		return "ProjectManager/Module/NewModule";
	}

	@PostMapping("/createModule")
	public String createModule(ModuleEntity moduleEntity, @SessionAttribute("user") UserEntity user) {
		
		moduleEntity.setCreatedBy(user);
		moduleRepository.save(moduleEntity);
		
		return "redirect:/pm/modulesList";
	}

	@GetMapping("/modulesList")
	public String modulesList(Model model, @SessionAttribute("user") UserEntity user) {
		
		List<ModuleEntity> modulesList = moduleRepository.findByCreatedBy(user);
		model.addAttribute("modulesList", modulesList);
		
		return "ProjectManager/Module/ModulesList";
	}

	@GetMapping("/deleteModule")
	public String deleteModule(Integer moduleId) {
		
		moduleRepository.deleteById(moduleId);
		
		return "redirect:/pm/modulesList";
	}

}
