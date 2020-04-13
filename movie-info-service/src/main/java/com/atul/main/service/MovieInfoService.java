package com.atul.main.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atul.main.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieInfoService {
	

    @Value("${api.key}")
    private String apiKey;
    
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/movieid/{movieid}", produces={"application/json"})
	public Movie getMovieById(@PathVariable("movieid") String movieid) {
		JSONObject jo = new JSONObject();
		jo = restTemplate.getForObject("http://www.omdbapi.com/?apikey="+apiKey+"&i="+movieid, JSONObject.class);
		Movie movie = new Movie((String)jo.get("imdbID"),(String)jo.get("Title"), (String)jo.get("Plot"));
		return movie;
		
	}
	
	@RequestMapping(path="/movietitle/{title}", produces={"application/json"})
	public Movie getMovieByTitle(@PathVariable("title") String title) {

		JSONObject jo = new JSONObject();
		jo = restTemplate.getForObject("http://www.omdbapi.com/?apikey="+apiKey+"&t="+title+"&r=json", JSONObject.class);
		Movie movie = new Movie((String)jo.get("imdbID"),(String)jo.get("Title"), (String)jo.get("Plot"));
		return movie;
		
	}

}
