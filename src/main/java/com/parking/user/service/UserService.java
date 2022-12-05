package com.parking.user.service;

import java.util.ArrayList;
import java.util.Optional;

import com.parking.user.model.dto.LoginDto;
import com.parking.user.model.entity.UserEntity;

public interface UserService {
	ArrayList<UserEntity> getAllUser();
	Optional<UserEntity> getUserById(Integer id);
	UserEntity saveUser(UserEntity u);
	boolean deleteUserById(Integer id);
	boolean login(LoginDto loginDto);
}
