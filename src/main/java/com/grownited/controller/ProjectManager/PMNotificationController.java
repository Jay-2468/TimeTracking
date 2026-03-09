package com.grownited.controller.ProjectManager;

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
public class PMNotificationController {
	@Autowired
	NotificationRepository notificationRepository;

	@GetMapping("/pm/createNotification")
	public String createNotification() {
		return "ProjectManager/Notification/SendNotification";
	}

	@PostMapping("/pm/sendNotification")
	public String sendNotification(NotificationEntity notificationEntity) {
		notificationEntity.setSentTime(LocalDateTime.now());
		notificationEntity.setStatus(Status.UNREAD);
		notificationRepository.save(notificationEntity);
		return "redirect:/pm/notificationsList";
	}

	@GetMapping("/pm/notificationsList")
	public String notificationsList(Model model) {
		List<NotificationEntity> notifications = notificationRepository.findAll();
		model.addAttribute("notifications", notifications);
		return "ProjectManager/Notification/NotificationsList";
	}

	@GetMapping("/pm/deleteNotification")
	public String deleteNotification(Integer notificationId) {
		notificationRepository.deleteById(notificationId);
		return "redirect:/pm/notificationsList";
	}

	@GetMapping("/pm/markAsRead")
	public String markAsRead(Integer notificationId, Model model) {
		Optional<NotificationEntity> opNotification = notificationRepository.findById(notificationId);

		if (opNotification.isPresent()) {
			NotificationEntity notification = opNotification.get();
			notification.setStatus(NotificationEntity.Status.READ);
			notificationRepository.save(notification);
		}
		return "redirect:/pm/notificationsList";
	}
}
