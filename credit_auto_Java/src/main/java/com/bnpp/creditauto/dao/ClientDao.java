package com.bnpp.creditauto.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bnpp.creditauto.exception.ClientNotFoundException;
import com.bnpp.creditauto.model.Client;

@Repository
public class ClientDao extends AbstractDao<Client> {

	/*
	 * public void save(Client client) { persist(client); }
	 */

	public void update(Client client) throws ClientNotFoundException {
		Session session = getSession();
		Long id = client.getId();
		if (id == null) {
			throw new ClientNotFoundException(id);
		} else if (session.find(Client.class, client.getId()) == null) {
			throw new ClientNotFoundException(id);
		}
		session.merge(client);
	}

	public void delete(Client client) throws ClientNotFoundException {
		Session session = getSession();
		Long id = client.getId();
		if (id == null) {
			throw new ClientNotFoundException(id);
		} else if (session.find(Client.class, client.getId()) == null) {
			throw new ClientNotFoundException(id);
		}
		session.delete(client);
	}

	public void deleteAll() {
		Session session = getSession();
		session.createQuery("DELETE FROM Client").executeUpdate();
	}

	/** Can return an empty list instead of an ClientNotFoundException */
	public List<Client> findAll() {
		Session session = getSession();
		return session.createQuery("FROM Client", Client.class).getResultList();
	}

	public Client findByAccNumb(String accountNumber) throws ClientNotFoundException {
		Session session = getSession();
		TypedQuery<Client> query = session.createQuery("FROM Client cl WHERE cl.accountNumber=:accountNumber",
				Client.class);
		query.setParameter("accountNumber", accountNumber);
		Client client;
		try {
			client = query.getSingleResult();
		} catch (NoResultException e) {
			throw new ClientNotFoundException(accountNumber.toString()); // We transform to string to differentiate with
																			// argument
			// Long Id since accountNumber is also a Long type
		}
		return client;

	}

}
