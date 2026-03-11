package com.grownited.controller.ProjectManager;

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

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/pm")
public class PMProjectController {

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/newProject")
	public String newProject(Model model) {
		List<UserEntity> userList = userRepository.findByRole(Role.PROJECT_MANAGER);
		model.addAttribute("pmList", userList);
		
		return "ProjectManager/Project/NewProject";
	}
	
	@PostMapping("/createProject") 
	public String saveProject(ProjectEntity projectEntity){ 
		
		projectRepository.save(projectEntity);
		
		return "redirect:/pm/projectsList";
	}
	
	@GetMapping("/projectsList")
	public String projectsList(ProjectEntity projectEntity, Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<ProjectEntity> projectsList = projectRepository.findByAssignedTo(user.getUserId());
		
		return "ProjectManager/Project/ProjectsList";
	}
	
	@GetMapping("/deleteProject")
	public String deleteProject(Integer projectId) { 
		projectRepository.deleteById(projectId);
		
		return "redirect:/pm/projectsList";
	}
}
