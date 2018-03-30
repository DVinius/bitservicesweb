package com.bitservices.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.bitservices.app.models.News;

@Repository
public class NewsDAO extends BasicDAO{
	private static final String DEFAULT_IMG_SRC = "https://storage.googleapis.com/app-static-files/images/default-news-icon.jpg";
	
	/**
	 * Get latest news
	 * @return
	 */
	@Cacheable("news")
	public List<News> getLatestNews(){
		final String query = "SELECT NID,TITLE,MYCOMMENT,NURL,VOTESUP,VOTESDOWN,PUBLISHEDDATE,NIMG FROM NEWS ORDER BY NID DESC LIMIT 10";
		final List<News> result = super.jdbcTemplate.query(query, new Object[] {}, new ResultSetExtractor<List<News>>() {

			@Override
			public List<News> extractData(ResultSet rs) throws SQLException, DataAccessException {
				final List<News> tempRes = new ArrayList<News>();
				while(rs.next()) {
					final Integer nid = rs.getInt("NID");
					final String title = rs.getString("TITLE");
					final String comment = rs.getString("MYCOMMENT");
					final String url = rs.getString("NURL");
					final Integer votesUp = rs.getInt("VOTESUP");
					final Integer votesDown = rs.getInt("VOTESDOWN");
					final Date pdate = rs.getDate("PUBLISHEDDATE");
					
					final String img = rs.getString("NIMG") != null ? rs.getString("NIMG") : DEFAULT_IMG_SRC; 
					
					final News news = new News(nid,url, title, comment, votesUp, votesDown);
					news.setImg(img);
					news.setPublishedDate(pdate);
					tempRes.add(news);
				}
				return tempRes;
			}
			
		});
		
		return result;
	}
	
	public Boolean create(final News news) {
		final String query = "INSERT INTO NEWS(NID,TITLE,NURL,VOTESUP,VOTESDOWN,PUBLISHEDDATE,MYCOMMENT,NIMG) VALUES (?,?,?,?,?,?,?,?)";
		final Object[] values = new Object[] {
				news.getNid(),
				news.getTitle(), 
				news.getUrl(),
				news.getVotesUp(),
				news.getVotesDown(),
				news.getPublishedDate(),
				news.getMyComment(),
				news.getImg()
				};
		final Integer affectedRows = super.jdbcTemplate.update(query, values);
		return affectedRows > 0;
	}
	
	//TODO XXX implement pagination 
	public List<News> getBurningNews(){
		List<News> result = new ArrayList<News>();
		
		final String query = "SELECT NID,TITLE,MYCOMMENT,NURL,VOTESUP,VOTESDOWN,PUBLISHEDDATE FROM NEWS ORDER BY VOTESUP DESC LIMIT 5";
		result = super.jdbcTemplate.query(query, new Object[] {}, new ResultSetExtractor<List<News>>() {

			@Override
			public List<News> extractData(ResultSet rs) throws SQLException, DataAccessException {
				final List<News> tempRes = new ArrayList<News>();
				while(rs.next()) {
					final Integer nid = rs.getInt("NID");
					final String title = rs.getString("TITLE");
					final String comment = rs.getString("MYCOMMENT");
					final String url = rs.getString("NURL");
					final Integer votesUp = rs.getInt("VOTESUP");
					final Integer votesDown = rs.getInt("VOTESDOWN");
					final Date pdate = rs.getDate("PUBLISHEDDATE");
					
					final News news = new News(nid, url, title, comment, votesUp, votesDown);
					news.setPublishedDate(pdate);
					tempRes.add(news);
				}														
				return tempRes;
			}
			
		});
		
		return result;
	}

	@Cacheable("newsid")
	public News findById(String nid) {
		final String query = "SELECT NID,TITLE,MYCOMMENT,NURL,VOTESUP,VOTESDOWN,PUBLISHEDDATE,NIMG FROM NEWS WHERE NID = ?";
		final News result = super.jdbcTemplate.query(query, new Object[] {nid}, new ResultSetExtractor<News>() {

			@Override
			public News extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					final Integer nid = rs.getInt("NID");
					final String title = rs.getString("TITLE");
					final String comment = rs.getString("MYCOMMENT");
					final String url = rs.getString("NURL");
					final Integer votesUp = rs.getInt("VOTESUP");
					final Integer votesDown = rs.getInt("VOTESDOWN");
					final Date pdate = rs.getDate("PUBLISHEDDATE");
					final String img = rs.getString("NIMG") != null ? rs.getString("NIMG") : DEFAULT_IMG_SRC;
					
					final News news = new News(nid, url, title, comment, votesUp, votesDown);
					news.setPublishedDate(pdate);
					news.setImg(img);
					return news;
				}														
				return null;
			}
			
		});
		return result;
	}

	public News getHighestNewsId() {
		final Integer id = super.jdbcTemplate.query("SELECT MAX(NID) AS NID FROM NEWS", new ResultSetExtractor<Integer>() {
			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return rs.getInt("NID");
				}
				return null;
			}
			
		}); 
		final News result = new News(id);
		return result;
	}

	/**
	 * Compute vote and return the current votes amount (up and down)
	 * 
	 * @param news The voted object
	 */
	public News registerVote(final News news) {
		String field = "";
		if (news.getVotesUp() != null && news.getVotesUp() > 0) {
			field = "VOTESUP";
		} else if (news.getVotesDown() != null && news.getVotesDown() > 0) {
			field = "VOTESDOWN";
		}  
		final String query = String.format("UPDATE NEWS SET %s = %s +1 WHERE NID = ?", field, field);
		final int affectedRows = super.jdbcTemplate.update(query, new Object[] {news.getNid()});
		if (affectedRows > 0) {
			final String queryVotes = "SELECT VOTESUP,VOTESDOWN FROM NEWS WHERE NID = ?";
			final News result = super.jdbcTemplate.query(queryVotes, new Object[] {news.getNid()}, new ResultSetExtractor<News>() {

				@Override
				public News extractData(ResultSet rs) throws SQLException, DataAccessException {
					final News result = new News();
					if (rs.next()) {
						result.setVotesUp(rs.getInt("VOTESUP"));
						result.setVotesDown(rs.getInt("VOTESDOWN"));
					}
					return result;
				}
				
			});
			news.setVotesUp(result.getVotesUp());
			news.setVotesDown(result.getVotesDown());
		}
		return news;
	}

}
