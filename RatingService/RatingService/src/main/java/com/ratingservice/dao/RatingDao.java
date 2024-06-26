package com.ratingservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratingservice.entities.Rating;

public interface RatingDao extends JpaRepository<Rating, Long>{

	Rating findByHotelId(Long id);

	List<Rating> findByUserId(Long userId);
}
