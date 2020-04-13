package com.atul.main.model;

public class Movierating {

	int tempid;
	String userid;
	String movieid;
	int rating;
	
	public Movierating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movierating(int tempid, String userid, String movieid, int rating) {
		super();
		this.tempid = tempid;
		this.userid = userid;
		this.movieid = movieid;
		this.rating = rating;
	}
	
	
	public int getTempid() {
		return tempid;
	}
	public void setTempid(int tempid) {
		this.tempid = tempid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
