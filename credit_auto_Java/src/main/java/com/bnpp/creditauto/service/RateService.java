package com.bnpp.creditauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpp.creditauto.dao.RateDao;
import com.bnpp.creditauto.exception.NotFoundException;
import com.bnpp.creditauto.exception.RateNotFoundException;
import com.bnpp.creditauto.model.Contract;
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
	public Rate getDecisionRate(Contract contract) {
		return rateDao.getDecisionRate(contract);
	}
	
	public Rate findById(Long id) throws RateNotFoundException {
		try {
			return rateDao.findById(id);
		} catch (NotFoundException e) {
			throw new RateNotFoundException(id);
		}
	}
	
	public List<Rate> findAll() {
		return rateDao.findAll();
	}
	
	public void save(Rate rate) {
		rateDao.persist(rate);
	}
	
	public void update(Rate rate) throws RateNotFoundException {
		rateDao.update(rate);
	}
	
	public void deleteAll() {
		rateDao.deleteAll();
	}
}
