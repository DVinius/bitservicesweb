package com.bitservices.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.bitservices.app.models.PromoCode;
import com.bitservices.app.models.User;

@Repository
public class PromoDAO extends BasicDAO{

	public PromoCode findByCode(final String code) {
		return jdbcTemplate.query("SELECT CID,AMOUNT,USED,EXPIRATION,ACTIVE,OWNERID FROM PROMOCODE WHERE CODE = ?", new String[]{code}, new ResultSetExtractor<PromoCode>() {

			@Override
			public PromoCode extractData(ResultSet rs) throws SQLException, DataAccessException {
				final PromoCode result = new PromoCode();
				result.setActive(false);
				while (rs.next()) {
					final Integer cid = rs.getInt("CID");
					result.setCid(cid);
					final Integer amount = rs.getInt("AMOUNT");
					result.setAmount(amount);
					final Integer used = rs.getInt("USED");
					result.setUsed(used);
					final Date expDate = rs.getDate("EXPIRATION");
					result.setExpiration(expDate);
					final Boolean active = rs.getBoolean("ACTIVE");
					result.setActive(active);
					final Integer ownerId = rs.getInt("OWNERID");
					final User owner =  new User(ownerId);
					result.setOwner(owner);
				}
				return result;
			}
			
		});
	}
	
	/**
	 * Registra o uso de um codigo promocional por um usuário
	 * 
	 * @param user o usuario que esta utilizando o codigo
	 * @param code o codigo a ser utilizado
	 * @return
	 */
	public Date useCode(final User user, final PromoCode code) {
		final Date usedDate = Calendar.getInstance().getTime();
		final String insertQuery = "INSERT INTO USEDPROMOCODE VALUES ((SELECT U.UID FROM BSUSER U where U.EMAIL = ? OR U.PHONENUMBER = ?), ?, ?)";
		
		final Integer affectedRows = this.jdbcTemplate.update(insertQuery, new Object[] {user.getEmail(), user.getMobilePhoneNumber(), code.getCid(), usedDate}, new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DATE});
		
		if (affectedRows == 1) {
			return usedDate;
		} else {
			return null;
		}
	}
	
	/**
	 * Verifica se um codigo promocional ja foi utilizado por um usuario
	 * 
	 * @param user o usuario cujo id sera verificado junto ao codigo promocional
	 * @param code o codigo a ser verificado
	 * @return nulo, se o cupom ainda nao tiver sido utilizado por este usuário, ou uma data caso 
	 * ja tenha sido utilizado 
	 */
	public Date checkIfAlreadyUsed(final User user, final String code) {
		final String query = "SELECT USEDDATE FROM USEDPROMOCODE where USERID = (SELECT U.UID FROM BSUSER U where U.EMAIL = ? OR U.PHONENUMBER = ?) AND CODEID = (SELECT CID FROM PROMOCODE WHERE CODE = ?)";
		return jdbcTemplate.query(query, new Object[]{user.getEmail(), user.getMobilePhoneNumber(), code}, new ResultSetExtractor<Date>() {

			@Override
			public Date extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					return rs.getDate("USEDDATE");
				}
				return null;
			}
			
		});
	}
}
