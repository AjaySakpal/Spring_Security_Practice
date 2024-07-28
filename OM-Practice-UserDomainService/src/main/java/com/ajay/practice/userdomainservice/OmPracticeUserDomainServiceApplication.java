package com.ajay.practice.userdomainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ajay.*"})
public class OmPracticeUserDomainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmPracticeUserDomainServiceApplication.class, args);
	}

}
