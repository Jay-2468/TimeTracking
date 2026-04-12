package com.grownited.controller.Developer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.ModuleEntity;
import com.grownited.entity.TaskEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.UserRepository;

@Controller
@RequestMapping("/developer")
public class DeveloperTaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModuleRepository moduleRepository;
	
	@GetMapping("/newTask")
	public String newTask(Model model) {
		
		List<UserEntity> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		
		return "Developer/Task/NewTask";
	}
	
	@PostMapping("/createTask")
	public String saveTask(TaskEntity taskEntity, Long moduleId) {
		
		ModuleEntity module = moduleRepository.findById(moduleId).get();
		taskEntity.setProject(module.getProject());
		taskRepository.save(taskEntity);
		
		return "redirect:/developer/tasksList";
	}
	
	@GetMapping("/tasksList")
	public String tasksList(Model model, @SessionAttribute("user") UserEntity user) {
		
		List<TaskEntity> tasksList = taskRepository.findByAssignedTo(user);
		model.addAttribute("tasksList", tasksList);
		
		return "Developer/Task/TasksList";
	}
	
}
