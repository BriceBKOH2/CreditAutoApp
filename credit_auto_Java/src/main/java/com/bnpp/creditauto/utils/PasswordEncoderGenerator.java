package com.bnpp.creditauto.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {
	
	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public static String generateEncodedPassword(String password) {

		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
		return hashedPassword;
	}
	
	public static boolean matches(String rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
}
