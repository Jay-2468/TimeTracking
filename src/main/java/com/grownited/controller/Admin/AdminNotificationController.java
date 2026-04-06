package com.grownited.controller.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.NotificationEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.NotificationRepository;
import com.grownited.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminNotificationController {
	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/createNotification")
	public String createNotification(Model model) {
		
		List<UserEntity> users = userRepo.findAll();
		model.addAttribute("users", users);
		
		return "Admin/Notification/SendNotification";
	}

	@PostMapping("/sendNotification")
	public String sendNotification(NotificationEntity notificationEntity) {
		
		notificationRepository.save(notificationEntity);
		
		return "redirect:/admin/notificationsList";
	}

	@GetMapping("/notificationsList")
	public String notificationsList(Model model) {
		
		List<NotificationEntity> notifications = notificationRepository.findAll();
		model.addAttribute("notifications", notifications);
		
		return "Admin/Notification/NotificationsList";
	}

	@GetMapping("/deleteNotification")
	public String deleteNotification(Long notificationId) {
		
		notificationRepository.deleteById(notificationId);
		
		return "redirect:/admin/notificationsList";
	}

	@GetMapping("/markAsRead")
	public String markAsRead(Long notificationId) {
		
		Optional<NotificationEntity> opNotification = notificationRepository.findById(notificationId);

		if (opNotification.isPresent()) {
			NotificationEntity notification = opNotification.get();
			notification.setStatus(NotificationEntity.Status.READ);
			notificationRepository.save(notification);
		}
		
		return "redirect:/admin/notificationsList";
	}
}
