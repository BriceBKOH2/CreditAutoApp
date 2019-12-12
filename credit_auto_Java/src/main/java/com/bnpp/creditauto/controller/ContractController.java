package com.bnpp.creditauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.bnpp.creditauto.exception.ContractNotFoundException;

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
	
//	@Autowired
//	private JsonHelper jsonHelper;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Contract> findAll() {
		return contractSvc.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, @RequestBody Contract contract) throws ContractNotFoundException {
		contract.setId(id);
		contractSvc.update(contract);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Contract findById(@PathVariable Long id) throws ClientNotFoundException {
		return contractSvc.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Contract c) {
		contractSvc.save(c);
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
