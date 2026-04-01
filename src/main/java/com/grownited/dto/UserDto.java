package com.grownited.dto;

import java.time.LocalDateTime;

import com.grownited.entity.UserEntity;

public class UserDto {

	private Long userId;

	private String firstName;

	private String lastName;

	private Integer contactNumber;

	private String email;

	private String profilePictureURL;

	private UserEntity.Role role; // ADMIN / PROJECT_MANAGER / DEVELOPER

	private UserEntity.Status status; // ACTIVE / INACTIVE

	private LocalDateTime createdAt;

	// Optional: Full name helper
	private String fullUserName;

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

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfilePictureURL() {
		return profilePictureURL;
	}

	public void setProfilePictureURL(String profilePictureURL) {
		this.profilePictureURL = profilePictureURL;
	}

	public UserEntity.Role getRole() {
		return role;
	}

	public void setRole(UserEntity.Role role) {
		this.role = role;
	}

	public UserEntity.Status getStatus() {
		return status;
	}

	public void setStatus(UserEntity.Status status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getFullUserName() {
		return fullUserName;
	}

	public void setFullUserName(String fullUserName) {
		this.fullUserName = fullUserName;
	}

}