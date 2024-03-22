package com.hotelservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelservice.entities.Hotel;

import jakarta.transaction.Transactional;


public interface HotelService {

	List<Hotel> getAllHotels();

	Hotel findById(Long id);

	Hotel saveHotel(Hotel hotel);
	
}
