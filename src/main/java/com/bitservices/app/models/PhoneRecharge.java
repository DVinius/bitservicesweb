package com.bitservices.app.models;

import java.util.Calendar;

import com.bitservices.app.enums.PhoneRechargeStatus;

public class PhoneRecharge extends BaseBitService{
	private Integer mobileProvider;	
	private PhoneRechargeStatus status;
	
	public PhoneRecharge() {
		super();
	}
	
	public PhoneRecharge(String name, Wallet wallet, String valueToDeposit, Calendar requestDateTime) {
		super(name, wallet, valueToDeposit, requestDateTime);
		this.status = PhoneRechargeStatus.PENDING;
	}
	
	public PhoneRechargeStatus getStatus() {
		return status;
	}

	public void setStatus(PhoneRechargeStatus status) {
		this.status = status;
	}

	public Integer getMobileProvider() {
		return mobileProvider;
	}
	public void setMobileProvider(Integer mobileProvider) {
		this.mobileProvider = mobileProvider;
	}
	
}
