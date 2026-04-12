package com.grownited.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
	
	public PayrollEntity generatePayroll(Long userId, String monthStartDate, String monthEndDate, 
			UserEntity user) {

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

}
