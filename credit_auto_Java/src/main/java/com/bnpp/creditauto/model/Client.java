package com.bnpp.creditauto.model;

import java.sql.Date;
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
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column//(name="client_id")
	private Long id;
	
	@Column//(name="client_firstname")
	private String firstName;
	
	@Column//(name="client_lasttname")
	private String lastName;
	
	@Column//(name="client_birth")
	private Date dateOfBirth;
	
	@Column//(name="client_phone")
	private String phoneNumber;
	
	@Column//(name="client_address")
	private String address;
	
	//@Column(unique = true)
	@Column//(name="client_account_number")
	private Long accountNumber; // Currently not bind to any table, can be set as a foreign key from the account
								// table later

	@OneToMany(mappedBy="client")
	private List<Contract> contract;

	/* Constructors */
	
	public Client() {
		
	}

	public Client(String firstName, String lastName, Date dateOfBirth, String phoneNumber, String address,
			Long accountNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.accountNumber = accountNumber;
	}

	public Client(Long id, String firstName, String lastName, Date dateOfBirth, String phoneNumber, String address,
			Long accountNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.accountNumber = accountNumber;
	}

	/* Getters and Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/* Other Methods */

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", phoneNumber=" + phoneNumber + ", address=" + address + ", accountNumber="
				+ accountNumber + "]";
	}

}