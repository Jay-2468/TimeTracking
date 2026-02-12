package com.grownited.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SessionController {
	
	// @Autowired is used to implement Singleton Design Pattern
	// this will assign same object to all the users and will not create new object for every new user submits their data
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/signup")
	public String openSignupPage() {
		return "Authentication/Signup"; // Signup jsp file name
	}
	
	@GetMapping("/login")
	public String openLoginPage() {
		return "Authentication/Login"; // Login jsp file name
	}

	@GetMapping("/forgotPassword")
	public String openForgotPasswordPage() {
		return "Authentication/ForgotPassword"; // Login jsp file name
	}
	
	@PostMapping("/register") // this should be same as action value in the form
	public String register(UserEntity userEntity) {
		
		System.out.println(userEntity.getFirstName());
		System.out.println(userEntity.getLastName());
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getPassword());
		
		// userEntity.setRole("DEVELOPER");
		userEntity.setCreatedAt(LocalDate.now());
		
		// we create Repository for every Entity/Database to separate the logic for Database queries
		// for every Entity/Database there has to be a Repository (interface) file
		userRepository.save(userEntity); // this will insert the data into the table
		
		return "redirect:/login";
	}
	
}
