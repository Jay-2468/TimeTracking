package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ModuleEntity;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Integer> {

	
}
