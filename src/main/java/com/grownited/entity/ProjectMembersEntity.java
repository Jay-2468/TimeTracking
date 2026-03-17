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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
 
@Entity
@Table(name = "project_members")
@Getter
@Setter
public class ProjectMembersEntity {

	public enum Status {
		ACTIVE, REMOVED, COMPLETED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teamMemberId; // PK
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectEntity project; // FK - Drop down
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user; // FK - Drop down
	
	@Transient
	private String roleInProject; // Developer, Tester(QA), Designer(UX/UI), etc.
	
	@ManyToOne
	@JoinColumn(name = "assigned_by")
	private UserEntity assignedBy; // FK
	
	private LocalDate assignedDate;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	
	@PrePersist
	public void onCreate() {
		this.assignedDate = LocalDate.now();
	}
}
