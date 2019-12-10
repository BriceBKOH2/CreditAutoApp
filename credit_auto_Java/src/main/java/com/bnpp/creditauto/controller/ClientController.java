package com.bnpp.creditauto.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.exception.ClientNotFoundException;
import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.Client;
import com.bnpp.creditauto.service.CategoryService;
import com.bnpp.creditauto.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	// TODO
	// Cette classe doit d�finir les methodes qui vont renvoyer du json
	// Fera le lien entre le formulaire et le java.	
	
//	@Autowired
//	private RateService rateSvc;
	
	/**
	 * Create and return an arbitrary client.
	 * For testing purposes.
	 * @return
	 */
//	@RequestMapping(method = RequestMethod.GET)
//	
//	public Client mock() {
//		Client client = new Client();
//		client.setId(2000L);
//		client.setFirstName("John");
//		client.setLastName("Doe");
//		client.setDateOfBirth(new Date(1995, 02, 14));
//		client.setAddress("45 rue des pinguoins");
//		client.setAccountNumber(945487621L);
//		client.setPhoneNumber("06 57 84 35 19");
//		return client;
//	}
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Client> findAll() {
		return clientService.findAll();
	}
	
	@RequestMapping(value = "/accountnumber/{accountNumber}", method = RequestMethod.GET)
	public Client findOneByAccount(@PathVariable Long accountNumber) throws ClientNotFoundException {
		return clientService.findByAccNumb(accountNumber);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Client findOneById(@PathVariable Long id) throws ClientNotFoundException {
		return clientService.findById(id);
	}
	
	@RequestMapping(value = "{firstName}/{lastName}", method = RequestMethod.GET)
	public List<Client> findOneByNames(@PathVariable String firstName, @PathVariable String lastName) throws ClientNotFoundException {
		System.out.println(lastName);
		return clientService.findByNames(firstName, lastName);
	}
}













