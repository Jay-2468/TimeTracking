package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.TimeSheetEntity;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheetEntity, Integer>{

	List<TimeSheetEntity> findByStatus(TimeSheetEntity.Status status); 
}
