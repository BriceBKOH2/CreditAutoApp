package com.bnpp.creditauto.exception;

public class RateNotFoundException extends NotFoundException {

	private static final long serialVersionUID = -2257361142610221210L;

	public RateNotFoundException(Long id) {
		System.err.println("Rate id : " + id + " not found in database.");
	}

	public RateNotFoundException(String msg) {
		super(msg);
	}
}
