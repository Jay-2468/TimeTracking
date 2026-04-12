package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grownited.entity.TaskEntity;
import com.grownited.entity.UserEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long>{
	
	List<TaskEntity> findByCreatedBy(UserEntity user);
	
	List<TaskEntity> findByAssignedTo(UserEntity assignedTo);

	@Query(value = """
			SELECT * FROM tasks t 
			WHERE t.project_Id = :projectId
			""", nativeQuery = true)
	List<TaskEntity> findByProject(@Param("projectId") Long projectId);
}
