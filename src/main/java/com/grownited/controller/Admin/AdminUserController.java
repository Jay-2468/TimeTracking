package com.grownited.controller.Admin;

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
@RequestMapping("/admin")
public class AdminUserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/usersList")
	public String usersList(Model model) {
		
		List<UserEntity> usersList = userRepository.findAll();
		model.addAttribute("usersList", usersList);
		
		return "Admin/User/UsersList";
	}

	@GetMapping("/viewUser")
	public String viewUser(Integer userId, Model model) {
		
		Optional<UserEntity> opUser = userRepository.findById(userId);
		if (opUser.isEmpty()) {
			return "";
		} else {
			UserEntity userEntity = opUser.get();
			model.addAttribute("user", userEntity);
			return "Admin/User/ViewUser";
		}

	}

	@GetMapping("/deleteUser")
	public String deleteUser(Integer userId) {
		
		userRepository.deleteById(userId);
		
		return "redirect:/admin/usersList";
	}

	@GetMapping("/newUser")
	public String newUser() {
	
		return "Admin/User/NewUser";
	}

	@PostMapping("/createUser")
	public String createUser(UserEntity userEntity) {
		
		// Encrypting Password
		String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
		userEntity.setPassword(encodedPassword);

		userRepository.save(userEntity);
		
		return "redirect:/admin/usersList";
	}

	@GetMapping("/updateRole")
	public String updateRole(Model model) {
		
		List<UserEntity> usersList = userRepository.findAll();
		model.addAttribute("usersList", usersList);
		model.addAttribute("userRole", UserEntity.Role.values());
		
		return "Admin/User/UpdateUserRole";
	}

	@PostMapping("/updateUserRole")
	public String updateUserRole(UserEntity userEntity, Integer userId, UserEntity.Role newRole) {
		
		Optional<UserEntity> opUser = userRepository.findById(userId);

		if (opUser.isPresent()) {
			UserEntity user = opUser.get();
			user.setRole(newRole);
			userRepository.save(user);
		}
		
		return "redirect:/admin/usersList";
	}
}
