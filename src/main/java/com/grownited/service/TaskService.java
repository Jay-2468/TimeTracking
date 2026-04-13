package com.grownited.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.entity.TaskEntity;
import com.grownited.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;

	public void archiveTask(Long taskId) {
		Optional<TaskEntity> opTask = taskRepo.findById(taskId);
		if (opTask.isPresent()) {
			TaskEntity task = opTask.get();
			task.setIsArchived(true);
			taskRepo.save(task);
		}
	}

	public TaskEntity getTaskById(Long taskId) {

		Optional<TaskEntity> optional = taskRepo.findById(taskId);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new RuntimeException("Task not found with ID: " + taskId);
		}
	}

	public void updateTask(TaskEntity updated) {

		TaskEntity existing = taskRepo.findById(updated.getTaskId()).orElse(null);

		if (existing != null) {

			existing.setTaskName(updated.getTaskName());
			existing.setDescription(updated.getDescription());

			existing.setProject(updated.getProject());
			existing.setModule(updated.getModule());
			existing.setAssignedTo(updated.getAssignedTo());

			existing.setPriority(updated.getPriority());
			existing.setStatus(updated.getStatus());

			existing.setDeadline(updated.getDeadline());
			existing.setProgress(updated.getProgress());

			existing.setIsArchived(updated.getIsArchived());

			taskRepo.save(existing);
		}
	}

	public TaskEntity findById(Long taskId) {
		Optional<TaskEntity> opTask = taskRepo.findById(taskId);
		TaskEntity task = null;
		if (opTask.isPresent()) {
			task = opTask.get();
		}
		return task;
	}
}
