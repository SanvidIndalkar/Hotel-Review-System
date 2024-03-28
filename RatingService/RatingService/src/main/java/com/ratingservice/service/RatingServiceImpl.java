package com.ratingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingservice.dao.RatingDao;
import com.ratingservice.entities.Rating;
import com.ratingservice.exception.ResourceNotFound;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RatingServiceImpl implements RatingService{

	
	@Autowired
	private RatingDao ratingDao;
	
	@Override
	public Rating addRating(Rating rating) {
		return ratingDao.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return ratingDao.findAll();
	}

	@Override
	public Rating findById(Long id) {
		return ratingDao.findById(id).orElseThrow(() -> new ResourceNotFound("No rating found by given rating id"));
	}

	@Override
	public Rating getByHotelId(Long id) {
		return ratingDao.findByHotelId(id);
	}

	@Override
	public List<Rating> getByUserId(Long userId) {
		return ratingDao.findByUserId(userId);
	}

	
}
