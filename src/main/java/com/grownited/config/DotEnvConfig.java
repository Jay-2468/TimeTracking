package com.grownited.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class DotEnvConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer loadConfiguration() {
		
		Dotenv dotenv = Dotenv.load();
		
		Properties props = new Properties();
		
		props.put("DB_URL", dotenv.get("DB_URL"));
		props.put("DB_USERNAME", dotenv.get("DB_USERNAME"));
		props.put("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		
		PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
		config.setProperties(props);
		
		return config;
	}
}
