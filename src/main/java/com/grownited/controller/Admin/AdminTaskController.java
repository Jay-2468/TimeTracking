package com.grownited.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.TaskEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminTaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/newTask")
	public String newTask(Model model) {
		
		List<UserEntity> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		
		return "Admin/Task/NewTask";
	}
	
	@PostMapping("/createTask")
	public String saveTask(TaskEntity taskEntity) {
		
		taskRepository.save(taskEntity);
		
		return "redirect:/admin/tasksList";
	}

	@GetMapping("/tasksList")
	public String tasksList(Model model) {
		
		List<TaskEntity> tasksList = taskRepository.findAll();
		model.addAttribute("tasksList", tasksList);
		
		return "Admin/Task/TasksList";
	}
	
	@GetMapping("/deleteTask")
	public String deleteTask(Integer taskId) {
		
		taskRepository.deleteById(taskId);
		
		return "redirect:/admin/tasksList";
	}

}
