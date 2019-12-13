package com.bnpp.creditauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpp.creditauto.dao.CategoryDao;
import com.bnpp.creditauto.exception.NotFoundException;
import com.bnpp.creditauto.model.Category;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao categDao;
	
	public Category findById(Long id) throws NotFoundException {
		return categDao.findById(id);
	}
	
	public List<Category> findAll() {
		return categDao.findAll();
	}
	
	public void save(Category c) {
		categDao.save(c);
	}
	
	public void deleteAll() {
		categDao.deleteAll();
	}
	
	public Category findByName(String name) throws NotFoundException {
		return categDao.findByName(name);
	}
}
