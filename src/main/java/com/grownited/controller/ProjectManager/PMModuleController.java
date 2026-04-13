package com.grownited.controller.ProjectManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.ModuleEntity;
import com.grownited.entity.ProjectEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.service.ModuleService;
import com.grownited.service.ProjectService;
import com.grownited.service.UserService;

@Controller
@RequestMapping("/pm")
public class PMModuleController {

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserService userService;

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

		model.addAttribute("modulesList", moduleRepository.findByCreatedByAndIsArchivedFalse(user));

		return "ProjectManager/Module/ModulesList";
	}

	@GetMapping("/archiveModule")
	public String archiveModule(Long moduleId) {

		moduleService.archiveModule(moduleId);

		return "redirect:/pm/modulesList";
	}

	@GetMapping("/editModule")
	public String editModule(@RequestParam("moduleId") Long moduleId, Model model) {

		ModuleEntity module = moduleService.findById(moduleId);

		model.addAttribute("module", module);

		// Enum
		model.addAttribute("statuses", ModuleEntity.ModuleStatus.values());

		// Dropdowns
		model.addAttribute("projects", projectService.getAllProjects());
		model.addAttribute("users", userService.findAll());

		return "ProjectManager/Module/EditModule";
	}

	@PostMapping("/updateModule")
	public String updateModule(ModuleEntity module) {
	    moduleService.updateModule(module);
	    return "redirect:/modulesList";
	}
	
	@GetMapping("/viewModule")
	public String viewModule(Long moduleId, Model model) {

	    ModuleEntity module = moduleService.getModuleById(moduleId);

	    model.addAttribute("module", module);

	    return "ProjectManager/Module/ViewModule";
	}
}
