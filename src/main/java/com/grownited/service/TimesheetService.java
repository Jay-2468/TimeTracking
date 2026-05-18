package com.grownited.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.entity.TimesheetEntity;
import com.grownited.repository.TimesheetRepository;

@Service
public class TimesheetService {

	@Autowired
	private TimesheetRepository timesheetRepo;

	public TimesheetEntity getTimesheetById(Long timesheetId) {

		TimesheetEntity ts = timesheetRepo.findById(timesheetId)
				.orElseThrow(() -> new RuntimeException("Timesheet not found"));

		// Avoid Lazy Loading issues
		ts.getUser().getFirstName();

		if (ts.getApprovedBy() != null) {
			ts.getApprovedBy().getFirstName();
		}

		return ts;
	}

	public void updateTimesheet(TimesheetEntity updated) {

		TimesheetEntity existing = timesheetRepo.findById(updated.getTimesheetId()).orElse(null);

		if (existing != null) {

			existing.setUser(updated.getUser());
			existing.setWeekStart(updated.getWeekStart());
			existing.setWeekEnd(updated.getWeekEnd());

			existing.setStatus(updated.getStatus());
			existing.setApprovalRemark(updated.getApprovalRemark());
			existing.setApprovedBy(updated.getApprovedBy());

			// Optional: set approved time
			if (updated.getStatus() == TimesheetEntity.Status.APPROVED) {
				existing.setApprovedAt(LocalDateTime.now());
			}

			timesheetRepo.save(existing);
		}
	}

}
