package com.bnpp.creditauto.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bnpp.creditauto.exception.ClientNotFoundException;
import com.bnpp.creditauto.model.Client;

@Repository
public class ClientDao extends AbstractDao<Client> {

	@Override
	protected Class<Client> getEntityClass() {
		return Client.class;
	}

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

	@Override
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
