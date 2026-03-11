package com.grownited.controller.ProjectManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Controller
@RequestMapping("/pm")
public class PMUserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/usersList")
	public String usersList(Model model) {
		List<UserEntity> usersList = userRepository.findAll();
		model.addAttribute("usersList", usersList);
		return "ProjectManager/User/UsersList";
	}

	@GetMapping("/viewUser")
	public String viewUser(Integer userId, Model model) {
		Optional<UserEntity> opUser = userRepository.findById(userId);
		if (opUser.isEmpty()) {
			return "";
		} else {
			UserEntity userEntity = opUser.get();
			model.addAttribute("user", userEntity);
			return "ProjectManager/User/ViewUser";
		}

	}
}
