package com.grownited.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grownited.entity.TimeLogEntity;
import com.grownited.entity.UserEntity;

@Repository
public interface TimeLogRepository extends JpaRepository<TimeLogEntity, Long> {

	List<TimeLogEntity> findByUser(UserEntity user);
	
	@Query(value = """
			SELECT SUM(t.total_hours)
			FROM time_logs t
			WHERE t.user_id = :user_id
			AND t.start_time < :end_date
			AND t.end_time >= :start_date
			AND t.is_deleted = false
			""", nativeQuery = true)
	BigDecimal findUserHoursBetweenDates(@Param("user_id") Long userId, @Param("start_date") LocalDateTime startDate,
			@Param("end_date") LocalDateTime endDate);
	
	List<TimeLogEntity> findByTask_CreatedByAndIsDeletedFalse(UserEntity user);
}
