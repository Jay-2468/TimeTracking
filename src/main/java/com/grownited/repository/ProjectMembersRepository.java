package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ProjectMembersEntity;
import com.grownited.entity.UserEntity;

import java.util.List;
import com.grownited.entity.ProjectEntity;



@Repository
public interface ProjectMembersRepository extends JpaRepository<ProjectMembersEntity, Long>{

	List<ProjectMembersEntity> findByUser(UserEntity user);

	List<ProjectMembersEntity> findByProjectIn(List<ProjectEntity> projects);
}
