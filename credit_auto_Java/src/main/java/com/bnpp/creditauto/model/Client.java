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
public class Client implements IdEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private Date dateOfBirth;
	
	@Column
	private String phoneNumber;
	
	@Column
	private String address;
	
<<<<<<< HEAD
	@Column//(name="client_active")
	private Boolean isActive;
	
	//@Column(unique = true)
	@Column//(name="client_account_number")
	private Long accountNumber; // Currently not bind to any table, can be set as a foreign key from the account
=======
	@Column//(unique = true)
	private Long accountNumber; // Currently not bound to any table, can be set as a foreign key from the account
>>>>>>> 4d0e4e1e322cb71d6878ffbed3b484da5cf4cab6
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
		this.isActive = true;
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
		this.isActive = true;
	}

	// Constructor to choose the value of field "isActive" to know if the account is closed or not
	public Client(String firstName, String lastName, Date dateOfBirth, String phoneNumber, String address,
			Long accountNumber, Boolean isActive) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.accountNumber = accountNumber;
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
