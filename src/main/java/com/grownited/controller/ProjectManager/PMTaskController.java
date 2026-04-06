package com.grownited.controller.ProjectManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.TaskEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.UserRepository;

@Controller
@RequestMapping("/pm")
public class PMTaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/newTask")
	public String newTask(Model model) {
		
		List<UserEntity> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		
		return "ProjectManager/Task/NewTask";
	}
	
	@PostMapping("/createTask")
	public String saveTask(TaskEntity taskEntity) {
		
		taskRepository.save(taskEntity);
		
		return "redirect:/pm/tasksList";
	}
	
	@GetMapping("/tasksList")
	public String tasksList(Model model, @SessionAttribute("user") UserEntity user) {
		
		List<TaskEntity> tasksList = taskRepository.findByCreatedBy(user);
		model.addAttribute("tasksList", tasksList);
		
		return "ProjectManager/Task/TasksList";
	}
	
	@GetMapping("/deleteTask")
	public String deleteTask(Long taskId) {
		
		taskRepository.deleteById(taskId);
		
		return "redirect:/pm/tasksList";
	}

}
