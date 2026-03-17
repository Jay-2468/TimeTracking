package com.grownited.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity // This will tell to hibernate that you have to create table for this
@Table(name = "users") // this will change the name of the table to users
@Getter
@Setter
public class UserEntity {

	public enum Status {
		ACTIVE, INACTIVE
	}

	public enum Role {
		ADMIN, PROJECT_MANAGER, DEVELOPER
	}

	@Id // This will create primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this will give auto_increment to the userId to MySQL query
	private Integer userId;
	
	private String firstName;
	
	private String lastName;
	
	private Integer contactNumber;
	
	private String email;
	
	private String password;
	
	private String profilePictureURL;

	private LocalDate createdAt;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private Role role; // users : admin, project manager, developers
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Status status; // status : Active / Inactive

	public String getFullUserName() {
		return firstName + lastName;
	}
}
