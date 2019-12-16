package com.bnpp.creditauto.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bnpp.creditauto.exception.RateNotFoundException;
import com.bnpp.creditauto.exception.UserNotFoundException;
import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.Rate;
import com.bnpp.creditauto.model.User;

@Repository
public class RateDao extends AbstractDao<Rate> {

	@Override
	protected Class<Rate> getEntityClass() {
		return Rate.class;
	}

	// aller chercher le bon taux en fonction des paramètres saisis par le conseiller.
	/**
	 * Method that retrieve the correct rate from the database according to parameters entered.
	 * @param cat the vehicle Category
	 * @param vehiclePrice the price of the vehicle. Integer number : we do not care for cents
	 * @param duration duration in months of the loan
	 * @return the Rate
	 */
	public Rate getDecisionRate(Category cat, long vehiclePrice, int duration) throws RateNotFoundException {

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
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new RateNotFoundException("No rate found for selected parameters.");
		}
	}

	// Implemented in AbstractDao
//	public List<Rate> findAll() {
//		return em.createQuery("from Rate", Rate.class).getResultList();
//	}
	
	public void update(Rate rate) throws RateNotFoundException {
		Session session = getSession();
		Long id = rate.getId();
		if (id == null) {
			throw new RateNotFoundException(id);
		} else if (session.find(Rate.class, rate.getId()) == null) {
			throw new RateNotFoundException(id);
		}
		session.merge(rate);
	}
}
