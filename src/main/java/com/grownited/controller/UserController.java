package com.grownited.controller;

import java.time.LocalDate;
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

	@GetMapping("/usersList")
	public String usersList(Model model) {
		List<UserEntity> usersList = userRepository.findAll();
		model.addAttribute("usersList", usersList);
		return "User/UsersList";
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
		return "redirect:/usersList";
	}

	@GetMapping("/newUser")
	public String newUser() {
		return "User/NewUser";
	}

	@PostMapping("/createUser")
	public String createUser(UserEntity userEntity) {
		userEntity.setCreatedAt(LocalDate.now());
		userRepository.save(userEntity);
		return "redirect:/usersList";
	}

	@GetMapping("/updateRole")
	public String updateRole(Model model) {
		List<UserEntity> usersList = userRepository.findAll();
		model.addAttribute("usersList", usersList);
		model.addAttribute("userRole", UserEntity.Role.values());
		return "User/UpdateUserRole";
	}

	@PostMapping("/updateUserRole")
	public String updateUserRole(UserEntity userEntity, Integer userId, UserEntity.Role newRole) {
		Optional<UserEntity> opUser = userRepository.findById(userId);

		if (opUser.isPresent()) {
			UserEntity user = opUser.get();
			user.setRole(newRole);
			userRepository.save(user);
		}
		return "redirect:/usersList";
	}
}
