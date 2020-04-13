package com.atul.main.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atul.main.model.Movierating;
import com.atul.main.model.RatingData;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class UserRating {
	
	@Autowired
	RestTemplate restTemplate;
	
//	//Bulkhead Pattern
//	@HystrixCommand(fallbackMethod="getFallbackUserRatings",
//			threadPoolKey="userInfoPool",
//			threadPoolProperties = {
//					@HystrixProperty(name = "coreSize", value = "20"),
//					@HystrixProperty(name = "maxQueueSize", value = "10"),
//			})
	
	//Circuit Breaker Pattern
	@HystrixCommand(fallbackMethod="getFallbackUserRatings",
			commandProperties = {
					@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value= "2000"),
					@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "5"),
					@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value = "20"),
					@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value = "1000")
			})		
	public RatingData getUserRatings(String userid) {
		return restTemplate.getForObject("http://user-rating-service/userratings/"+userid, RatingData.class);
	}
	
	public RatingData getFallbackUserRatings(String userid) {
		return new RatingData(userid, "Name not found", Arrays.asList(new Movierating(0,"","",0)));
	}

}
