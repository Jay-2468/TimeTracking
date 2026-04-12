package com.grownited.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.TimesheetEntity;
import com.grownited.entity.UserEntity;

@Repository
public interface TimesheetRepository extends JpaRepository<TimesheetEntity, Long> {

	List<TimesheetEntity> findByUser(UserEntity user);

	List<TimesheetEntity> findByStatus(TimesheetEntity.Status status);

	boolean existsByUserAndWeekStartAndWeekEnd(UserEntity user, LocalDate start, LocalDate end);

	@Query(value = """
			SELECT * FROM timesheets t WHERE t.employee_Id = :empId
			      AND t.create_date BETWEEN :start AND :end
			      AND t.status = 'APPROVED'
			      """, nativeQuery = true)
	List<TimesheetEntity> findApprovedTimesheets(Long empId, LocalDate start, LocalDate end);

}
