package com.grownited.controller.ProjectManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	ModuleRepository moduleRepository;

	@Autowired
	ProjectRepository projectRepository;

	@GetMapping("/newModule")
	public String newModule(Model model, @SessionAttribute("user") UserEntity user) {
		
		List<ProjectEntity> projectsList = projectRepository.findByAssignedTo(user);
		model.addAttribute("projectsList", projectsList);
		
		return "ProjectManager/Module/NewModule";
	}

	@PostMapping("/createModule")
	public String createModule(ModuleEntity moduleEntity, @SessionAttribute("user") UserEntity user) {
		
		moduleEntity.setCreatedBy(user.getUserId());
		moduleRepository.save(moduleEntity);
		
		return "redirect:/pm/modulesList";
	}

	@GetMapping("/modulesList")
	public String modulesList(Model model, @SessionAttribute("user") UserEntity user) {
		List<ModuleEntity> modulesList = moduleRepository.findByCreatedBy(user.getUserId());
		List<ProjectEntity> projectList = projectRepository.findAll();
		Map<Integer, String> projectMap = new HashMap<>();

		for (ProjectEntity project : projectList) {
			projectMap.put(project.getProjectId(), project.getProjectName());
		}

		model.addAttribute("modulesList", modulesList);
		model.addAttribute("projectMap", projectMap);
		return "ProjectManager/Module/ModulesList";
	}

	@GetMapping("/deleteModule")
	public String deleteModule(Integer moduleId) {
		moduleRepository.deleteById(moduleId);
		return "redirect:/pm/modulesList";
	}

}
