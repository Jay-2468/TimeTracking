package com.grownited.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.NotificationEntity;
import com.grownited.entity.NotificationEntity.Status;
import com.grownited.repository.NotificationRepository;

@Controller
public class NotificationController {
	@Autowired
	NotificationRepository notificationRepository;

	@GetMapping("/createNotification")
	public String createNotification() {
		return "/Notification/SendNotification";
	}

	@PostMapping("/sendNotification")
	public String sendNotification(NotificationEntity notificationEntity) {
		notificationEntity.setSentTime(LocalDateTime.now());
		notificationEntity.setStatus(Status.UNREAD);
		notificationRepository.save(notificationEntity);
		return "redirect:/notificationsList";
	}

	@GetMapping("/notificationsList")
	public String notificationsList(Model model) {
		List<NotificationEntity> notifications = notificationRepository.findAll();
		model.addAttribute("notifications", notifications);
		return "/Notification/NotificationsList";
	}

	@GetMapping("/deleteNotification")
	public String deleteNotification(Integer notificationId) {
		notificationRepository.deleteById(notificationId);
		return "redirect:/notificationsList";
	}

	@GetMapping("/markAsRead")
	public String markAsRead(Integer notificationId, Model model) {
		Optional<NotificationEntity> opNotification = notificationRepository.findById(notificationId);

		if (opNotification.isPresent()) {
			NotificationEntity notification = opNotification.get();
			notification.setStatus(NotificationEntity.Status.READ);
			notificationRepository.save(notification);
		}
		return "redirect:/notificationsList";
	}
}
