package com.grownited.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class TaskEntity {

	public enum Priority {
		HIGH, MEDIUM, LOW
	}

	public enum Status {
		PENDING, IN_PROGRESS, COMPLETED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;
	
	private String taskName;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Priority priority; // priorities : High / Medium / Low
	
	private LocalDate deadline;
	
	@Enumerated(EnumType.STRING)
	private Status status; // status : Pending / In Progress / Completed
	
	@ManyToOne
	@JoinColumn(name = "module_id")
	private ModuleEntity moduleId; // FK // drop-down
	
	@ManyToOne
	@JoinColumn(name = "assigned_to")
	private UserEntity assignedTo; // FK // drop-down
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private UserEntity createdBy; // FK

}
