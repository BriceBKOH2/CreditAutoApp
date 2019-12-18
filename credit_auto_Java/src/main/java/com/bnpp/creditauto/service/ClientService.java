package com.bnpp.creditauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.creditauto.dao.ClientDao;
import com.bnpp.creditauto.exception.ClientNotFoundException;
import com.bnpp.creditauto.exception.NotFoundException;
import com.bnpp.creditauto.model.Client;

@Service
public class ClientService {
	@Autowired
	ClientDao clientDao;
	
	public Client save(Client client) {
		return clientDao.persist(client);
	}
	
	public Client findById(Long id) throws ClientNotFoundException {
		try {
			return clientDao.findById(id);
		} catch (NotFoundException e) {
			throw new ClientNotFoundException(id);
		}
	}

	@Transactional(rollbackFor = ClientNotFoundException.class)
	public void update(Client... clients) throws ClientNotFoundException {
		for (Client client : clients) {
			clientDao.update(client);	
		}
	}
	
	@Transactional(rollbackFor = ClientNotFoundException.class)
	public void update(List<Client> clients) throws ClientNotFoundException {
		for (Client client : clients) {
			clientDao.update(client);	
		}
	}

	@Transactional(rollbackFor = ClientNotFoundException.class)
	public void delete(Client client) throws ClientNotFoundException {
		clientDao.delete(client);
	}
	
	@Transactional
	public void deleteAll() {
		clientDao.deleteAll();
	}
	
	@Transactional
	public List<Client> findAll() {
		return clientDao.findAll();
	}
	
	@Transactional(rollbackFor = ClientNotFoundException.class)
	public Client findByAccNumb(Long accountNumber) throws ClientNotFoundException{
		return clientDao.findByAccNumb(accountNumber);
	}
	
	@Transactional(rollbackFor = ClientNotFoundException.class)
	public List<Client> findByNames(String firstName, String lastName) throws ClientNotFoundException {
		return clientDao.findByNames(firstName, lastName);
	}
	
	@Transactional(rollbackFor = ClientNotFoundException.class)
	public List<Client> findByFirstName(String lastName) throws ClientNotFoundException {
		return clientDao.findByFirstName(lastName);
	}
	
	@Transactional(rollbackFor = ClientNotFoundException.class)
	public List<Client> findByLastName(String lastName) throws ClientNotFoundException {
		return clientDao.findByLastName(lastName);
	}
	
	@Transactional
	public Long getNewAccountNumber() {
		Long result = clientDao.getHighestAccountNumber()+1;
		do {
			try {
				clientDao.findByAccNumb(result);
			} catch (ClientNotFoundException e) {
				return result;
			}
			result++;
		} while(true);
	}
	
}
