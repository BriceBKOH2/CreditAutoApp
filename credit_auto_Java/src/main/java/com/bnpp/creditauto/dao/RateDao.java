package com.bnpp.creditauto.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.Rate;

@Repository
public class RateDao extends AbstractDao<Rate> {

	// aller chercher le bon taux en fonction des paramètres saisis par le conseiller.
	/**
	 * Method that retrieve the correct rate from the database according to parameters entered.
	 * @param cat the vehicle Category
	 * @param vehiclePrice the price of the vehicle. Integer number : we do not care for cents
	 * @param duration duration in months of the loan
	 * @return the Rate
	 */
	public Rate getDecisionRate(Category cat, int vehiclePrice, int duration) {

		String jpql = "select rate from DecisionTable dt "
				+ "where dt.categ = :cat "
				+ "and dt.minAmount <= :vehiclePrice " // smaller or equals : boundaries do not overlap
				+ "and dt.maxAmount >= :vehiclePrice "
				+ "and dt.minDuration <= :duration "
				+ "and dt.maxDuration >= :duration";
		
		TypedQuery<Rate> query = em.createQuery(jpql, Rate.class);
		
		query.setParameter("cat", cat);
		query.setParameter("vehiclePrice", Long.valueOf(vehiclePrice));
		query.setParameter("duration", Long.valueOf(duration));
		return query.getSingleResult();
	}
	
	public List<Rate> findAll() {
		return em.createQuery("from Rate", Rate.class).getResultList();
	}
}
