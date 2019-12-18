package com.bnpp.creditauto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Vehicle Categories that will be used in the decision of the rate of the loan.
 * 
 * @author Jordi
 * @author JP
 *
 */
@Entity
@Table
public class Category implements IdEntity {

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column
	private Long id;

	@Column(unique = true)
	@NotBlank
	private String name;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
