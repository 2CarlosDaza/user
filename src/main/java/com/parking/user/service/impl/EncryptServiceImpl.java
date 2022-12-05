package com.parking.user.service.impl;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.parking.user.service.EncryptService;

@Service
public class EncryptServiceImpl implements EncryptService{

	@Override
	public String encryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public boolean verifyPassword(String originalPassword, String hashPassword) {
		return BCrypt.checkpw(originalPassword, hashPassword);
	}
	
}
