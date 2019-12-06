package com.bnpp.creditauto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.model.Rate;

@RestController
@RequestMapping("/api/rate")
public class RateController {
	// TODO
	// Cette classe doit définir les methodes qui vont renvoyer du json
	// Fera le lien entre le formulaire et le java.	
	
//	@Autowired
//	private RateService rateSvc;
	
	/**
	 * Create and return an arbitrary rate.
	 * For testing purposes.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Rate mock() {
		Rate rate = new Rate();
		rate.setId(1000L);
		rate.setName("T1000");
		rate.setRateAmount(1000.00);
		return rate;
	}
}
