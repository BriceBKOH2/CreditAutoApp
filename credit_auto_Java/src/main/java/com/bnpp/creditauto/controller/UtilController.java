package com.bnpp.creditauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.utils.DBData;

@RestController
@RequestMapping("/api/util")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilController {
	
	@Autowired
	DBData dbdata;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void initDB() {
		dbdata.init();
	}
}
