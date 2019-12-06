package com.bnpp.creditauto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 * Contains entity manager and general methods for data access objects.
 * @author Jordi
 *
 */
@Transactional
public abstract class AbstractDao<T> {
	
	protected Class<T> entityClass;
	
	@PersistenceContext
	EntityManager em;
	
	// TODO: CRUD methods (create, read, update, delete)
	//
	
	/* Methods */
	
	protected Session getSession() {
		return em.unwrap(Session.class);
	}
	
	public void persist(Object entity) {
		em.persist(entity);
	}
}
