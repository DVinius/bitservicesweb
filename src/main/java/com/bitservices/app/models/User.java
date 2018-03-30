package com.bitservices.app.models;

public class User {
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobilePhoneNumber;
	
	public User() {}
	
	public User(final Integer id) {
		super();
		this.id = id;
	}
	
	public User(String firstName, String lastName, String emai, String mobilePhoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = emai;
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	
}
