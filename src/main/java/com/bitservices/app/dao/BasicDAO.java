package com.bitservices.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BasicDAO {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
}
