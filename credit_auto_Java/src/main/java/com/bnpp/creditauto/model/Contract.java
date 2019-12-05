package com.bnpp.creditauto.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contract")
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long vehiculePrice;
	private Long loanAmount;
	private Integer loanDuration;
	private Float rate;
	private Boolean rentRight;
	private Date creationDate;
	
	@OneToOne
	private Client client;
	
	@ManyToOne
	private Category vehiculeCategory;
	
	/* Constructors */
	
	public Contract() {
		
	}
	
	public Contract(Long vehiculePrice, Long loanAmount, Integer loanDuration, Float rate, Boolean rentRight,
			Date creationDate, Client client, Category vehiculeCategory) {
		super();
		this.vehiculePrice = vehiculePrice;
		this.loanAmount = loanAmount;
		this.loanDuration = loanDuration;
		this.rate = rate;
		this.rentRight = rentRight;
		this.creationDate = creationDate;
		this.client = client;
		this.vehiculeCategory = vehiculeCategory;
	}

	public Contract(Long id, Long vehiculePrice, Long loanAmount, Integer loanDuration, Float rate, Boolean rentRight,
			Date creationDate, Client client, Category vehiculeCategory) {
		super();
		this.id = id;
		this.vehiculePrice = vehiculePrice;
		this.loanAmount = loanAmount;
		this.loanDuration = loanDuration;
		this.rate = rate;
		this.rentRight = rentRight;
		this.creationDate = creationDate;
		this.client = client;
		this.vehiculeCategory = vehiculeCategory;
	}
	
	/* Getters and Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVehiculePrice() {
		return vehiculePrice;
	}

	public void setVehiculePrice(Long vehiculePrice) {
		this.vehiculePrice = vehiculePrice;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Boolean getRentRight() {
		return rentRight;
	}

	public void setRentRight(Boolean rentRight) {
		this.rentRight = rentRight;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Category getVehiculeCategory() {
		return vehiculeCategory;
	}

	public void setVehiculeCategory(Category vehiculeCategory) {
		this.vehiculeCategory = vehiculeCategory;
	}

	/* Other Methods */
	
	@Override
	public String toString() {
		return "Contract [id=" + id + ", vehiculePrice=" + vehiculePrice + ", loanAmount=" + loanAmount
				+ ", loanDuration=" + loanDuration + ", rate=" + rate + ", rentRight=" + rentRight + ", creationDate="
				+ creationDate + ", client=" + client + ", vehiculeCategory=" + vehiculeCategory + "]";
	}
	
	
	
}
