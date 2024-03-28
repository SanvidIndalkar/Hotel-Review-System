package com.userservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.dao.UserDao;
import com.userservice.entity.Hotel;
import com.userservice.entity.Rating;
import com.userservice.entity.User;
import com.userservice.exceptions.ResourceNotFound;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUser(Long id) {
		//get user
		User user = userDao.findById(id).orElseThrow(() -> new ResourceNotFound("No user with given id!"));
		
		//get ratings of the user
		Rating[] ratings = restTemplate.getForObject("http://RATINGSERVICE/ratings/user/" + id, Rating[].class);
		List<Rating> ratingList = Arrays.stream(ratings).toList();
		List<Rating> ratingsWithHotels = ratingList.stream().map(rating -> {
			ResponseEntity<Hotel> hotelResp = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelResp.getBody();
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingsWithHotels);
		return user;
	}

	
}
