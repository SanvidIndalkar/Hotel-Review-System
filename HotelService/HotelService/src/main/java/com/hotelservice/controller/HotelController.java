package com.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelservice.entities.Hotel;
import com.hotelservice.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired 
	private HotelService hotelService;
	
	@GetMapping("/all")
	public List<Hotel> getAllHotels() {
		return hotelService.getAllHotels();
	}
	
	@GetMapping("/{id}")
	public Hotel getHotel(@PathVariable Long id) {
		return hotelService.findById(id);
	}
	
	@PostMapping("/add")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}
			
}
