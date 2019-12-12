package com.bnpp.creditauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.model.Contract;
import com.bnpp.creditauto.model.Rate;
import com.bnpp.creditauto.service.CategoryService;
import com.bnpp.creditauto.service.RateService;

@RestController
@RequestMapping("/api/rate")
@CrossOrigin(origins = "http://localhost:4200")
public class RateController {
	
	@Autowired
	private RateService rateSvc;
	
	@Autowired
	private CategoryService categSvc;
	
//	@Autowired
//	private JsonHelper jsonHelper;
	
	/**
	 * Create and return an arbitrary rate. For testing purposes.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Rate> findAll() {
		return rateSvc.findAll();
	}

	@RequestMapping(value = "/simulation", method = RequestMethod.POST)
	@ResponseBody
	public Rate findRateDecision(@RequestBody Contract contract) {
		return rateSvc.getDecisionRate(contract);
	}

}
