package com.bnpp.creditauto.exception;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7239796895893823607L;

	public UserNotFoundException(Long id) {
		System.err.println("User id : " + id + " not found in database");
	}
	
	public UserNotFoundException(String firstName, String lastName) {
		System.err.println("User firstName : " + firstName + " ans lastName : " + lastName + " not found in database");
	}
}
