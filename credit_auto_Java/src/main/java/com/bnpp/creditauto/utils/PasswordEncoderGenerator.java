package com.bnpp.creditauto.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {

	public static String generateEncodedPassword(String password) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
		return hashedPassword;
	}
}
