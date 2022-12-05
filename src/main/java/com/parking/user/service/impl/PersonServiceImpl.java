package com.parking.user.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.user.model.entity.PersonEntity;
import com.parking.user.repository.PersonRepository;
import com.parking.user.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	PersonRepository repository;
	
	@Override
	public ArrayList<PersonEntity> getAllUser() {
		return (ArrayList<PersonEntity>)repository.findAll();
	}

	@Override
	public Optional<PersonEntity> getUserById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public PersonEntity saveUser(PersonEntity u) {
		return repository.save(u);
	}

	@Override
	public boolean deleteUserById(Integer id) {
		try {
			Optional<PersonEntity> p=getUserById(id);
			if(p.isPresent()) {
				repository.delete(p.get());
				return true;
			}
			return false;
			
		}catch(Exception e) {
			return false;
		}
	}

	
	
}
