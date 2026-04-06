package com.grownited.controller.Developer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.TimesheetEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.TimeLogRepository;
import com.grownited.repository.TimesheetRepository;

@Controller
@RequestMapping("/developer")
public class DeveloperTimesheetController {

	@Autowired
	private TimesheetRepository timesheetRepo;

	@Autowired
	private TimeLogRepository timeLogRepo;

	@GetMapping("/createTimesheet")
	public String createTimesheet() {

		return "Developer/Timesheet/NewTimesheet";
	}

	@PostMapping("/saveTimesheet")
	public String saveTimeSheet(@SessionAttribute("user") UserEntity user, TimesheetEntity ts, String weekStart,
			String weekEnd) {

		LocalDate start = LocalDate.parse(weekStart);
		LocalDate end = LocalDate.parse(weekEnd);

		if (!start.plusDays(6).equals(end)) {
			return "redirect:/developer/createTimesheet?error=InvalidDateRange";
		}

		LocalDateTime startDate = start.atStartOfDay();
		LocalDateTime endDate = end.plusDays(1).atStartOfDay();

		boolean exists = timesheetRepo.existsByUserAndWeekStartAndWeekEnd(user, start, end);
		if (exists) {
			return "redirect:/developer/createTimesheet?error=AlreadyExists";
		}

		BigDecimal totalHours = timeLogRepo.findUserHoursBetweenDates(user.getUserId(), startDate, endDate);

		if (totalHours == null) {
			totalHours = BigDecimal.ZERO;
		}

		ts.setUser(user);
		ts.setWeekStart(start);
		ts.setWeekEnd(end);
		ts.setTotalHours(totalHours);

		timesheetRepo.save(ts);

		return "redirect:/developer/timesheetsList";
	}

	@GetMapping("/timesheetsList")
	public String timesheetsList(Model model, @SessionAttribute("user") UserEntity user) {

		List<TimesheetEntity> timesheetsList = timesheetRepo.findByUser(user);
		model.addAttribute("timesheetsList", timesheetsList);

		return "Developer/Timesheet/TimesheetsList";
	}

	@GetMapping("/deleteTimesheet")
	public String deleteTimesheet(Long timesheetId) {

		timesheetRepo.deleteById(timesheetId);

		return "redirect:/developer/timesheetsList";
	}
}
