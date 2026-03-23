package com.grownited.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "forgot_password")
public class ForgotPasswordEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resetId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user; // FK
	
	private String email;

	private String otp;
	
	private LocalDateTime requestTime;
	
	private Boolean usedStatus;

	public Long getResetId() {
		return resetId;
	}

	public void setResetId(Long resetId) {
		this.resetId = resetId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public LocalDateTime getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(LocalDateTime requestTime) {
		this.requestTime = requestTime;
	}

	public Boolean getUsedStatus() {
		return usedStatus;
	}

	public void setUsedStatus(Boolean usedStatus) {
		this.usedStatus = usedStatus;
	}
	
	

}
