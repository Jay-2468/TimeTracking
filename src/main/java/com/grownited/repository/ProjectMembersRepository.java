package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ProjectMembersEntity;
import com.grownited.entity.UserEntity;

import java.util.List;
import com.grownited.entity.ProjectEntity;

@Repository
public interface ProjectMembersRepository extends JpaRepository<ProjectMembersEntity, Long>{

	List<ProjectMembersEntity> findByAssignedTo(UserEntity assignedTo);

	List<ProjectMembersEntity> findByProjectInAndIsRemovedFalse(List<ProjectEntity> projects);
	
	@Query(value = """
			SELECT * FROM project_members pms
			WHERE project_id = :projectId
			""", nativeQuery = true)
	List<ProjectMembersEntity> findByProjectId(@Param("projectId") Long projectId);
	
	@Query(value = """
			SELECT COUNT(*) FROM project_members pms
			WHERE project_id = :projectId
			""", nativeQuery = true)
	Integer findTotalTeamMembers(@Param("projectId") Long projectId);
	
}
