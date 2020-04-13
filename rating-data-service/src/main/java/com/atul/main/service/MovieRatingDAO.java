package com.atul.main.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atul.main.model.Movierating;

public interface MovieRatingDAO extends JpaRepository<Movierating, String> {

	List<Movierating> findByUserid(String userid);

}
