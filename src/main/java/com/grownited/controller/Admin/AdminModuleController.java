package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.ModuleEntity;
import com.grownited.entity.ProjectEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.service.ModuleService;
import com.grownited.service.ProjectService;
import com.grownited.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminModuleController {

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

		model.addAttribute("modulesList", moduleRepository.findByIsArchivedFalse());

		return "Admin/Module/ModulesList";
	}

	@GetMapping("/archiveModule")
	public String archiveModule(Long moduleId) {

		moduleService.archiveModule(moduleId);

		return "redirect:/admin/modulesList";
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

		return "Admin/Module/EditModule";
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
