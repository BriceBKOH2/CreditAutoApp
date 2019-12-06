package com.bnpp.creditauto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rate_")
public class Rate {
	
	@Id
	@Column(name="rate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	
	@Column(name="rate_amount")
	private Double rateAmount;
	
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

}
