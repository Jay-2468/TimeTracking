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
@Table(name = "projects")
@Getter
@Setter
public class ProjectEntity {
	
	public enum Status {
		PLANNED, ONGOING, COMPLETED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	
	private String projectName;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "assigned_to")
	private UserEntity assignedTo; // FK - Drop Down
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	private Status status; // status : Planned / Ongoing / Completed

}
