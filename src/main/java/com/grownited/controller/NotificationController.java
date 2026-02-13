package com.grownited.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.NotificationEntity;
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
		notificationRepository.save(notificationEntity);
		return "redirect:/notificationsList";
	}
	
	@GetMapping("/notificationsList")
	public String notificationsList(Model model) {
		List<NotificationEntity> notificationsList = notificationRepository.findAll();
		model.addAttribute("notificationsList", notificationsList);
		return "/Notification/NotificationsList";
	}
	
	@GetMapping("/deleteNotification")
	public String deleteNotification(Integer notificationId) {
		notificationRepository.deleteById(notificationId);
		return "redirect:/notificationsList";
	}
}
