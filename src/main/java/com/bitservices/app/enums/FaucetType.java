package com.bitservices.app.enums;

public enum FaucetType {
	FAUCET_SITE(1),ANDROID_APP(2), PTC_SITE(3), GAME(4), WALLET(5), ADVERTISE(6), SERVICE(7);
	
	private Integer typeId;
	
	private FaucetType(final Integer id) {
		this.typeId = id;
	}
	
	public Integer getId() {
		return this.typeId;
	}
	
	public static FaucetType getById(final Integer id) {
		for (FaucetType faucetType: FaucetType.values()) {
			if (id == faucetType.getId()) {
				return faucetType;
			}
		}
		return null;
	}
}
