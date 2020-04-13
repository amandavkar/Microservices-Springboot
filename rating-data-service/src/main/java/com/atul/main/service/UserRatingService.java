package com.atul.main.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atul.main.model.Movierating;
import com.atul.main.model.RatingData;
import com.atul.main.model.Userdata;

@RestController
public class UserRatingService {
	
	@Autowired
	MovieRatingDAO mdao;
	
	@Autowired
	UserdataDAO udao;
	
	@RequestMapping(path="/userratings/{userid}", produces={"application/json"})
	public RatingData getMovieRatings(@PathVariable("userid") String userid) {
		
		Userdata user = udao.findById(userid).orElse(new Userdata());
		
		List<Movierating> movierating = (List<Movierating>) mdao.findByUserid(userid);
		if(movierating.isEmpty()) {
			return null;
		}
		RatingData rd = new RatingData(userid, user.getName(), movierating);
		return rd;
		
	}

}
