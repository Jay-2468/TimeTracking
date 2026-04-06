package com.grownited.controller.ProjectManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.ProjectMembersEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProjectMembersRepository;


@Controller
@RequestMapping("/pm")
public class PMProjectController {

	@Autowired
	private ProjectMembersRepository pmsRepo;
	
	@GetMapping("/projectsList")
	public String projectsList(Model model, @SessionAttribute("user") UserEntity user) {
		
		List<ProjectMembersEntity> projectsList = pmsRepo.findByUser(user);
		model.addAttribute("projectsList", projectsList);
		
		return "ProjectManager/Project/ProjectsList";
	}
	
}
