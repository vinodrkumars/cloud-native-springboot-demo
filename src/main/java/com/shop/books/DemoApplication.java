package com.shop.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.shop.books.service.config.PolarProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.ServerResponse.ok;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@SpringBootApplication
@EnableConfigurationProperties(PolarProperties.class)
public class DemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		log.info("Starting Spring Boot Application....");
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	RouterFunction<ServerResponse> routes(PolarProperties properties){
		return route(GET("/"), request -> ok().body(properties.getGreeting()));
	}


}
