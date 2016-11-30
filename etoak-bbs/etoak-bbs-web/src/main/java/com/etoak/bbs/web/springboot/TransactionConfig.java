package com.etoak.bbs.web.springboot;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 多数据源 绑多事务
 * 
 * @author lsc
 *
 *
 * 使用注解@Transactional
 */
@Configuration
public class TransactionConfig {

	@Autowired
	@Qualifier("dataSourceEtoak")
	DataSource dataSourceEtoak;


	@Primary
	@Bean(name = "transactionManager")
	@Qualifier(value = "transactionManager")
	public DataSourceTransactionManager transactionManager() throws SQLException {
		return new DataSourceTransactionManager(dataSourceEtoak);

	}
}
