package com.bnpp.creditauto.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private Long vehiclePrice;
	
	@Column
	private Long loanAmount; // Amount the client need to repay
	
	@Column
	private Integer loanDuration;
	
	@Column
	private Double rate;
	
	@Column
	private Boolean rentRight;
	
	@Column
	private Date creationDate;
	
	@ManyToOne
	//@Column
	private Client client;
	
	@ManyToOne
	//@Column
	private Category vehicleCategory;
	
	/* Constructors */
	
	public Contract() {
		
	}
	
	public Contract(Long vehiclePrice, Long loanAmount, Integer loanDuration, Double rate, Boolean rentRight,
			Date creationDate, Client client, Category vehicleCategory) {
		super();
		this.vehiclePrice = vehiclePrice;
		this.loanAmount = loanAmount;
		this.loanDuration = loanDuration;
		this.rate = rate;
		this.rentRight = rentRight;
		this.creationDate = creationDate;
		this.client = client;
		this.vehicleCategory = vehicleCategory;
	}

	public Contract(Long id, Long vehiclePrice, Long loanAmount, Integer loanDuration, Double rate, Boolean rentRight,
			Date creationDate, Client client, Category vehicleCategory) {
		super();
		this.id = id;
		this.vehiclePrice = vehiclePrice;
		this.loanAmount = loanAmount;
		this.loanDuration = loanDuration;
		this.rate = rate;
		this.rentRight = rentRight;
		this.creationDate = creationDate;
		this.client = client;
		this.vehicleCategory = vehicleCategory;
	}
	
	/* Getters and Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(Long vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
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

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
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

	public Category getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(Category vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	/* Other Methods */
	
	@Override
	public String toString() {
		return "Contract [id=" + id + ", vehiclePrice=" + vehiclePrice + ", loanAmount=" + loanAmount
				+ ", loanDuration=" + loanDuration + ", rate=" + rate + ", rentRight=" + rentRight + ", creationDate="
				+ creationDate + ", client=" + client + ", vehicleCategory=" + vehicleCategory + "]";
	}
	
	
	
}
