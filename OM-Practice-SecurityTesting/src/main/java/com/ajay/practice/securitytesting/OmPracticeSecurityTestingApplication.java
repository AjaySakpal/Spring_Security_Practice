package com.ajay.practice.securitytesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
@SpringBootApplication(scanBasePackages = {"com.ajay.*"},exclude = SecurityAutoConfiguration.class)
@PropertySources(value = {
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:tokenconfigs.properties")
})
public class OmPracticeSecurityTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmPracticeSecurityTestingApplication.class, args);
	}

}
