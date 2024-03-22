package com.hotelservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelservice.dao.HotelDao;
import com.hotelservice.entities.Hotel;
import com.hotelservice.exception.ResourceNotFound;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{

	
	@Autowired
	private HotelDao hotelDao;
	
	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelDao.findAll();
	}

	@Override
	public Hotel findById(Long id) {
		return hotelDao.findById(id)
				.orElseThrow(() -> new ResourceNotFound("No hotel found with given Id"));
	}

	@Override
	public Hotel saveHotel(Hotel hotel) {
		return hotelDao.save(hotel);
	}	
}
