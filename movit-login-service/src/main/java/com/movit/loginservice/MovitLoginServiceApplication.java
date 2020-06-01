package com.movit.loginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.movit.loginservice")
@EnableDiscoveryClient

public class MovitLoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovitLoginServiceApplication.class, args);
	}

}
