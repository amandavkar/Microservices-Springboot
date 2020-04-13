package com.atul.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atul.main.model.Movie;
import com.atul.main.model.MovieCatelog;
import com.atul.main.model.Movierating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieInfo {
	
	@Autowired
	RestTemplate restTemplate;
	
//	//Bulkhead Pattern
//	@HystrixCommand(fallbackMethod="getFallbackUserRatings",
//			threadPoolKey="movieInfoPool",
//			threadPoolProperties = {
//					@HystrixProperty(name = "coreSize", value = "20"),
//					@HystrixProperty(name = "maxQueueSize", value = "10"),
//			})
	
	//Circuit Breaker Pattern
	@HystrixCommand(fallbackMethod="getFallbackMovieCatelog",
			commandProperties = {
					@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value= "2000"),
					@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "5"),
					@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value = "20"),
					@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value = "1000")
			})
	public MovieCatelog getMovieCatelog(Movierating movieRatings) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movie/movieid/"+movieRatings.getMovieid(), Movie.class);
		return new MovieCatelog(movie.getImdbid(), movie.getTitle(), movieRatings.getRating());
	}
	
	public MovieCatelog getFallbackMovieCatelog(Movierating movieRatings) {
		return new MovieCatelog(movieRatings.getMovieid(),"Movie not found", 0);		
	}

}
