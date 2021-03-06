package com.bnpp.creditauto.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bnpp.creditauto.exception.RateNotFoundException;
import com.bnpp.creditauto.model.Contract;
import com.bnpp.creditauto.model.Rate;

@Repository
public class RateDao extends AbstractDao<Rate> {

	@Override
	protected Class<Rate> getEntityClass() {
		return Rate.class;
	}
	
	@Override
	public List<Rate> findAll(){
		return em.createQuery("FROM Rate rt ORDER BY rt.id ASC", Rate.class).getResultList();
	}
	
	// aller chercher le bon taux en fonction des paramètres saisis par le conseiller.
	/**
	 * Method that retrieve the correct rate from the database according to parameters entered.
	 * @param cat the vehicle Category
	 * @param vehiclePrice the price of the vehicle. Integer number : we do not care for cents
	 * @param duration duration in months of the loan
	 * @return the Rate
	 */
	public Rate getDecisionRate(Contract contract) {

		String jpql = "select rate from DecisionTable dt "
				+ "where dt.categ = :cat "
				+ "and dt.minAmount <= :vehiclePrice " // smaller or equals : boundaries do not overlap
				+ "and dt.maxAmount >= :vehiclePrice "
				+ "and dt.minDuration <= :duration "
				+ "and dt.maxDuration >= :duration";
		
		TypedQuery<Rate> query = em.createQuery(jpql, Rate.class);
		
		query.setParameter("cat", contract.getVehicleCategory());
		query.setParameter("vehiclePrice", contract.getVehiclePrice());
		query.setParameter("duration", contract.getLoanDuration().longValue());
		return query.getSingleResult();
	}

	
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
