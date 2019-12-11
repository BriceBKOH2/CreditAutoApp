package com.bnpp.creditauto.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bnpp.creditauto.exception.ContractNotFoundException;
import com.bnpp.creditauto.model.Contract;

@Repository
public class ContractDao extends AbstractDao<Contract> {

	@Override
	protected Class<Contract> getEntityClass() {
		return Contract.class;
	}

	public void update(Contract contract) throws ContractNotFoundException {
		Session session = getSession();
		Long id = contract.getId();
		if (id == null) {
			throw new ContractNotFoundException(id);
		} else if (session.find(Contract.class, contract.getId()) == null) {
			throw new ContractNotFoundException(id);
		}
		session.merge(contract);
	}

	@Override
	public void delete(Contract contract) throws ContractNotFoundException {
		Session session = getSession();
		Long id = contract.getId();
		if (id == null) {
			throw new ContractNotFoundException(id);
		} else if (session.find(Contract.class, contract.getId()) == null) {
			throw new ContractNotFoundException(id);
		}
		session.delete(contract);
	}

	/** Can return an empty list instead of an ContractNotFoundException */
	public List<Contract> findAll() {
		Session session = getSession();
		return session.createQuery("FROM Contract", Contract.class).getResultList();
	}

	public List<Contract> findAllByClientId(Long id) throws ContractNotFoundException {
		Session session = getSession();
		TypedQuery<Contract> query = session.createQuery("FROM Contract co WHERE co.client.id=:id ",Contract.class);
		query.setParameter("id", id);
		List<Contract> contracts;
		try {
			contracts = query.getResultList();
		} catch (NoResultException e) {
			throw new ContractNotFoundException(id); // We transform to string to differentiate with
			// argument
			// Long Id since accountNumber is also a Long type
			
		}
		return contracts;

	}

}
