package com.bnpp.creditauto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class DecisionTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@ManyToOne
	private Category categ;
	
	@ManyToOne
	private Rate rate;
	
	private Long maxAmount;
	
	private Long minAmount;
	
	private Long maxDuration;
	
	private Long minDuration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCateg() {
		return categ;
	}

	public void setCateg(Category categ) {
		this.categ = categ;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public Long getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Long maxAmount) {
		this.maxAmount = maxAmount;
	}

	public Long getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Long minAmount) {
		this.minAmount = minAmount;
	}

	public Long getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(Long maxDuration) {
		this.maxDuration = maxDuration;
	}

	public Long getMinDuration() {
		return minDuration;
	}

	public void setMinDuration(Long minDuration) {
		this.minDuration = minDuration;
	}

}
