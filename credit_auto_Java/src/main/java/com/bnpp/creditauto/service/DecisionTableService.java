package com.bnpp.creditauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpp.creditauto.dao.DecisionTableDao;
import com.bnpp.creditauto.model.DecisionTable;

@Service
public class DecisionTableService {

	@Autowired
	DecisionTableDao dtDao;
	
	public void save(DecisionTable dt) {
		dtDao.persist(dt);
	}
	
	public void deleteAll() {
		dtDao.deleteAll();
	}
	
	public List<DecisionTable> findAll() {
		return dtDao.findAll();
	}
}
