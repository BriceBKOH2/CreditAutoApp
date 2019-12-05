package com.bnpp.creditauto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpp.creditauto.dao.RateDao;
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
	 * @return the Rate
	 */
	public Rate getDecisionRate(Category cat, int vehiclePrice, int duration) {
		return rateDao.getDecisionRate(cat, vehiclePrice, duration);
	}
}
