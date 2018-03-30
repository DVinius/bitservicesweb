package com.acucaradus.app.boot;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(scanBasePackages={"com.acucaradus","com.bitservices"})
public class AcucaradusBoot {

	public static void main(String[] args) {
		SpringApplication.run(AcucaradusBoot.class, args);
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://35.199.94.224:3306/bitServices");
        dataSource.setUsername("dvinius");
        dataSource.setPassword("garnett1423");
		return new JdbcTemplate(dataSource);
	}
}
