package com.bitservices.app.models;

import java.util.Calendar;

public abstract class BaseBitService {
	private String name;//the service name
	private Integer value;//requested by user in form (R$ 15, R$ 20...)
	private Wallet wallet;
	private String valueToDeposit;
	private Calendar requestDateTime;
	private User user;
	
	public BaseBitService() {
		super();
	}
	
	public BaseBitService(String name, Wallet wallet, String valueToDeposit, Calendar requestDateTime) {
		super();
		this.name = name;
		this.wallet = wallet;
		this.valueToDeposit = valueToDeposit;
		this.requestDateTime = requestDateTime;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValueToDeposit() {
		return valueToDeposit;
	}
	public void setValueToDeposit(String valueToDeposit) {
		this.valueToDeposit = valueToDeposit;
	}
	
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public Calendar getRequestDateTime() {
		return requestDateTime;
	}
	public void setRequestDateTime(Calendar requestDateTime) {
		this.requestDateTime = requestDateTime;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
}
