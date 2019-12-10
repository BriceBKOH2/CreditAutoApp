package com.bnpp.creditauto.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.model.Client;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	// TODO
	// Cette classe doit définir les methodes qui vont renvoyer du json
	// Fera le lien entre le formulaire et le java.	
	
//	@Autowired
//	private RateService rateSvc;
	
	/**
	 * Create and return an arbitrary client.
	 * For testing purposes.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	
	public Client mock() {
		Client client = new Client();
		client.setId(2000L);
		client.setFirstName("John");
		client.setLastName("Doe");
		client.setDateOfBirth(Date.valueOf(LocalDate.of(1995, 02, 14)));
		client.setAddress("45 rue des pinguoins");
		client.setAccountNumber(945487621L);
		client.setPhoneNumber("06 57 84 35 19");
		return client;
	}
}
