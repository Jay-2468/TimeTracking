package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.ModuleEntity;
import com.grownited.entity.ProjectEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;

@Controller
@RequestMapping("/admin")
public class AdminModuleController {

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@GetMapping("/newModule")
	public String newModule(Model model) {
		
		List<ProjectEntity> projectsList = projectRepository.findAll();
		model.addAttribute("projectsList", projectsList);

		return "Admin/Module/NewModule";
	}

	@PostMapping("/createModule")
	public String createModule(ModuleEntity moduleEntity) {
		
		moduleRepository.save(moduleEntity);
		
		return "redirect:/admin/modulesList";
	}

	@GetMapping("/modulesList")
	public String modulesList(Model model) {
		
		List<ModuleEntity> modulesList = moduleRepository.findAll();
		model.addAttribute("modulesList", modulesList);
		
		return "Admin/Module/ModulesList";
	}

	@GetMapping("/deleteModule")
	public String deleteModule(Long moduleId) {
		
		moduleRepository.deleteById(moduleId);
		
		return "redirect:/admin/moduleList";
	}

}
