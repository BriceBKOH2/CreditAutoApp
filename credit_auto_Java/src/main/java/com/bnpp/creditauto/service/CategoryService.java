package com.bnpp.creditauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.creditauto.dao.CategoryDao;
import com.bnpp.creditauto.exception.NotFoundException;
import com.bnpp.creditauto.model.Category;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao categDao;
	
	@Transactional
	public Category findById(Long id) throws NotFoundException {
		return categDao.findById(id);
	}
	
	@Transactional
	public List<Category> findAll() {
		return categDao.findAll();
	}
	
	@Transactional
	public void save(Category c) {
		categDao.save(c);
	}
	
	@Transactional
	public void deleteAll() {
		categDao.deleteAll();
	}
	
	@Transactional
	public Category findByName(String name) throws NotFoundException {
		return categDao.findByName(name);
	}
}
