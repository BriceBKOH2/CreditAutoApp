package com.bnpp.creditauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.exception.ClientNotFoundException;
import com.bnpp.creditauto.model.Client;
import com.bnpp.creditauto.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	
	// Cette classe doit d�finir les methodes qui vont renvoyer du json
	// Fera le lien entre le formulaire et le java.	

	@Autowired
	private ClientService clientService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Client> findAll() {
		return clientService.findAll();
	}
	
	@RequestMapping(value = "/accountnumber/{accountNumber}", method = RequestMethod.GET)

	public Client findByAccount(@PathVariable Long accountNumber) throws ClientNotFoundException {
		return clientService.findByAccNumb(accountNumber);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Client findById(@PathVariable Long id) throws ClientNotFoundException {
		return clientService.findById(id);
	}
	
	@RequestMapping(value = "{firstName}/{lastName}", method = RequestMethod.GET)
	public List<Client> findByNames(@PathVariable String firstName, @PathVariable String lastName) throws ClientNotFoundException {
		System.out.println(lastName);
		return clientService.findByNames(firstName, lastName);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody Client client) throws ClientNotFoundException {
		 
		 System.out.println(client);
		 clientService.save(client);
		 System.out.println(client);
		 return client;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, @RequestBody Client client) throws ClientNotFoundException {
		client.setId(id);
		clientService.update(client);
	}
}













