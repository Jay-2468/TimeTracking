package com.grownited.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ForgotPasswordEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer resetId;
	private Integer userId; // FK
	private String email;
	private String otp;
	private LocalDateTime requestTime;
	private Boolean usedStatus;

	public Integer getResetId() {
		return resetId;
	}

	public void setResetId(Integer resetId) {
		this.resetId = resetId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
