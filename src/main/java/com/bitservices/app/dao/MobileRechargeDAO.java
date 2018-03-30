package com.bitservices.app.dao;

import java.util.Calendar;

import org.springframework.stereotype.Repository;

import com.bitservices.app.enums.PhoneRechargeStatus;
import com.bitservices.app.models.PhoneRecharge;

@Repository
public class MobileRechargeDAO extends BasicDAO{
	
	public boolean registerRecharge(final PhoneRecharge phoneRecharge) {
		final String insert = "INSERT INTO PHONERECHARGE VALUES (null,?,?,?,?,?,?,?,?)";
		
		final String userFullName = phoneRecharge.getUser().getLastName()+", "+phoneRecharge.getUser().getFirstName();
		final String phoneNumber = phoneRecharge.getUser().getMobilePhoneNumber();
		
		final Object[] values = new Object[] {
				userFullName,
				phoneNumber, 
				phoneRecharge.getMobileProvider(), 
				phoneRecharge.getValue(),
				phoneRecharge.getValueToDeposit(),
				Calendar.getInstance(),
				phoneRecharge.getWallet().getMyAddress(),
				PhoneRechargeStatus.PENDING.getId()
				};
		int affectedRows = this.jdbcTemplate.update(insert, values);
		
		return affectedRows > 0;
	}

}
