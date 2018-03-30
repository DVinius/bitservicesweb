package com.bitservices.app.dao;

import java.util.Calendar;

import org.springframework.stereotype.Repository;

import com.bitservices.app.models.UberGift;
import com.bitservices.app.models.User;

@Repository
public class UberGiftDAO extends BasicDAO {
	
	public int createUberGift(final UberGift uberGift) {
		final String insert = "INSERT INTO UBERGIFT VALUES (NULL,?,?,?,?,?,?,?,?)";
		
		final User user = uberGift.getUser();
		
		final Object[] values = new Object[] {
				user.getEmail(),
				user.getMobilePhoneNumber(), 
				user.getFirstName(), 
				user.getLastName(),
				uberGift.getValueToDeposit(),
				uberGift.getValue(),
				Calendar.getInstance(),
				false
				};
		return this.jdbcTemplate.update(insert, values);
	}

}
