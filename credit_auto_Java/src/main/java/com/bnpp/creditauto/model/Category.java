package com.bnpp.creditauto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Vehicle Categories that will be used in the decision of the rate of the loan.
 * @author Jordi
 * @author JP
 *
 */
@Entity
@Table(name="car_category_")
public enum Category {
	A("A"),
	B("B"),
	C("C"),
	D("D"),
	E("E"),
	F("F");
	
	@GeneratedValue
	@Id
	@Column(name="car_category_id")
	private Long id;

	@Column(name="car_category_name")
	private String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
