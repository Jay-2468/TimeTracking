package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		
		return "UserList";
	}
	
	@GetMapping("/viewUser")
	public String viewUser(Integer userId, Model model) {
		
		Optional<UserEntity> opUser = userRepository.findById(userId);
		
		if(opUser.isEmpty()) { 
			return "";
		}
		else { 
			UserEntity userEntity = opUser.get();
			model.addAttribute("user", userEntity);
			return "ViewUser";
		}
		
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(Integer userId) {
		userRepository.deleteById(userId);
		
		return "redirect:/userList";
	}
}
