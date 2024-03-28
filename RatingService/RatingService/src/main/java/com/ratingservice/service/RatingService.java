package com.ratingservice.service;

import java.util.List;

import com.ratingservice.entities.Rating;

public interface RatingService {

	Rating addRating(Rating rating);

	List<Rating> getAll();

	Rating findById(Long id);

	Rating getByHotelId(Long id);

	List<Rating> getByUserId(Long userId);

}
