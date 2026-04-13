package com.grownited.controller.ProjectManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.TaskEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.TaskRepository;
import com.grownited.repository.UserRepository;
import com.grownited.service.ModuleService;
import com.grownited.service.ProjectService;
import com.grownited.service.TaskService;
import com.grownited.service.UserService;

@Controller
@RequestMapping("/pm")
public class PMTaskController {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/newTask")
	public String newTask(Model model) {

		List<UserEntity> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		model.addAttribute("modules", moduleService.findAll());
		
		return "ProjectManager/Task/NewTask";
	}

	@PostMapping("/createTask")
	public String saveTask(TaskEntity taskEntity) {

		taskRepository.save(taskEntity);

		return "redirect:/pm/tasksList";
	}

	@GetMapping("/tasksList")
	public String tasksList(Model model, @SessionAttribute("user") UserEntity user) {

		List<TaskEntity> tasksList = taskRepository.findByCreatedByAndIsArchivedFalse(user);
		model.addAttribute("tasksList", tasksList);

		return "ProjectManager/Task/TasksList";
	}

	@GetMapping("/archiveTask")
	public String archiveTask(Long taskId) {

		taskService.archiveTask(taskId);

		return "redirect:/pm/modulesList";
	}

	@GetMapping("/viewTask")
	public String viewTask(Long taskId, Model model) {

		TaskEntity task = taskService.getTaskById(taskId);

		model.addAttribute("task", task);

		return "ProjectManager/Task/ViewTask";
	}
	
	@GetMapping("/editTask")
	public String editTask(@RequestParam("taskId") Long taskId, Model model) {

	    TaskEntity task = taskService.findById(taskId);

	    model.addAttribute("task", task);

	    // Enums
	    model.addAttribute("priorities", TaskEntity.TaskPriority.values());
	    model.addAttribute("statuses", TaskEntity.TaskStatus.values());

	    // Dropdown data
	    model.addAttribute("projects", projectService.findAll());
	    model.addAttribute("modules", moduleService.findAll());
	    model.addAttribute("users", userService.findAll());

	    return "Admin/Task/EditTask";
	}
	
	@PostMapping("/updateTask")
	public String updateTask(TaskEntity task) {
	    taskService.updateTask(task);
	    return "redirect:/tasksList";
	}
}
