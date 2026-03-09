package com.grownited.controller.ProjectManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ModuleEntity;
import com.grownited.entity.ProjectEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class PMModuleController {

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	ProjectRepository projectRepository;

	@GetMapping("/pm/newModule")
	public String newModule(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<ProjectEntity> projectsList = projectRepository.findByAssignedTo(user.getUserId());
		model.addAttribute("projectsList", projectsList);
		return "ProjectManager/Module/NewModule";
	}

	@PostMapping("/pm/createModule")
	public String createModule(ModuleEntity moduleEntity) {
		moduleRepository.save(moduleEntity);
		return "redirect:/pm/modulesList";
	}

	@GetMapping("/pm/modulesList")
	public String modulesList(Model model) {
		List<ModuleEntity> modulesList = moduleRepository.findAll();
		List<ProjectEntity> projectList = projectRepository.findAll();
		Map<Integer, String> projectMap = new HashMap<>();

		for (ProjectEntity project : projectList) {
			projectMap.put(project.getProjectId(), project.getProjectName());
		}

		model.addAttribute("modulesList", modulesList);
		model.addAttribute("projectMap", projectMap);
		return "ProjectManager/Module/ModulesList";
	}

	@GetMapping("/pm/deleteModule")
	public String deleteModule(Integer moduleId) {
		moduleRepository.deleteById(moduleId);
		return "redirect:/pm/moduleList";
	}

}
