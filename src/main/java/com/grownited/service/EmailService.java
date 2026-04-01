package com.grownited.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.grownited.entity.ForgotPasswordEntity;
import com.grownited.entity.UserEntity;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private ResourceLoader resourceLoader;

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
			helper.setSubject("TimeTracking - Your Account is Ready !!! ");
			helper.setText(body, true);

			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendOtp(UserEntity user, ForgotPasswordEntity fp) {
		MimeMessage message = javaMailSender.createMimeMessage();
		Resource resource = resourceLoader.getResource("classpath:templates/OTPVerification.html");

		try {
			String html = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

			MimeMessageHelper helper;

			String body = html.replace("${name}", user.getFirstName()).replace("${otp}",
					String.valueOf(fp.getOtp()));

			helper = new MimeMessageHelper(message, true);
			helper.setTo(user.getEmail());
			helper.setSubject("TimeTracking - OTP Code for Verification");
			helper.setText(body, true);

			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
