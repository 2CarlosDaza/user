package com.parking.user.service;

import java.util.ArrayList;
import java.util.Optional;

import com.parking.user.model.entity.PersonEntity;

public interface PersonService {
	ArrayList<PersonEntity> getAllUser();
	Optional<PersonEntity> getUserById(Integer id);
	PersonEntity saveUser(PersonEntity u);
	boolean deleteUserById(Integer id);
}
