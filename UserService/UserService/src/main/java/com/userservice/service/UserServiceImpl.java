package com.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.dao.UserDao;
import com.userservice.entity.User;
import com.userservice.exceptions.ResourceNotFound;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
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
		return userDao.findById(id).orElseThrow(() -> new ResourceNotFound("No user with given id!"));
	}

	
}
