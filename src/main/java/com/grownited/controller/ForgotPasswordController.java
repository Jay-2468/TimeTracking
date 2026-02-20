package com.grownited.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ForgotPasswordEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ForgotPasswordRepository;
import com.grownited.repository.UserRepository;
import com.grownited.service.OtpService;

@Controller
public class ForgotPasswordController {
	@Autowired
	ForgotPasswordRepository forgotPasswordRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	OtpService otpService;

	@GetMapping("/forgotPassword")
	public String openForgotPasswordPage() {
		return "Authentication/ForgotPassword"; // Login jsp file name
	}

	@GetMapping("/resetPassword")
	public String resetPassword() {
		return "Authentication/ResetPassword";
	}

	@PostMapping("/sendOTP")
	public String sendOTP(String email, ForgotPasswordEntity fp) {
		Optional<UserEntity> opUser = userRepository.findByEmail(email);

		if (opUser.isPresent()) {
			UserEntity user = opUser.get();
			String otp = otpService.generateOtp();
			fp.setUserId(user.getUserId());
			fp.setOtp(otp);
			fp.setUsedStatus(false);

			fp.setRequestTime(LocalDateTime.now());
			forgotPasswordRepository.save(fp);

			System.out.println("Generated otp: " + otp);

			return "redirect:/resetPassword";
		}
		return "redirect:/signup";
	}

	@PostMapping("/verifyOtpAndChangePassword")
	public String verifyOtpAndChangePassword(String email, String otp, String newPassword) {
		Optional<UserEntity> opUser = userRepository.findByEmail(email);

		if (opUser.isPresent()) {
			UserEntity user = opUser.get();
			Optional<ForgotPasswordEntity> opfp = forgotPasswordRepository.findTopByUserIdAndUsedStatusFalseOrderByRequestTimeDesc(user.getUserId());
			if (opfp.isPresent()) {
				ForgotPasswordEntity fp = opfp.get();
				if (fp.getOtp().equals(otp)) {
					user.setPassword(newPassword);
					userRepository.save(user);

					fp.setUsedStatus(true);
					forgotPasswordRepository.save(fp);

					return "redirect:/login";
				}
			}
		}

		return "redirect:/resetPassword";
	}

}
