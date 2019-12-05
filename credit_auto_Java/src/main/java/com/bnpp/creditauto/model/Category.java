package com.bnpp.creditauto.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Vehicle Categories that will be used in the decision of the rate of the loan.
 * @author Jordi
 * @author JP
 *
 */
@Entity
@Table(name="category")
public enum Category {
	A("A"),
	B("B"),
	C("C"),
	D("D"),
	E("E"),
	F("F");
	
	private String name;
	
	Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
