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

import com.bnpp.creditauto.exception.RateNotFoundException;
import com.bnpp.creditauto.model.Contract;
import com.bnpp.creditauto.model.Rate;
import com.bnpp.creditauto.service.RateService;

@RestController
@RequestMapping("/api/rate")
@CrossOrigin(origins = "http://localhost:4200")
public class RateController {

	@Autowired
	private RateService rateSvc;

	/**
	 * Returns the list of all Rate objects.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Rate> findAll() {
		return rateSvc.findAll();
	}

	/**
	 * Returns the Rate with the id in path variable.
	 * @param id the id of the Rate to search for.
	 * @return The rate with the id specified, null otherwise.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Rate findById(@PathVariable Long id) {
		try {
			return rateSvc.findById(id);
		} catch (RateNotFoundException e) {
			return null;
		}
	}

	/**
	 * Retrieves the correct rate from the database according to the infos in the contract.
	 * @param contract 
	 * @return
	 */
	@RequestMapping(value = "/simulation", method = RequestMethod.POST)
	@ResponseBody
	public Rate findRateDecision(@RequestBody Contract contract) {
		return rateSvc.getDecisionRate(contract);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, @RequestBody Rate rate) throws RateNotFoundException{
		rate.setId(id);
		rateSvc.update(rate);
	}

}
