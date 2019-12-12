package com.bnpp.creditauto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="users")
public class User implements IdEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	@NotBlank
	private String firstName;
	
	@Column
	@NotBlank
	private String lastName;
	
	@Column
	@NotBlank
	private String login;
	
	@Column
	@NotBlank
	private String password;
	
	@Column
	@NotBlank
	private String mail;
	
	public User() {}

	public User(Long id, String firstName, String lasttName, String login, String password, String mail) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lasttName;
		this.login = login;
		this.password = password;
		this.mail = mail;
	}
	
	public User(String firstName, String lasttName, String login, String password, String mail) {
		super();
		this.firstName = firstName;
		this.lastName = lasttName;
		this.login = login;
		this.password = password;
		this.mail = mail;
	}

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

	public void setLastName(String lasttName) {
		this.lastName = lasttName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lasttName=" + lastName + ", login=" + login
				+ ", password=" + password + ", mail=" + mail + "]";
	}
	
	
}
