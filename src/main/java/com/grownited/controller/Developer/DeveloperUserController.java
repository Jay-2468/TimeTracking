package com.grownited.controller.Developer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Controller
@RequestMapping("/developer")
public class DeveloperUserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/viewUser")
	public String viewUser(Long userId, Model model) {

		Optional<UserEntity> opUser = userRepository.findById(userId);
		if (opUser.isEmpty()) {
			return "";
		} else {
			UserEntity userEntity = opUser.get();
			model.addAttribute("user", userEntity);
			return "Developer/User/ViewUser";
		}
	}
}
