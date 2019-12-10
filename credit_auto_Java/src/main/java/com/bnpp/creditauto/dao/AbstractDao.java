package com.bnpp.creditauto.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.creditauto.model.IdEntity;

/**
 * Contains entity manager and general methods for data access objects.
 * @author Jordi
 *
 */
public abstract class AbstractDao<T extends IdEntity> {
	
	protected Class<T> entityClass;
	
	@PersistenceContext
	EntityManager em;
	
	@PostConstruct
	public void init() {
		entityClass = getEntityClass();
	}

	// Permet de déterminer la classe dans les classes filles.
	protected abstract Class<T> getEntityClass();
	
	protected Session getSession() {
		return em.unwrap(Session.class);
	}
	
	
	/* CRUD Methods */

	@Transactional
	public T save(T entity) {
		if (isNew(entity)) {
			em.persist(entity);
		} else if (!em.contains(entity)) {
			return em.merge(entity);
		}

		return entity;
	}
	
	@Transactional
	public void persist(Object entity) {
		em.persist(entity);
	}
	
	@Transactional
	public T findById(Long id) {
		return em.find(entityClass, id);
	}

	@Transactional
	public List<T> findAll() {
		return em.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
	}
	
	@Transactional
	public void delete(T entity) throws Exception {
		if (!getSession().contains(entity)) {
			em.remove(getSession().merge(entity));
		} else {
			em.remove(entity);
		}
	}
	
	@Transactional
	public int deleteAll() {
		return em.createQuery("delete from " + entityClass.getSimpleName()).executeUpdate();
	}
	
	/** 
	 * Check si entity a une id nulle : elle est nulle si l'entity n'a jamais été persist.
	 * (On ne set pas l'id, seule la DB peut "définir" l'id)
	 */
	public boolean isNew(T entity) {
		return entity.getId() == null;
	}

}
