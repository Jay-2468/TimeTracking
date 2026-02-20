package com.grownited.service;

import java.security.SecureRandom;
import org.springframework.stereotype.Service;

@Service
public class OtpService {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final int OTP_LENGTH = 6;

    public String generateOtp() {
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < OTP_LENGTH; i++) {
            int digit = secureRandom.nextInt(10); // 0-9
            otp.append(digit);
        }

        return otp.toString();
    }
}