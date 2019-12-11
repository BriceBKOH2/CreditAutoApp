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
import com.bnpp.creditauto.model.Contract;
import com.bnpp.creditauto.service.ContractService;

@RestController
@RequestMapping("/api/contract")
@CrossOrigin(origins = "http://localhost:4200")
public class ContractController {

	@Autowired
	private ContractService contractService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Contract> findAll() {
		return contractService.findAll();
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Contract findById(@PathVariable Long id) throws ContractNotFoundException {
		return contractService.findById(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Contract create(@RequestBody Contract contract) throws ContractNotFoundException {
		 
		 System.out.println(contract);
		 contractService.save(contract);
		 System.out.println(contract);
		 return contract;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, @RequestBody Contract contract) throws ContractNotFoundException {
		contract.setId(id);
		contractService.update(contract);
	}
	
}
