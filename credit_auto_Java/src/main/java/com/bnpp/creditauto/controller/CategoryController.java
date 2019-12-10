package com.bnpp.creditauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public Category findById(@PathVariable Long id) {
		return categoryService.findById(id);
	}
	
	/**
	 * Create and return an arbitrary rate.
	 * For testing purposes.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Category> findAll() {
		return categoryService.findAll();
	}
	
	
	
}
