package com.grownited.controller.ProjectManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.ProjectMembersEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProjectMembersRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.repository.UserRepository;

@Controller
@RequestMapping("/pm")
public class PMProjectMembersController {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectMembersRepository pmsRepo;
	
	@GetMapping("/addTeamMember")
	public String addTeamMember(Model model, Long projectId, @SessionAttribute("user") UserEntity user) {
		
		List<ProjectMembersEntity> projects = pmsRepo.findByUser(user);
		model.addAttribute("projects", projects);
		
		return "ProjectManager/Team/AddTeamMember";
	}
	
	@GetMapping("/getUsersByProject")
	@ResponseBody
	public List<UserEntity> getUsersByProject(@RequestParam Long projectId) {

		return userRepository.findAvailableUsers(projectId, List.of("ADMIN", "PROJECT_MANAGER"));
	}
	
	@PostMapping("/saveTeamMember")
	public String saveTeamMember(ProjectMembersEntity pmsEntity, Long projectId, Long userId, @SessionAttribute("user") UserEntity user) {
		
		ProjectEntity project = projectRepository.findById(projectId).get();
		UserEntity userEntity = userRepository.findById(userId).get();
		pmsEntity.setProject(project);
		pmsEntity.setUser(userEntity);
		pmsEntity.setAssignedBy(user);
		pmsEntity.setRoleInProject("Developer");
		pmsRepo.save(pmsEntity);
		
		return "redirect:/pm/viewTeamMembers";
	}
	
	@GetMapping("/viewTeamMembers")
	public String viewTeamMembers(Model model, @SessionAttribute("user") UserEntity user) {
		
		List<ProjectMembersEntity> myAssignedProjects = pmsRepo.findByUser(user);
		
		List<ProjectEntity> myProjects = myAssignedProjects.stream()
				.map(ProjectMembersEntity::getProject).toList();
		
		List<ProjectMembersEntity> teamMembers = pmsRepo.findByProjectIn(myProjects);
		
		model.addAttribute("teamMembers", teamMembers);
		
		return "ProjectManager/Team/ViewTeamMembers";
	}
}
