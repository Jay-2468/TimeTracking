package com.grownited.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.entity.PayrollEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.PayrollRepository;
import com.grownited.repository.TimeLogRepository;
import com.grownited.repository.UserRepository;

@Service
public class PayrollService {

	@Autowired
	private PayrollRepository payrollRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private TimeLogRepository timeLogRepo;

	public PayrollEntity generatePayroll(Long userId, String monthStartDate, String monthEndDate, UserEntity user) {

		UserEntity userEntity = userRepo.findById(userId).get();

		PayrollEntity payroll = new PayrollEntity();

		LocalDate start = LocalDate.parse(monthStartDate);
		LocalDate end = LocalDate.parse(monthEndDate);

		BigDecimal totalHours = timeLogRepo.getTotalHoursForPayroll(userId, start, end);

		payroll.setUser(userEntity);
		payroll.setPeriodStartDate(start);
		payroll.setPeriodEndDate(end);
		payroll.setTotalHours(totalHours != null ? totalHours : BigDecimal.ZERO);
		payroll.setHourlyRate(userEntity.getHourlyRate());
		payroll.setGeneratedBy(user);

		return payrollRepo.save(payroll);
	}

	public void savePayroll(PayrollEntity payroll) {
		payrollRepo.save(payroll);
	}

	public List<PayrollEntity> getAllPayrollEntries() {
		return payrollRepo.findAll();
	}

	public void archivePayroll(Long payrollId) {

	}
	
	public PayrollEntity findById(Long payrollId) {
		Optional<PayrollEntity> opPayroll = payrollRepo.findById(payrollId);
		PayrollEntity payroll = null;
		if (opPayroll.isPresent()) {
			payroll = opPayroll.get();
		}
		return payroll;
	}

	public void updatePayroll(PayrollEntity updated) {

		PayrollEntity existing = payrollRepo.findById(updated.getPayrollId()).orElse(null);

		if (existing != null) {

			existing.setUser(updated.getUser());
			existing.setTotalHours(updated.getTotalHours());
			existing.setHourlyRate(updated.getHourlyRate());
			existing.setBonus(updated.getBonus());
			existing.setDeductions(updated.getDeductions());

			existing.setPaymentDate(updated.getPaymentDate());
			existing.setPeriodStartDate(updated.getPeriodStartDate());
			existing.setPeriodEndDate(updated.getPeriodEndDate());

			existing.setStatus(updated.getStatus());
			existing.setPaidBy(updated.getPaidBy());

			payrollRepo.save(existing); // triggers @PreUpdate
		}
	}
}
