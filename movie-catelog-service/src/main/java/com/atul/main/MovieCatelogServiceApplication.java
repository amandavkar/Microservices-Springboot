package com.atul.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class MovieCatelogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatelogServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
//		//set timeout for the restcontroller in order for throwing an error if the response is not received within 3 sec
//		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//		clientHttpRequestFactory.setConnectTimeout(3000);
//		return new RestTemplate(clientHttpRequestFactory);
		return new RestTemplate();
		
	}
}
