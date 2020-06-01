package com.movit.apigateway;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class MovitZuulApiGatewayApplication {

	public static void main(String[] args) {
		  Locale.setDefault(new Locale("en", "US"));
		SpringApplication.run(MovitZuulApiGatewayApplication.class, args);
	}

}
