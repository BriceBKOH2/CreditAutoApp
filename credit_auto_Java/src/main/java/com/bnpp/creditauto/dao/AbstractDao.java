package com.bnpp.creditauto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Contains entity manager and general methods for data access objects.
 * @author Jordi
 *
 */
public abstract class AbstractDao<T> {
	
	protected Class<T> entityClass;
	
	@PersistenceContext
	EntityManager em;
	
	// TODO: CRUD methods (create, read, update, delete)
	//

}
