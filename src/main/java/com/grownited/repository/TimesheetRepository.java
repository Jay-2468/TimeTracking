package com.grownited.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.TimesheetEntity;
import com.grownited.entity.UserEntity;

@Repository
public interface TimesheetRepository extends JpaRepository<TimesheetEntity, Integer>{

	List<TimesheetEntity> findByUser(UserEntity user);
	
	List<TimesheetEntity> findByStatus(TimesheetEntity.Status status);

	boolean existsByUserAndWeekStartAndWeekEnd(UserEntity user, LocalDate start, LocalDate end); 
}
