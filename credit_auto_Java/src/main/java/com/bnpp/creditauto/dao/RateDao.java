package com.bnpp.creditauto.dao;

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

		String jpql = "from Rate join decision "
				+ "on decision_rate_id = rate_id "
//				+ "and decision_car_category_id = :catId "
				+ "where decision_min_amount <= :vehiclePrice " // smaller or equals : boundaries do not overlap
				+ "and decision_max_amount >= :vehiclePrice "
				+ "and decision_min_duration <= :duration "
				+ "and decision_max_duration >= :duration";
		
		TypedQuery<Rate> query = em.createQuery(jpql, Rate.class);
		query.setParameter("catId", cat.getId());
		query.setParameter("vehiclePrice", vehiclePrice);
		query.setParameter("duration", duration);
		
		return query.getSingleResult();
	}
}
