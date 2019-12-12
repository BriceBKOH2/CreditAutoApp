package com.bnpp.creditauto.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bnpp.creditauto.exception.ClientNotFoundException;
import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.Client;

@Repository
public class CategoryDao extends AbstractDao<Category> {
	
	@Override
	protected Class<Category> getEntityClass() {
		return Category.class;
	}
	
	public Category findByName(String name) {
		Session session = getSession();
		TypedQuery<Category> query = session.createQuery("FROM Category cat WHERE cat.name=:name",
				Category.class);
		query.setParameter("name", name);
		Category category;
		
		category = query.getSingleResult();

		return category;
	}

}
