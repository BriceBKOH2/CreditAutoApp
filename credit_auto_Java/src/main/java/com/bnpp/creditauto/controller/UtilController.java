package com.bnpp.creditauto.controller;

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
 * Contient les méthodes utilitaires.
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
	 * Appelle le script d'initialisation de la base de données.
	 */
	@RequestMapping(value = "/initdb", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public void initDB() {
		dbdata.init();
	}
}
