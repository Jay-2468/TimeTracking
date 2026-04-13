package com.grownited.controller.ProjectManager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.NotificationEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.NotificationEntity.NotificationType;
import com.grownited.entity.NotificationEntity.ReferenceType;
import com.grownited.repository.NotificationRepository;
import com.grownited.repository.UserRepository;
import com.grownited.service.NotificationService;

@Controller
@RequestMapping("/pm")
public class PMNotificationController {

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserRepository userRepo;

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

		List<NotificationEntity> notifications = notificationRepository.findAll();
		model.addAttribute("notifications", notifications);

		return "ProjectManager/Notification/NotificationsList";
	}

	@GetMapping("/deleteNotification")
	public String deleteNotification(Long notificationId) {

		notificationRepository.deleteById(notificationId);

		return "redirect:/pm/notificationsList";
	}

	@GetMapping("/markAsRead")
	public String markAsRead(Long notificationId, Model model) {

		Optional<NotificationEntity> opNotification = notificationRepository.findById(notificationId);

		if (opNotification.isPresent()) {
			NotificationEntity notification = opNotification.get();
			notification.setStatus(NotificationEntity.Status.READ);
			notificationRepository.save(notification);
		}

		return "redirect:/pm/notificationsList";
	}
}
