package com.parking.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.user.model.dto.LoginDto;
import com.parking.user.model.entity.UserEntity;
import com.parking.user.repository.UserRepository;
import com.parking.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository repository;
	@Autowired
	EncryptServiceImpl bCryptService;
	
	@Override
	public ArrayList<UserEntity> getAllUser() {
		return (ArrayList<UserEntity>)repository.findAll();
	}

	@Override
	public Optional<UserEntity> getUserById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public UserEntity saveUser(UserEntity u) {
		u.setPassword(bCryptService.encryptPassword(u.getPassword()));
		return repository.save(u);
	}

	@Override
	public boolean deleteUserById(Integer id) {
		try {
			Optional<UserEntity> u=getUserById(id);
			if(u.isPresent()) {
				repository.delete(u.get());
				return true;
			}
			return false;
			
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean login(LoginDto loginDto) {
		return login(loginDto.getEmail(),loginDto.getPassword());
	}

	@Override
	public boolean login(String email, String password) {
		UserEntity u=repository.findByEmail(email).orElse(null);
		if(u!=null) {
			return bCryptService.verifyPassword(password, u.getPassword());
		}else {
			return false;
		}
	}

	@Override
	public boolean cleanTests() {
		ArrayList<UserEntity> testUsers=repository.findAllByEmail("test@test.com");
		repository.deleteAll(testUsers);
		return true;
	}

}
