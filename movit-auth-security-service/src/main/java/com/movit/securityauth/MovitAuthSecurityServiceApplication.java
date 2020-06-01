package com.movit.securityauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovitAuthSecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovitAuthSecurityServiceApplication.class, args);
	}

}
