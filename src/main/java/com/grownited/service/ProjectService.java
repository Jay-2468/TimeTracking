package com.grownited.service;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.entity.ProjectEntity;
import com.grownited.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	public List<ProjectEntity> getAllProjects() {
		return projectRepo.findAll();
	}

	public ProjectEntity getProjectById(Long projectId) {

		Optional<ProjectEntity> opProject = projectRepo.findById(projectId);

		return opProject.isPresent() ? opProject.get() : null;
	}

	public List<ProjectEntity> getAllProjectsNotDeleted() {
		return projectRepo.findByIsArchivedFalse();
	}
	
	public ProjectEntity findById(Long projectId) {
		Optional<ProjectEntity> opProject = projectRepo.findById(projectId);
		ProjectEntity project = null;
		if (opProject.isPresent()) {
			project = opProject.get();
		}
		return project;
	}

	public void archiveProject(Long projectId) {
		Optional<ProjectEntity> opProject = projectRepo.findById(projectId);
		ProjectEntity project = opProject.get();
		project.setIsArchived(true);
		projectRepo.save(project);
	}

	public void updateProject(ProjectEntity updatedProject) {

		ProjectEntity existing = projectRepo.findById(updatedProject.getProjectId()).orElse(null);

		if (existing != null) {

			existing.setProjectName(updatedProject.getProjectName());
			existing.setDescription(updatedProject.getDescription());

			//existing.setManager(updatedProject.getManager());

			//existing.setPriority(updatedProject.getPriority());

			existing.setStartDate(updatedProject.getStartDate());
			existing.setEndDate(updatedProject.getEndDate());

//			existing.setEstimatedHours(updatedProject.getEstimatedHours());

			projectRepo.save(existing);
		}
	}

	public List<ProjectEntity> findAll() {
		return projectRepo.findAll();
	}
}