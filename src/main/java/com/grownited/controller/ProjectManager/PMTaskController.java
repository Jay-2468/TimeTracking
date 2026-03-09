package com.grownited.controller.ProjectManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ModuleEntity;
import com.grownited.entity.TaskEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.UserEntity.Role;
import com.grownited.repository.ModuleRepository;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.UserRepository;

@Controller
public class PMTaskController {

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	ModuleRepository moduleRepository;
	
	@GetMapping("/pm/newTask")
	public String newTask(Model model) {
		List<UserEntity> userList = userRepository.findByRole(Role.DEVELOPER);
		List<ModuleEntity> moduleList = moduleRepository.findAll();
		model.addAttribute("userList", userList);
		model.addAttribute("moduleList", moduleList);
		return "ProjectManager/Task/NewTask";
	}
	
	@PostMapping("/pm/createTask")
	public String saveTask(TaskEntity taskEntity) {
		taskRepository.save(taskEntity);
		return "redirect:/pm/tasksList";
	}

	@GetMapping("/pm/tasksList")
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
		
		return "ProjectManager/Task/TasksList";
	}
	
	@GetMapping("/pm/deleteTask")
	public String deleteTask(Integer taskId) {
		taskRepository.deleteById(taskId);
		return "redirect:/pm/tasksList";
	}

}
