package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ModuleEntity;
import com.grownited.entity.UserEntity;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Integer> {

	List<ModuleEntity> findByCreatedBy(UserEntity createdBy);
}
