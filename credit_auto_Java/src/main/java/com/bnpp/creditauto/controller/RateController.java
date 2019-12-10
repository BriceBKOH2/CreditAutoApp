package com.bnpp.creditauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.Rate;
import com.bnpp.creditauto.service.RateService;

@RestController
@RequestMapping("/api/rate")
@CrossOrigin(origins = "http://localhost:4200")
public class RateController {
	// TODO
	// Cette classe doit définir les methodes qui vont renvoyer du json
	// Fera le lien entre le formulaire et le java.	
	
	@Autowired
	private RateService rateSvc;
	
	/**
	 * Create and return an arbitrary rate.
	 * For testing purposes.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Rate> findAll() {
		return rateSvc.findAll();
	}
	
	@RequestMapping(value = "/decision", method = RequestMethod.GET)
	@ResponseBody
	public Rate findRateDecision(@RequestBody Category cat, @RequestBody int price, @RequestBody int dur) {
		return rateSvc.getDecisionRate(cat, price, dur);
	}
	
}
