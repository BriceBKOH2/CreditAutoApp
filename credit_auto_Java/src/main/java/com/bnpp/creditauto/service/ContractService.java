package com.bnpp.creditauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.creditauto.dao.ContractDao;
import com.bnpp.creditauto.exception.ContractNotFoundException;
import com.bnpp.creditauto.model.Contract;

@Service
public class ContractService {
	@Autowired
	ContractDao contractDao;
	
	public void save(Contract contract) {
		contractDao.save(contract);
	}

	@Transactional(rollbackFor = ContractNotFoundException.class)
	public void update(Contract... contracts) throws ContractNotFoundException {
		for (Contract contract : contracts) {
			contractDao.update(contract);	
		}
	}
	
	@Transactional(rollbackFor = ContractNotFoundException.class)
	public void update(List<Contract> contracts) throws ContractNotFoundException {
		for (Contract contract : contracts) {
			contractDao.update(contract);	
		}
	}

	@Transactional(rollbackFor = ContractNotFoundException.class)
	public void delete(Contract contract) throws ContractNotFoundException {
		contractDao.delete(contract);
	}
	
	@Transactional
	public void deleteAll() {
		contractDao.deleteAll();
	}
	
	@Transactional
	public List<Contract> findAll() {
		return contractDao.findAll();
	}

}
