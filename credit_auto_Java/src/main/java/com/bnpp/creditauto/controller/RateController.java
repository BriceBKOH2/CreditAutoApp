package com.bnpp.creditauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.Rate;
import com.bnpp.creditauto.service.RateService;
import com.bnpp.creditauto.utils.JsonHelper;

@RestController
@RequestMapping("/api/rate")
@CrossOrigin(origins = "http://localhost:4200")
public class RateController {
	// TODO
	// Cette classe doit définir les methodes qui vont renvoyer du json
	// Fera le lien entre le formulaire et le java.	
	
	@Autowired
	private RateService rateSvc;
	
	@Autowired
	private JsonHelper jsonHelper;
	
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
	
	@RequestMapping(value = "{str}", method = RequestMethod.GET)
	@ResponseBody
	public String alacon(@PathVariable String str) {
		return "Salut " + str + " !\n" + jsonHelper.serialize(new Category()) + "\n" + jsonHelper.serialize(5);
	}
	
	@RequestMapping(value = "/decision", method = RequestMethod.GET)
	@ResponseBody
	public String /*Rate*/ findRateDecision(@RequestParam Category cat, @RequestParam int price/*, @RequestParam int dur*/) {
		System.out.println(cat);
		System.out.println(price);
//		System.out.println(dur);
		//return rateSvc.getDecisionRate(cat, price, dur);
		return cat.toString();
	}
	
}
