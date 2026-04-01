package com.grownited.dto;

import java.time.LocalDateTime;

import com.grownited.entity.NotificationEntity;

public class NotificationDto {

    private Long notificationId;
    
    private Long sentToUserId;

    private String title;
    
    private String message;

    private NotificationEntity.NotificationType notificationType; 
    
    private LocalDateTime sentTime;

    private NotificationEntity.Status status; 

    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

    // Getters and Setters

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public Long getSentToUserId() {
        return sentToUserId;
    }

    public void setSentToUserId(Long sentToUserId) {
        this.sentToUserId = sentToUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationEntity.NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationEntity.NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(LocalDateTime sentTime) {
        this.sentTime = sentTime;
    }

    public NotificationEntity.Status getStatus() {
        return status;
    }

    public void setStatus(NotificationEntity.Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}