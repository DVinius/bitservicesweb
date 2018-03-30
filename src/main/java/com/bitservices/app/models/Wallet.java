package com.bitservices.app.models;

public class Wallet extends Faucet{
	private String myAddress;
	
	public Wallet(Integer id, String name, String url, String descr, final String address) {
		super(id, name, url, descr);
		setMyAddress(address);
	}
	public String getMyAddress() {
		return myAddress;
	}

	public void setMyAddress(String myAddress) {
		this.myAddress = myAddress;
	}
}
