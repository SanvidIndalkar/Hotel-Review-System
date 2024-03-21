package com.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entity.User;
import com.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	public UserService userService;
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User userSaved = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable Long id){
		User user = userService.getUser(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(user);
	}
}
