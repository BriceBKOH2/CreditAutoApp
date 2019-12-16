package com.bnpp.creditauto.controller;

import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.utils.DBData;

/**
 * Contains utilitary/helper methods.
 * @author Jordi
 *
 */
@RestController
@RequestMapping("/api/util")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilController {
	
	@Autowired
	DBData dbdata;
	
	/**
	 * Calls the DBData::init method.
	 */
	@RequestMapping(value = "/initdb", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public String initDB() {
		dbdata.init();
		return "executed db init";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@Filter(name = "ConnectionFilter")
	public String test() {
		return ")";
	}
}
