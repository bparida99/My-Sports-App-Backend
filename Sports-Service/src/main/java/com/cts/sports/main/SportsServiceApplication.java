package com.cts.sports.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SportsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsServiceApplication.class, args);
	}

}
