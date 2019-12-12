package com.bnpp.creditauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.exception.ClientNotFoundException;
import com.bnpp.creditauto.exception.UserNotFoundException;
import com.bnpp.creditauto.model.User;
import com.bnpp.creditauto.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) throws ClientNotFoundException {
		return userService.findById(id);
	}
	
	@RequestMapping(value = "{firstName}/{lastName}", method = RequestMethod.GET)
	public List<User> findByNames(@PathVariable String firstName, @PathVariable String lastName) throws UserNotFoundException {
		System.out.println(lastName);
		return userService.findByNames(firstName, lastName);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User client) throws UserNotFoundException {
		 
		 System.out.println(client);
		 userService.save(client);
		 System.out.println(client);
		 return client;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, @RequestBody User client) throws UserNotFoundException {
		client.setId(id);
		userService.update(client);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(String login, String password) {
		try {
			userService.login(login, password);
			System.out.println("Logged as " + login);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
