package com.bnpp.creditauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.creditauto.dao.RateDao;
import com.bnpp.creditauto.exception.RateNotFoundException;
import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.Rate;

@Service
public class RateService {
	
	@Autowired
	private RateDao rateDao;

	/**
	 * Method that retrieve the correct rate from the database according to parameters entered.
	 * @param cat the vehicle Category
	 * @param vehiclePrice the price of the vehicle. Integer number : we do not care for cents
	 * @param duration duration in months of the loan
	 * @return the Rate if found, null otherwise.
	 */
	@Transactional
	public Rate getDecisionRate(Category cat, long vehiclePrice, int duration) {
		try {
			return rateDao.getDecisionRate(cat, vehiclePrice, duration);
		} catch (RateNotFoundException e) {
			return null;
		}
	}
	
	public Rate findById(Long id) {
		return rateDao.findById(id);
	}
	
	public List<Rate> findAll() {
		return rateDao.findAll();
	}

	public void save(Rate rate) {
		rateDao.persist(rate);
	}

	@Transactional
	public void deleteAll() {
		rateDao.deleteAll();
	}
}
