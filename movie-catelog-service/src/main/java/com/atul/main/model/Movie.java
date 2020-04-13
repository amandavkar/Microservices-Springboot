package com.atul.main.model;

public class Movie {

	private String imdbid;
	private String title;
	private String plot;

	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String imdbid, String title, String plot) {
		super();
		this.imdbid = imdbid;
		this.title = title;
		this.plot = plot;
	}

	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	@Override
	public String toString() {
		return "Movie [imdbid=" + imdbid + ", title=" + title + ", plot=" + plot + "]";
	}

}
