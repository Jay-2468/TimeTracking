package com.grownited.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grownited.entity.NotificationEntity;
import com.grownited.entity.NotificationEntity.NotificationType;
import com.grownited.entity.NotificationEntity.ReferenceType;
import com.grownited.entity.UserEntity;
import com.grownited.repository.NotificationRepository;
import com.grownited.repository.UserRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private UserRepository userRepo;

	public List<UserEntity> getAllUsers() {
		return userRepo.findAll();
	}

	public void sendNotification(UserEntity sentTo, String title, String message, NotificationType notificationType,
			ReferenceType referenceType, UserEntity sentBy) {

		NotificationEntity notification = new NotificationEntity();

		// Save in DB
		notification.setSentTo(sentTo);
		notification.setTitle(title);
		notification.setMessage(message);
		notification.setNotificationType(notificationType);
		notification.setReferenceType(referenceType);
		notification.setSentBy(sentBy);

		// expire after 2 hours
		// notification.setExpiryTime(LocalDateTime.now().plusHours(2));

		notificationRepository.save(notification);

	}

	public List<NotificationEntity> getAllNotifications() {
		return notificationRepository.findAll();
	}

	public void deleteNotification(Long notificationId) {
		notificationRepository.deleteById(notificationId);
	}

	public void markAsRead(Long notificationId) {

		Optional<NotificationEntity> opNotification = notificationRepository.findById(notificationId);

		if (opNotification.isPresent()) {
			NotificationEntity notification = opNotification.get();
			notification.setStatus(NotificationEntity.Status.READ);
			notificationRepository.save(notification);
		}
	}
	
	public List<NotificationEntity> getAllNotificationsOfUser(UserEntity user) {
		return notificationRepository.findBySentTo(user);
	}
	
}
