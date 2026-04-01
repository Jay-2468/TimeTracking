package com.grownited.dto;

import java.time.LocalDateTime;

public class ForgotPasswordDto {

    private Long resetId;
   
    private Long userId; // instead of UserEntity
    
    private String email;
    
    private String otp;
    
    private LocalDateTime requestTime;
    
    private Boolean usedStatus;

    // Getters and Setters

    public Long getResetId() {
        return resetId;
    }

    public void setResetId(Long resetId) {
        this.resetId = resetId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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