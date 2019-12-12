package com.bnpp.creditauto.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bnpp.creditauto.exception.UserNotFoundException;
import com.bnpp.creditauto.model.User;
import com.bnpp.creditauto.utils.PasswordEncoderGenerator;


@Repository
public class UserDao extends AbstractDao<User> {
	
	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}
	
	public void update(User user) throws UserNotFoundException {
		Session session = getSession();
		Long id = user.getId();
		if (id == null) {
			throw new UserNotFoundException(id);
		} else if (session.find(User.class, user.getId()) == null) {
			throw new UserNotFoundException(id);
		}
		session.merge(user);
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

	public User findByCredentials(String login, String password) throws UserNotFoundException {

		User user;
		
		// We check if User with login exists
		TypedQuery<User> query = em.createQuery("FROM User usr WHERE usr.login=:login", User.class);
		query.setParameter("login", login);
		try {
			user = query.getSingleResult();
		} catch (NoResultException e) {
			throw new UserNotFoundException("User with login " + login + " not found.");
		}
		
		if (!PasswordEncoderGenerator.matches(password, user.getPassword())) {
			throw new UserNotFoundException("Bad password");
		}
		
		return user;
		
		// Checking login/password association
		/*
		query = em.createQuery("FROM User usr WHERE usr.login=:login "
														+ "AND usr.password=:hashedPwd",
														User.class);
		query.setParameter("login", login);
		query.setParameter("hashedPwd", password);
		System.out.println(login);
		System.out.println(password);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new UserNotFoundException("Bad password");
		}*/
	}

}
