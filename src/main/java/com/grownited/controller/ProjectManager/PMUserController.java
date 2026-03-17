package com.grownited.controller.ProjectManager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.UserEntity;
import com.grownited.entity.UserEntity.Role;
import com.grownited.repository.UserRepository;

@Controller
@RequestMapping("/pm")
public class PMUserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/developersList")
	public String developersList(Model model) {
		
		List<UserEntity> developers = userRepository.findByRole(Role.DEVELOPER);
		model.addAttribute("developers", developers);
		
		return "ProjectManager/User/DevelopersList";
	}

	@GetMapping("/viewDeveloper")
	public String viewDeveloper(Integer userId, Model model) {
		
		Optional<UserEntity> opUser = userRepository.findById(userId);
		if (opUser.isEmpty()) {
			return "";
		} else {
			UserEntity userEntity = opUser.get();
			model.addAttribute("user", userEntity);
			return "ProjectManager/User/ViewDeveloper";
		}

	}
}
