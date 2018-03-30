package com.bitservices.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.bitservices.app.enums.FaucetType;
import com.bitservices.app.models.Faucet;
import com.bitservices.app.models.Wallet;

@Repository
public class FaucetDAO extends BasicDAO{
	
	@Cacheable("wallet")
	public List<Wallet> getAllActiveWallets(final Locale locale){
		final String localeField = locale.getLanguage().equals(new Locale("pt").getLanguage()) ? "PTDESC" : "ENGDESC";
		final String query = String.format("SELECT W.NAME, W.URL, W.MYADDRESS, D.%s, W.IMAGESRC FROM WALLET W JOIN DESCRIPTION D ON W.DESCRIPTIONID = D.DESCID WHERE W.ACTIVE = 1", localeField);
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Wallet>>() {

			@Override
			public List<Wallet> extractData(ResultSet rs) throws SQLException, DataAccessException {
				final List<Wallet> result = new ArrayList<Wallet>();
				while (rs.next()) {
					final String name = rs.getString(1);
					final String url = rs.getString(2);
					final String myAddress = rs.getString(3);
					final String desc = rs.getString(4);
					final String image = rs.getString("IMAGESRC");
					
					final Wallet wallet = new Wallet(-1, name, url, desc, myAddress);
					wallet.setImage(image);
					wallet.setFaucetType(FaucetType.WALLET); 
					wallet.setActionName("Create your wallet");
					result.add(wallet);
				}
				return result;
			}  
		});
	} 
	
	@Cacheable("descriptionById")
	public String getDescriptionById(final String localeField, final Integer descId) {
		final String query = String.format("SELECT %s FROM DESCRIPTION WHERE DESCID = ?", localeField);
		return this.jdbcTemplate.query(query, new Integer[] {descId}, new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return rs.getString(localeField);
				}
				return null;
			}
			
		}); 
	} 
	
	@Cacheable("faucetList")
	public List<Faucet> getAllActivesByType(final Locale locale, final FaucetType faucetType){

		final String localeField = locale.getLanguage().equals(new Locale("pt").getLanguage()) ? "PTDESC" : "ENGDESC";
		final String query = "SELECT NAME, URL, DESCRIPTIONID, ACTIONDESCRIPTIONID, IMAGESRC FROM FAUCETOBJ F WHERE F.ACTIVE = ? AND F.FTYPE = ? ORDER BY FID DESC";
		return jdbcTemplate.query(query, new Object[]{true, faucetType.getId()}, new ResultSetExtractor<List<Faucet>>() {

			@Override
			public List<Faucet> extractData(ResultSet rs) throws SQLException, DataAccessException {
				final List<Faucet> result = new ArrayList<Faucet>();
				while (rs.next()) {
					final String name = rs.getString("NAME");
					final String url = rs.getString("URL");
					final String imageSrc = rs.getString("IMAGESRC");
					
					final Integer descId = rs.getInt("DESCRIPTIONID");
					final Integer actionDescId = rs.getInt("ACTIONDESCRIPTIONID");
					
					final String desc = getDescriptionById(localeField, descId);
					final String actionDesc = getDescriptionById(localeField, actionDescId);
					final Faucet faucet = new Faucet(-1,name,url,desc);
					faucet.setFaucetType(faucetType);
					faucet.setActionName(actionDesc);
					faucet.setImage(imageSrc);
					
					result.add(faucet);
				}
				return result;
			}
			
		});
	
	}
	
	@Cacheable("allActiveFaucets")
	public List<Faucet> getAllByActives(final Locale locale) {
		return this.getAllByActiveStatus(true, locale);
	}
	
	@Cacheable("faucetByStatus")
	public List<Faucet> getAllByActiveStatus(final boolean activeStatus, final Locale locale) {
		final String localeField = locale.getLanguage().equals(new Locale("pt").getLanguage()) ? "PTDESC" : "ENGDESC";
		return jdbcTemplate.query("SELECT FID,NAME,URL,"+localeField+",FTYPE FROM FAUCETOBJ JOIN DESCRIPTION ON FAUCETOBJ.DESCRIPTIONID = DESCRIPTION.DESCID WHERE ACTIVE = ?", new Boolean[]{activeStatus}, new ResultSetExtractor<List<Faucet>>() {

			@Override
			public List<Faucet> extractData(ResultSet rs) throws SQLException, DataAccessException {
				final List<Faucet> result = new ArrayList<Faucet>();
				while (rs.next()) {
					final Integer id = rs.getInt(1);
					final String name = rs.getString(2);
					final String url = rs.getString(3);
					final String desc = rs.getString(4);
					final FaucetType faucetType = FaucetType.getById(rs.getInt(5));
					final Faucet faucet = new Faucet(id,name,url,desc);
					faucet.setFaucetType(faucetType);
					result.add(faucet);
				}
				return result;
			}
			
		});
	}

}
