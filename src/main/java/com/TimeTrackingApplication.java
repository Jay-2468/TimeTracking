package com;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cloudinary.Cloudinary;

@SpringBootApplication
public class TimeTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeTrackingApplication.class, args);
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	Cloudinary getCloudinary() {
		Map<String, String> config = new HashMap<>();
		config.put("cloud_name", "dd3wenmbz");
		config.put("api_key", "155222639273967");
		config.put("api_secret", "fBw7N922hfSSo6hxi815i2JO-9A\n");
		return new Cloudinary(); 
	}
	
}
