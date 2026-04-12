package com.grownited.controller.Developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.UserEntity;
import com.grownited.service.NotificationService;

@Controller
@RequestMapping("/developer")
public class DeveloperNotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@GetMapping("/viewNotifications")
	public String viewNotifications(Model model, @SessionAttribute("user") UserEntity user) {
		
		model.addAttribute("notifications", notificationService.getAllNotificationsOfUser(user));
		
		return "Developer/Notification/NotificationsList";
	}
	
	@GetMapping("/markAsRead")
	public String markAsRead(Long notificationId) {

		notificationService.markAsRead(notificationId);

		return "redirect:/developer/viewNotifications";
	}
}
