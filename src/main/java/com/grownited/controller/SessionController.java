package com.grownited.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cloudinary.Cloudinary;
import com.grownited.entity.UserEntity;
import com.grownited.entity.UserEntity.Role;
import com.grownited.repository.UserRepository;
import com.grownited.service.EmailService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SessionController {

	// @Autowired is used to implement Singleton Design Pattern
	// this will assign same object to all the users and will not create new object
	// for every new user submits their data
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private Cloudinary cloudinary;
	
	@GetMapping("/signup")
	public String openSignupPage() {
		
		return "Authentication/Signup"; // Signup jsp file name
	}

	@GetMapping("/login")
	public String openLoginPage() {
		
		return "Authentication/Login"; // Login jsp file name
	}

	@PostMapping("/authenticate")
	public String authenticate(String email, String password, Model model, HttpSession session) {
		
		Optional<UserEntity> opUser = userRepository.findByEmail(email);

		if (opUser.isPresent()) {
			UserEntity dbUser = opUser.get();
			if (passwordEncoder.matches(password, dbUser.getPassword())) {
				session.setAttribute("user", dbUser);

				if (dbUser.getRole() == Role.ADMIN) {
					return "redirect:/admin-dashboard";
				} else if (dbUser.getRole() == Role.PROJECT_MANAGER) {
					return "redirect:/pm-dashboard";
				} else if (dbUser.getRole() == Role.DEVELOPER) {
					return "redirect:/developer-dashboard";
				}

				return "redirect:/admin-dashboard";
			}
		}
		model.addAttribute("error", "Invalid Credentials");

		return "Authentication/Login";
	}

	@PostMapping("/register") // this should be same as action value in the form
	public String register(UserEntity userEntity, MultipartFile profilePicture) {

		System.out.println(userEntity.getFirstName());
		System.out.println(userEntity.getLastName());
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getPassword());

		userEntity.setRole(Role.DEVELOPER);
		
		// Encrypting Password
		String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
		userEntity.setPassword(encodedPassword);
		
		// file uploading
		System.out.println(profilePicture.getOriginalFilename());
		try {
			Map map = cloudinary.uploader().upload(profilePicture.getBytes(), null);
			String profilePictureURL = map.get("secure_url").toString();
			userEntity.setProfilePictureURL(profilePictureURL);
			System.out.println(profilePictureURL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// we create Repository for every Entity/Database to separate the logic for
		// Database queries
		// for every Entity/Database there has to be a Repository (interface) file
		userRepository.save(userEntity); // this will insert the data into the table
		
		emailService.sendWelcomeMail(userEntity);

		return "redirect:/login";
	}
	
	@GetMapping("/admin/logout")
	public String adminLogout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/login";
	}
	
	@GetMapping("/pm/logout")
	public String pmLogout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/login";
	}
	
}
