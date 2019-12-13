package com.bnpp.creditauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.creditauto.exception.NotFoundException;
import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.service.CategoryService;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

	// Cette classe doit définir les methodes qui vont renvoyer du json
	// Fera le lien entre le formulaire et le java.

	@Autowired
	private CategoryService categoryService;
	
	/**
	 * Returns a list of all categories.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Category> findAll() {
		return categoryService.findAll();
	}

	/**
	 * Returns the Category object that corresponds to the id specified in the path variable.
	 * @param id The id of the category to find.
	 * @return the Category object that corresponds to the id specified, null otherwise.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Category findById(@PathVariable Long id) {
		try {
			return categoryService.findById(id);
		} catch (NotFoundException e) {
			return null;
		}
	}
	
	/**
	 * Returns the first found Category object corresponding to the name specified.
	 * @param name The name of the Category.
	 * @return the first found Category object with the name specified, null otherwise.
	 */
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Category findByName(@PathVariable String name) {
		try {
			return categoryService.findByName(name);
		} catch (NotFoundException e) {
			return null;
		}
	}

}
