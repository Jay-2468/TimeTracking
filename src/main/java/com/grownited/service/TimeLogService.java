package com.grownited.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.entity.TimeLogEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.TimeLogRepository;

@Service
public class TimeLogService {

	@Autowired
	private TimeLogRepository timeLogRepo;

	public TimeLogEntity getTimeLogById(Long logId) {

		TimeLogEntity log = timeLogRepo.findById(logId).orElseThrow(() -> new RuntimeException("TimeLog not found"));

		// Avoid Lazy Load Issues
		log.getUser().getFirstName();
		log.getProject().getProjectName();
		log.getTask().getTaskName();

		if (log.getApprovedBy() != null) {
			log.getApprovedBy().getFirstName();
		}

		return log;
	}

	public void updateTimeLog(TimeLogEntity updated) {

		TimeLogEntity existing = timeLogRepo.findById(updated.getLogId()).orElse(null);

		if (existing != null) {

			existing.setTask(updated.getTask());
			existing.setUser(updated.getUser());
			existing.setProject(updated.getProject());

			existing.setStartTime(updated.getStartTime());
			existing.setEndTime(updated.getEndTime());

			existing.setBreakStartTime(updated.getBreakStartTime());
			existing.setBreakEndTime(updated.getBreakEndTime());

			existing.setLogType(updated.getLogType());
			existing.setApprovalStatus(updated.getApprovalStatus());

			existing.setApprovedBy(updated.getApprovedBy());
			existing.setApprovalRemark(updated.getApprovalRemark());

			timeLogRepo.save(existing); // triggers @PreUpdate
		}
	}
	
	public TimeLogEntity findById(Long logId) {
		Optional<TimeLogEntity> opLog = timeLogRepo.findById(logId);
		TimeLogEntity log = null;
		if (opLog.isPresent()) {
			log = opLog.get();
		}
		return log;
	}
}
