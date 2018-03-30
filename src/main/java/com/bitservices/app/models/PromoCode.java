package com.bitservices.app.models;

import java.util.Date;

/**
 * Promotional codes used to pay for site services.
 * They cannot be used twice by the same user.
 * 
 * @author Franklin Soares
 *
 */
public class PromoCode {
	private Integer cid;
	//the code to be sent
	private String code;
	//the amount of units of this same code
	private Integer amount;
	//used codes
	private Integer used;
	//date and time to expire this code;
	private Date expiration;
	//activate or deactivate the use of the code
	private boolean active;
	//the specific owner of a code
	private User owner;
	
	public PromoCode() {}
	
	public PromoCode(String code, Integer amount, Date expiration, Boolean active) {
		super();
		this.code = code;
		this.amount = amount;
		this.expiration = expiration;
		this.active = active;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
