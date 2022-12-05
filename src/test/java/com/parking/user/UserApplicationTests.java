package com.parking.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.parking.user.model.entity.UserEntity;
import com.parking.user.repository.UserRepository;
import com.parking.user.service.UserService;

@SpringBootTest
class UserApplicationTests {
	@Autowired
	private UserRepository repository;
	@Autowired
	private UserService service;
	@Test
	void contextLoads() {
	}
	@Test
	void cleanTests() {
		assertTrue(service.cleanTests());
	}
	@Test
	void saveUserTest() {
		UserEntity user= UserEntity.defaultUser();
		UserEntity savedUser=repository.save(user);
		assertTrue(savedUser.getPassword().equalsIgnoreCase(user.getPassword()));
		assertTrue(service.cleanTests());
	}
	@Test
	void loginTest() {
		assertTrue(service.cleanTests());
		
		UserEntity user= UserEntity.defaultUser();
		String password=user.getPassword();
		service.saveUser(user);
		
		//Check the returned password is encripted
		Boolean passwordNotEncrypted=(user.getPassword().equals(password));
		
		assertFalse(passwordNotEncrypted);
		//Check the user can login
		Boolean userLogged=service.login(user.getEmail(),password);
		assertTrue(userLogged);
	}
	
	
}
