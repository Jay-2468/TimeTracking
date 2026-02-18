package com.grownited.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.grownited.entity.UserEntity;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	ResourceLoader resourceLoader;

	public void sendWelcomeMail(UserEntity user) {
		MimeMessage message = javaMailSender.createMimeMessage();
		Resource resource = resourceLoader.getResource("classpath:templates/WelcomeMailTemplate.html");

		try {
			String html = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

			MimeMessageHelper helper;

			String body = html.replace("{{name}}", user.getFirstName()).replace("{{loginUrl}}",
					"http://localhost:9999/login");

			helper = new MimeMessageHelper(message, true);
			helper.setTo(user.getEmail());
			helper.setSubject("TimeTracking - Welcome aboard !!! ");
			helper.setText(body, true);

			javaMailSender.send(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
