package com.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingservice.entities.Rating;
import com.ratingservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;

	//create
	@PostMapping("/add")
	public Rating addRating(@RequestBody Rating rating) {
		return ratingService.addRating(rating);
	}
	
	//get All
	@GetMapping("/all")
	public List<Rating> getAllRatings(){
		return ratingService.getAll();
	}
	
	//get By Id
	@GetMapping("/{id}")
	public Rating getById(@PathVariable Long id) {
		return ratingService.findById(id);
	}
	
	//get By hotel
	@GetMapping("/hotel/{id}")
	public Rating getByHotelId(@PathVariable Long id) {
		return ratingService.getByHotelId(id);
	}
	
	//get all ratings by userId
	@GetMapping("/user/{userId}")
	public List<Rating> getRatingsByUserId(@PathVariable Long userId){
		return ratingService.getByUserId(userId);
	}
}
