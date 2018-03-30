package com.bitservices.app.enums;

public enum PhoneRechargeStatus {
	PENDING(1), CANCELED(2), DONE(3);
	
	private Integer id;
	
	private PhoneRechargeStatus(final Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PhoneRechargeStatus getById(final Integer id) {
		for (PhoneRechargeStatus phoneRechargeStatus: PhoneRechargeStatus.values()) {
			if (phoneRechargeStatus.getId() == id) {
				return phoneRechargeStatus;
			}
		}
		return null;
	}
}
