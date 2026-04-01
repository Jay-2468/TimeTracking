package com.grownited.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // This will tell to hibernate that you have to create table for this
@Table(name = "users") // this will change the name of the table to users
public class UserEntity {

	public enum Status {
		ACTIVE, INACTIVE
	}

	public enum Role {
		ADMIN, PROJECT_MANAGER, DEVELOPER
	}

	@Id // This will create primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this will give auto_increment to the userId to MySQL query
	private Long userId;

	private String firstName;

	private String lastName;

	private String contactNumber;

	private String email;

	private String password;

	private String profilePictureURL;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private Role role; // users : admin, project manager, developers

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Status status; // status : Active / Inactive

	public String getFullUserName() {
		return firstName + lastName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePictureURL() {
		return profilePictureURL;
	}

	public void setProfilePictureURL(String profilePictureURL) {
		this.profilePictureURL = profilePictureURL;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
