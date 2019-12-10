package com.bnpp.creditauto.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 4316545685987523549L;

	public NotFoundException(Long id) {
		System.err.println("No entries returned for id : " + id);
	}

}
