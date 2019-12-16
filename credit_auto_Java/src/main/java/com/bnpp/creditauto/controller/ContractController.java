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
import com.bnpp.creditauto.exception.RateNotFoundException;
import com.bnpp.creditauto.model.Contract;
import com.bnpp.creditauto.service.ContractService;

@RestController
@RequestMapping("/api/contract")
@CrossOrigin(origins = "http://localhost:4200")
public class ContractController extends AbstractController {

	@Autowired
	private ContractService contractSvc;
	
	/**
	 * Returns a list of all Contract objects.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Contract> findAll() {
		return contractSvc.findAll();
	}
	
	/**
	 * Updates the Contract object with the id specified in path variable, with the informations
	 * contained in the body of the request.
	 * @param id The id of the Contract object to modify.
	 * @param contract The udpated contract object to take into account.
	 * @throws ContractNotFoundException if no Contract objects are found with the id specified.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, @RequestBody Contract contract) throws ContractNotFoundException {
		contract.setId(id);
		contractSvc.update(contract);
	}
	
	/**
	 * Finds and returns the Contract object with the id specified in the path variable.
	 * @param id The id of the Contract to search for.
	 * @return The Contract object found, null otherwise.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Contract findById(@PathVariable Long id){
		try {
			return contractSvc.findById(id);
		} catch (ContractNotFoundException e) {
			return null;
		}
	}
	
	/**
	 * Create the Contract with informations passed on in the request's body.
	 * @param c The newly formed contract to save.
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public Contract create(@RequestBody Contract c) {
		return contractSvc.save(c);
	}
	
	/**
	 * "Simulates" the amount due by the client and write it in the contract.
	 * This method need to have the Contract passed in parameter to have it's
	 * vehicleCategory and vehiclePrice correctly set, as theses two fields are
	 * required for deciding the correct Rate of the loan. 
	 * It is also required that the fields loanAmount and loanDuration be set, as
	 * theses two are used in the calculations for the total amout due.
	 * 
	 * If the "simulation" is successful, returns the modified contract with
	 * its rate and amoutDue field completed.
	 * 
	 * If it fails to do so, returns null. It will mostly likely fail due to the inability
	 * to find a corresponding Rate amount in the decision table, or because certain
	 * fields are not properly set.
	 * @param c the Contract object to be simulated, passed in the request's body.
	 * @return the modified contract if simulation successful, null otherwise.
	 */
	@RequestMapping(method = RequestMethod.POST)
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
