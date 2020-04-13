package com.atul.main.model;

import java.util.List;

import com.atul.main.model.Movierating;

public class RatingData {
	
	String userid;
	String name;
	List<Movierating> movieRatings;
	
	public RatingData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingData(String userid, String name, List<Movierating> movieRatings) {
		super();
		this.userid = userid;
		this.name = name;
		this.movieRatings = movieRatings;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movierating> getMovieRatings() {
		return movieRatings;
	}

	public void setMovieRatings(List<Movierating> movieRatings) {
		this.movieRatings = movieRatings;
	}


}
