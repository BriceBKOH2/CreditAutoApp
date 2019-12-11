package com.bnpp.creditauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.exception.ClientNotFoundException;
import com.bnpp.creditauto.exception.RateNotFoundException;
import com.bnpp.creditauto.model.Contract;
import com.bnpp.creditauto.service.ContractService;

@RestController
@RequestMapping("/api/contract")
@CrossOrigin(origins = "http://localhost:4200")
public class ContractController extends AbstractController {

	@Autowired
	private ContractService contractSvc;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Contract> findAll() {
		return contractSvc.findAll();
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Contract findById(@PathVariable Long id) throws ClientNotFoundException {
		return contractSvc.findById(id);
	}
	
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
	public List<Contract> findByClientId(@PathVariable Long id) throws ClientNotFoundException {
		//TODO
		return contractSvc.findByClientId(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Contract contractSimulator(@RequestBody Contract c) {
		try {
			contractSvc.contractSimulator(c);
		} catch (RateNotFoundException e) {
			System.err.print(e.getMessage());
			return null;
		}
		
		return c;
	}
	
}
