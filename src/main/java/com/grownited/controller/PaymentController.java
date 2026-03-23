package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.grownited.entity.UserEntity;
import com.grownited.service.PaymentService;


@Controller
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping("/charge")
	public String charge() {
		return "ChargeCreditCard";
	}

	@PostMapping("charge")
	public String chargeCreditCard(String cardNumber, String expMonth, String expYear, 
			Double amount, @SessionAttribute("user") UserEntity user) {

		String email = user.getEmail();
		paymentService.chargeCreditCard(email, cardNumber, expMonth + expYear, amount);

		// logic -> payment gateway
		return "ChargeCreditCard";
	}
}