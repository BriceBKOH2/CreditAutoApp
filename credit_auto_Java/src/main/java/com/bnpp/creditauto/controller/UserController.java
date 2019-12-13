package com.bnpp.creditauto.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bnpp.creditauto.exception.UserNotFoundException;
import com.bnpp.creditauto.model.User;
import com.bnpp.creditauto.service.UserService;

@RestController
@RequestMapping("/api/user")
@SessionAttributes(value="currentUser", types= {User.class})
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * Returns a list of all users.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> findAll() {
		return userService.findAll();
	}
	
	/**
	 * Return the User with the id specified in path variable.
	 * @param id the Id of the User to search for.
	 * @return the User if found, null otherwise.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) {
		try {
			return userService.findById(id);
		} catch (UserNotFoundException e) {
			return null;
		}
	}
	
	/**
	 * Returns the user with firstname and lastname in request parameters.
	 * @param firstName The first name of the user.
	 * @param lastName The last name of the user.
	 * @return The user if found, null otherwise.
	 */
	@RequestMapping(value = "/byname", method = RequestMethod.GET)
	public List<User> findByNames(@RequestParam String firstName, @RequestParam String lastName) {
		try {
			return userService.findByNames(firstName, lastName);
		} catch (UserNotFoundException e) {
			return null;
		}
	}
	
	/**
	 * Creates the user in the request's body. Will throw EntityExistsException if user already exists.
	 * @param user The new user to be created. Id must not be specified as it will be ignored.
	 * @return the newly created user.
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		 return userService.save(user);
	}
	
	/**
	 * Updates the user with the id specified with the new state passed in the request's body.
	 * @param id The id of the user to be modified.
	 * @param user The new state of the user to be updated.
	 * @throws UserNotFoundException if the user was not found with the id specified.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable Long id, @RequestBody User user) throws UserNotFoundException {
		user.setId(id);
		userService.update(user);
	}
	
	/**
	 * Method that check if the login and password specified in parameters match with those in the database.
	 * @param login The login of the user.
	 * @param password the unhashed password of the user.
	 * @param httpSession
	 * @return the User if login and password match, null otherwise.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestParam String login, @RequestParam String password, HttpSession httpSession) {
		try {
			System.out.println("Logged as " + login);
			User user =  userService.login(login, password);
			httpSession.setAttribute("connectedUser", user);
			return user;
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
