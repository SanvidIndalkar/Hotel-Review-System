package com.hotelservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelservice.entities.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Long>{

	
}
