package com.bnpp.creditauto.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table
public class Contract implements IdEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	@NotBlank
	private Long vehiclePrice;
	
	@Column
	@NotBlank
	private Long loanAmount; // Amount lent to the client
	
	@Column
	@NotBlank
	private Long amountDue; // Amount the client need to repay
	
	@Column
	@NotBlank
	private Integer loanDuration;
	
	@Column
	@NotBlank
	private Double rate;
	
	@Column
	private Boolean rentRight;
	
	@Column
	private Date creationDate;
	
	@Column
	private Boolean isActive;
	
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
		this.isActive = true;
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
		this.isActive = true;
	}
	
	public Contract(Long vehiclePrice, Long loanAmount, Integer loanDuration, Double rate, Boolean rentRight,
			Date creationDate, Client client, Category vehicleCategory, Boolean isActive) {
		super();
		this.vehiclePrice = vehiclePrice;
		this.loanAmount = loanAmount;
		this.loanDuration = loanDuration;
		this.rate = rate;
		this.rentRight = rentRight;
		this.creationDate = creationDate;
		this.client = client;
		this.vehicleCategory = vehicleCategory;
		this.isActive = isActive;
	}
	
	/* Getters and Setters */

	@Override
	public Long getId() {
		return id;
	}

	@Override
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
