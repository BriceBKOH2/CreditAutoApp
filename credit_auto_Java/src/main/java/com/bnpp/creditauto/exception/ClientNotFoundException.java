package com.bnpp.creditauto.exception;

public class ClientNotFoundException extends NotFoundException {

	/** Exception generated when call to dataBase returns empty
	 * 
	 */
	private static final long serialVersionUID = -8495340188990744956L;
	
	public ClientNotFoundException(Long id) {
		System.err.println("Client id : " + id + " not found in database");
	}
	
	public ClientNotFoundException(String accountNumber) {
		System.err.println("Client account number : " + accountNumber + " not found in database");
	}
	
	public ClientNotFoundException(String firstName, String lastName) {
		System.err.println("Client firstName : " + firstName + " ans lastName : " + lastName + " not found in database");
	}
}
