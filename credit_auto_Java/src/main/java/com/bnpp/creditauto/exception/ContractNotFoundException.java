package com.bnpp.creditauto.exception;

public class ContractNotFoundException extends Exception {

	/** Exception generated when call to dataBase returns empty
	 * 
	 */
	private static final long serialVersionUID = -8495340188990744956L;
	
	public ContractNotFoundException(Long id) {
		System.err.println("Client id : " + id + " not found in database");
	}
	
}
