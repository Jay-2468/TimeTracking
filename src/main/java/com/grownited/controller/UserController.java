package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/userList")
	public String userList(Model model) {
		List<UserEntity> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		return "User/UserList";
	}

	@GetMapping("/viewUser")
	public String viewUser(Integer userId, Model model) {
		Optional<UserEntity> opUser = userRepository.findById(userId);
		if (opUser.isEmpty()) {
			return "";
		} else {
			UserEntity userEntity = opUser.get();
			model.addAttribute("user", userEntity);
			return "User/ViewUser";
		}

	}

	@GetMapping("/deleteUser")
	public String deleteUser(Integer userId) {
		userRepository.deleteById(userId);
		return "redirect:/userList";
	}
	
	@GetMapping("/newUser")
	public String newUser() {
		return "User/NewUser";
	}

	@PostMapping("/createUser")
	public String createUser(UserEntity userEntity) {
		userRepository.save(userEntity);
		return "redirect:/userList";
	}
}
