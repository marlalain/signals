package com.pauloelienay.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder builder) {
		return builder.routes().build();
	}
}
