package com.bnpp.creditauto.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Rate implements IdEntity {
	
	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String name;
	
	@Column
	private Double rateAmount;
	
	@OneToMany(mappedBy="rate")
	private List<DecisionTable> listDecisionTable;
	
	public Rate() {
		super();
	}

	public Rate(String name, Double rateAmount, List<DecisionTable> listDecisionTable) {
		super();
		this.name = name;
		this.rateAmount = rateAmount;
		this.listDecisionTable = listDecisionTable;
	}

	@Override
	public String toString() {
		return "Rate [name=" + name + ", rateAmount=" + rateAmount + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRateAmount() {
		return rateAmount;
	}

	public void setRateAmount(Double rateAmount) {
		this.rateAmount = rateAmount;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
