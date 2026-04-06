package com;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cloudinary.Cloudinary;
import com.grownited.config.CloudinaryConfig;

@ConfigurationPropertiesScan
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
	Cloudinary getCloudinary(CloudinaryConfig configObj) {
		Map<String, String> config = new HashMap<>();
		config.put("cloud_name", configObj.getCloudName());
		config.put("api_key", configObj.getApiKey());
		config.put("api_secret", configObj.getApiSecret());
		return new Cloudinary(config);
	}

}
