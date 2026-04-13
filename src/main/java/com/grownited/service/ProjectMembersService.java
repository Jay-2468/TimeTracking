package com.grownited.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.entity.ProjectMembersEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProjectMembersRepository;

@Service
public class ProjectMembersService {

	@Autowired
	private ProjectMembersRepository pmsRepo;

	public List<ProjectMembersEntity> getProjectsAssignedToUser(UserEntity user) {
		return pmsRepo.findByAssignedTo(user);
	}

	public List<ProjectMembersEntity> getTeamMembersByProject(Long projectId) {
		return pmsRepo.findByProjectId(projectId);
	}

	public Integer getTotalTeamMembers(Long projectId) {
		return pmsRepo.findTotalTeamMembers(projectId);
	}

	public void removeDeveloper(Long userId) {
		Optional<ProjectMembersEntity> opUser = pmsRepo.findById(userId);
		if (opUser.isPresent()) {
			ProjectMembersEntity user = opUser.get();
			user.setIsRemoved(true);
			pmsRepo.save(user);
		}
	}
}
