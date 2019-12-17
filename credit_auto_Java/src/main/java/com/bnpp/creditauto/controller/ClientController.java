package com.bnpp.creditauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.exception.ClientNotFoundException;
import com.bnpp.creditauto.exception.ContractNotFoundException;
import com.bnpp.creditauto.model.Client;
import com.bnpp.creditauto.model.Contract;
import com.bnpp.creditauto.service.ClientService;
import com.bnpp.creditauto.service.ContractService;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
	
	// Cette classe doit définir les methodes qui vont renvoyer du json
	// Fera le lien entre le formulaire et le java.	

	@Autowired
	private ClientService clientService;

	@Autowired
	private ContractService contractService;

	/* Methods */
	
	/**
	 * Create the client with the object contained in the request's body.
	 * @param client The new client to be created.
	 * @return the created Client.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Long createAccountNumber() {
		 return clientService.getNewAccountNumber();
	}
	
	/**
	 * Create the client with the object contained in the request's body.
	 * @param client The new client to be created.
	 * @return the created Client.
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public Client createClient(@RequestBody Client client) {
		 return clientService.save(client);
	}
	
	/**
	 * Returns a list of all clients.
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> findAll() {
		return clientService.findAll();
	}

	/**
	 * Retrieve the Client with the account number specified in the path variable.
	 * @param accountNumber The account number of the client.
	 * @return The client found, if any.
	 * @throws ClientNotFoundException if client with the specified account number does not exist.
	 */
	@RequestMapping(value = "/accountnumber/{accountNumber}", method = RequestMethod.GET)
	public Client findByAccount(@PathVariable Long accountNumber) throws ClientNotFoundException {
		return clientService.findByAccNumb(accountNumber);
	}
	
	
	/**
	 * Returns a list of all clients found with firstname and lastname in the request parameter. 
	 * @param firstName The first name of the client.
	 * @param lastName The last name of the client.
	 * @return a list of all clients found with firstname and lastname parameters. 
	 * @throws ClientNotFoundException if client with the names in parameters does not exist.
	 */
	@RequestMapping(value = "/byname", method = RequestMethod.GET)
	public List<Client> findByNames(@RequestParam String firstName, @RequestParam String lastName)
			throws ClientNotFoundException {
		return clientService.findByNames(firstName, lastName);
	}
	
	/**
	 * Retrieves the client with the id specified in the path variable.
	 * @param id The id of the client to find.
	 * @return the client found, if any.
	 * @throws ClientNotFoundException if client with the specified id does not exist.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Client findById(@PathVariable Long id) throws ClientNotFoundException {
		return clientService.findById(id);
	}
	
	/**
	 * Update the client with id in pathvariable with the informations in the body of the PUT request.
	 * @param id The id of the client to update.
	 * @param client The new client state that will replace the old one.
	 * @throws ClientNotFoundException if client with the id does not exist.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateClient(@PathVariable Long id, @RequestBody Client client) throws ClientNotFoundException {
		clientService.update(client);
	}
	
	/**
	 * Returns all contracts that the Client with id in path variable have.
	 * @param id the client id.
	 * @return the list of all contracts that the client have.
	 * @throws ClientNotFoundException if client with the id does not exist.
	 */
	@RequestMapping(value = "/{id}/contracts", method = RequestMethod.GET)
	@ResponseBody
	public List<Contract> getContracts(@PathVariable Long id) throws ClientNotFoundException {
		try {
			return contractService.findAllByClientId(id);
		} catch (ContractNotFoundException e) {
			return null;
		}
	}
}