package com.atul.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userdata {

	@Id
	String userid;
	String name;
	
	public Userdata() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Userdata(String userid, String name) {
		super();
		this.userid = userid;
		this.name = name;
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
	
	
}
