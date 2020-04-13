package com.atul.main.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atul.main.model.Userdata;

public interface UserdataDAO extends JpaRepository<Userdata, String>{
	
	

}
