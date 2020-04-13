package com.atul.main.model;

public class MovieCatelog {

	String movieid;
	String name;
	int rating;
	
	public MovieCatelog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieCatelog(String movieid, String name, int rating) {
		super();
		this.movieid = movieid;
		this.name = name;
		this.rating = rating;
	}
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
}
