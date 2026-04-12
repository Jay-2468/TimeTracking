package com.grownited.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.NotificationEntity.NotificationType;
import com.grownited.entity.NotificationEntity.ReferenceType;
import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import com.grownited.service.NotificationService;

@Controller
@RequestMapping("/admin")
public class AdminNotificationController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private NotificationService notificationService;

	@GetMapping("/createNotification")
	public String createNotification(Model model) {

		model.addAttribute("users", notificationService.getAllUsers());

		return "Admin/Notification/SendNotification";
	}

	@PostMapping("/sendNotification")
	public String sendNotification(Long sentTo, String title, String message, NotificationType notificationType,
			ReferenceType referenceType, @SessionAttribute("user") UserEntity sentBy) {

		UserEntity receiver = userRepo.findById(sentTo).orElseThrow(() -> new RuntimeException("User not found"));
		notificationService.sendNotification(receiver, title, message, notificationType, referenceType, sentBy);

		return "redirect:/admin/notificationsList";
	}

	@GetMapping("/notificationsList")
	public String notificationsList(Model model) {

		model.addAttribute("notifications", notificationService.getAllNotifications());

		return "Admin/Notification/NotificationsList";
	}

	@GetMapping("/deleteNotification")
	public String deleteNotification(Long notificationId) {

		notificationService.deleteNotification(notificationId);

		return "redirect:/admin/notificationsList";
	}

	@GetMapping("/markAsRead")
	public String markAsRead(Long notificationId) {

		notificationService.markAsRead(notificationId);

		return "redirect:/admin/notificationsList";
	}
}
