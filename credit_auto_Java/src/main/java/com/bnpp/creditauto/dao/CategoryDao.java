package com.bnpp.creditauto.dao;

import org.springframework.stereotype.Repository;

import com.bnpp.creditauto.model.Category;

@Repository
public class CategoryDao extends AbstractDao<Category> {
	
	@Override
	protected Class<Category> getEntityClass() {
		return Category.class;
	}

}
