package com.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entity.User;

public interface UserDao extends JpaRepository<User, Long>{

	
}
