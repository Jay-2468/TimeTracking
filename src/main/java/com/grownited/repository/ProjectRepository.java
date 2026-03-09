package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ProjectEntity;
import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer>{

	List<ProjectEntity> findByAssignedTo(Integer assignedTo);
	
}
