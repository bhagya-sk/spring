package com.reactiveworks.accountservice.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.reactiveworks.accountservice.*")
@PropertySource(value = { "classpath:database.properties" })
@EnableTransactionManagement(proxyTargetClass = true)
public class AccountConfiguration {

	@Autowired
	private Environment env;

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplateBean() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSourceBean());
		return jdbcTemplate;
	}

	@Bean(name = "dataSource")
	public BasicDataSource dataSourceBean() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;

	}
	
	@Bean(name="transactionManager")
	public TransactionManager transactionManagerBean() {
		TransactionManager transactionManager=new DataSourceTransactionManager(dataSourceBean());
		return transactionManager;
	}

}
