package com.grownited.service;

import java.util.List;

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
}