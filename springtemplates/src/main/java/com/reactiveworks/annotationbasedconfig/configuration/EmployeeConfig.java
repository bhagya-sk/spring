package com.reactiveworks.annotationbasedconfig.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.reactiveworks.annotationbasedconfig.dao.implementation.EmployeeDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.reactiveworks.annotationbasedconfig.dao")
@PropertySource("classpath:database.properties")
public class EmployeeConfig {

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	@Bean("employeeDaoImpl")
	public EmployeeDaoImpl employeeDaoImplBean() {
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		employeeDaoImpl.setJdbcTemplate(jdbcTemplateBean());
		return employeeDaoImpl;
	}

	@Bean
	public JdbcTemplate jdbcTemplateBean() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSourceBean());
		return jdbcTemplate;
	}

	@Bean
	public BasicDataSource dataSourceBean() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

//		dataSource.setUrl("jdbc:mysql://localhost:3306/practice?useSSL=FALSE");
//		dataSource.setUsername("root");
//		dataSource.setPassword("sql1234");
		return dataSource;
	}

}