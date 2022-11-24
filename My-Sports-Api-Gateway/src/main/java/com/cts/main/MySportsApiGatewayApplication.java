package com.cts.main;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class MySportsApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySportsApiGatewayApplication.class, args);
	}

	@Bean
	public CorsWebFilter corsWebFilter() {

		final CorsConfiguration corsConfig = new CorsConfiguration();

		corsConfig.setAllowedOrigins(Collections.singletonList("*"));

		corsConfig.setMaxAge(3600L);

		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST","PUT"));

		corsConfig.addAllowedHeader("*");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);

	}
}
