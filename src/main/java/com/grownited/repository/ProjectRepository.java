package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ProjectEntity;
import com.grownited.entity.UserEntity;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>{

	List<ProjectEntity> findByAssignedTo(UserEntity assignedTo);
	
}
