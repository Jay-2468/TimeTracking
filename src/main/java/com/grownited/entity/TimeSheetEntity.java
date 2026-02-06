package com.grownited.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "time_sheets")
public class TimeSheetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer timesheetId;
	private Integer userId; // FK
	private LocalDate weekStart;
	private LocalDate weekEnd;
	private Double totalHours;
	private String status; // status : Submitted / Approved / Rejected
	
	
	public Integer getTimesheetId() {
		return timesheetId;
	}
	public void setTimesheetId(Integer timesheetId) {
		this.timesheetId = timesheetId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public LocalDate getWeekStart() {
		return weekStart;
	}
	public void setWeekStart(LocalDate weekStart) {
		this.weekStart = weekStart;
	}
	public LocalDate getWeekEnd() {
		return weekEnd;
	}
	public void setWeekEnd(LocalDate weekEnd) {
		this.weekEnd = weekEnd;
	}
	public Double getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
