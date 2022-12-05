package com.parking.user.service;

public interface EncryptService {
	/*
	 * Let us to encrypt the password.
	 * @Param password
	 * @return
	 * */
	String encryptPassword(String password);
	/*
	 * Verify if the original password and hash password are the same
	 * @Param originalPassword
	 * @Param hashPassword
	 * @return
	 * */
	boolean verifyPassword(String originalPassword, String hashPassword);
}
