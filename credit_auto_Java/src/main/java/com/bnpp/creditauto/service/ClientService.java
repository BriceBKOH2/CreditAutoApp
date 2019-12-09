package com.bnpp.creditauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.creditauto.dao.ClientDao;
import com.bnpp.creditauto.exception.ClientNotFoundException;
import com.bnpp.creditauto.model.Client;

@Service
public class ClientService {
	@Autowired
	ClientDao clientDao;
	
	public void save(Client client) {
		clientDao.persist(client);
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
	public Client findByAccNumb(String accountNumber) throws ClientNotFoundException{
		return clientDao.findByAccNumb(accountNumber);
		
	}
}
