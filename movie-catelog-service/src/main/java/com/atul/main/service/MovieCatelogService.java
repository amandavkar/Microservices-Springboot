package com.atul.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atul.main.model.Movie;
import com.atul.main.model.MovieCatelog;
import com.atul.main.model.Movierating;
import com.atul.main.model.RatingData;

@RestController
@RequestMapping("/moviecatelog")
public class MovieCatelogService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRating userRating;
	
	@RequestMapping(path="/user/{userid}", produces= {"application/json"})
	public List<MovieCatelog> getMovieCatelog(@PathVariable("userid") String userid) {
		RatingData rd = userRating.getUserRatings(userid);
		List<Movierating> mr = rd.getMovieRatings();
		return mr.stream()
				.map(movieRatings -> movieInfo.getMovieCatelog(movieRatings))
				.collect(Collectors.toList());
	}

}

