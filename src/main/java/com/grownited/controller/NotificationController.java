package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.grownited.repository.NotificationRepository;

@Controller
public class NotificationController {

	@Autowired
	NotificationRepository notificationRepository;
	
	
}
