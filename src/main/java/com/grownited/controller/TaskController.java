package com.grownited.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.TaskEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.UserRepository;

@Controller
public class TaskController {

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/newTask")
	public String newTask(Model model) {
		List<UserEntity> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		return "Task/NewTask";
	}
	
	@PostMapping("/createTask")
	public String saveTask(TaskEntity taskEntity) {
		taskRepository.save(taskEntity);
		return "redirect:/tasksList";
	}

	@GetMapping("/tasksList")
	public String tasksList(Model model) {
//		if (assignedTo == null) 
//			return "redirect:/newTask";
		
//		Optional<UserEntity> opUser = userRepository.findById(assignedTo);
		
//		if (opUser.isEmpty()) 
//			return "redirect:/newTask";
		
//		UserEntity user = opUser.get();
		
		List<TaskEntity> tasksList = taskRepository.findAll();
		List<UserEntity> usersList = userRepository.findAll();
		Map<Integer, String> userMap = new HashMap<>();
		
		for(UserEntity user : usersList) {
			userMap.put(user.getUserId(), user.getFullUserName());
		}
		
		model.addAttribute("tasksList", tasksList);
		model.addAttribute("userMap", userMap);
//		model.addAttribute("user", user);
		
		return "Task/TasksList";
	}
	
	@GetMapping("/deleteTask")
	public String deleteTask(Integer taskId) {
		taskRepository.deleteById(taskId);
		return "redirect:/tasksList";
	}

}
