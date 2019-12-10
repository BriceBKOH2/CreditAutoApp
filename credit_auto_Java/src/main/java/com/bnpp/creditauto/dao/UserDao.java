package com.bnpp.creditauto.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bnpp.creditauto.exception.UserNotFoundException;
import com.bnpp.creditauto.model.User;


@Repository
public class UserDao extends AbstractDao<User> {
	
	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	public List<User> findByNames(String firstName, String lastName) throws UserNotFoundException {
		
		Session session = getSession();
		TypedQuery<User> query = session.createQuery("FROM User usr WHERE usr.firstName=:firstName "
														+ "AND usr.lastName=:lastName",
														User.class);
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		List<User> users;
		
		try {
			users = query.getResultList();
		} catch (NoResultException e) {
			throw new UserNotFoundException(firstName, lastName);
		}
		return users;
	}

}
