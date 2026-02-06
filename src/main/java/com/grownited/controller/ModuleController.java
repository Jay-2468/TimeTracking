package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ModuleEntity;
import com.grownited.repository.ModuleRepository;

@Controller
public class ModuleController {
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@GetMapping("/newModule")
	public String newModule() { 
		return "NewModule";
	}
	
	@PostMapping("/createModule")
	public String createModule(ModuleEntity moduleEntity) {
		moduleRepository.save(moduleEntity);
		
		return "AdminDashboard";
	}
	
}
