package com.bnpp.creditauto.dao;

import org.springframework.stereotype.Repository;

import com.bnpp.creditauto.model.DecisionTable;

@Repository
public class DecisionTableDao extends AbstractDao<DecisionTable> {

	@Override
	protected Class<DecisionTable> getEntityClass() {
		return DecisionTable.class;
	}

}
