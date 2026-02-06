package com.grownited.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notifications")
public class NotificationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notificationId;
	private Integer userId; // FK
	private String message;
	private String notificationType; // the types : Deadline / Idle / Alert
	private LocalDateTime sentTime;
	private String status; // status : Read / Unread
	
	
	public Integer getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
	public LocalDateTime getSentTime() {
		return sentTime;
	}
	public void setSentTime(LocalDateTime sentTime) {
		this.sentTime = sentTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
