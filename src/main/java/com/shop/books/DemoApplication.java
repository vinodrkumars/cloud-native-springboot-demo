package com.shop.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.shop.books.service.config.PolarProperties;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.ServerResponse.ok;
import static org.springframework.web.servlet.function.RouterFunctions.route;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;

@SpringBootApplication
@EnableConfigurationProperties(PolarProperties.class)
//@EnableCircuitBreaker //The @EnableCircuitBreaker annotation will scan the classpath for
// any compatible Circuit Breaker implementation.
//To use Hystrix explicitly, we have to annotate this class with @EnableHystrix:
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

	@Bean
	public Customizer<HystrixCircuitBreakerFactory> defaultConfig() {
		return factory -> factory.configureDefault(id -> HystrixCommand.Setter
				.withGroupKey(HystrixCommandGroupKey.Factory.asKey(id))
				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(3000)));
	}

}
