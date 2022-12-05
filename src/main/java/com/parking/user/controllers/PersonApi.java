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

import com.parking.user.model.entity.PersonEntity;
import com.parking.user.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonApi {
	@Autowired
	PersonService service;
	
	@GetMapping("/all")
	public ArrayList<PersonEntity> getAll() {	
		return service.getAllUser();
	}
	@GetMapping("/find/{id}")
	public Optional<PersonEntity> getPersonById(
			@PathVariable("id") Integer id) {	
		return service.getUserById(id);
	}
	@PostMapping("/save")
	public PersonEntity getPersonById(
			@RequestBody PersonEntity person) {	
		return service.saveUser(person);
	}
	
}
