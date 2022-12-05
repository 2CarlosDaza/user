package com.parking.user.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.user.model.dto.LoginDto;
import com.parking.user.model.entity.UserEntity;
import com.parking.user.service.UserService;

@RestController
@RequestMapping("user")
public class userApi {
	@Autowired
	UserService service;
	@GetMapping("/hi")
	public String Saludar() {	return "Hola mundo";}
	
	@GetMapping("/all")
	public ArrayList<UserEntity> getAll() {	
		return service.getAllUser();
	}
	@GetMapping("/find/{id}")
	public Optional<UserEntity> getUserById(
			@PathVariable("id") Integer id) {	
		return service.getUserById(id);
	}
	@PostMapping("/save")
	public UserEntity getUserById(
			@RequestBody UserEntity user) {	
		return service.saveUser(user);
	}
	@PostMapping("/login")
	public Boolean getUserById(
			@RequestBody LoginDto loginDto) {	
		return service.login(loginDto);
	}
}
