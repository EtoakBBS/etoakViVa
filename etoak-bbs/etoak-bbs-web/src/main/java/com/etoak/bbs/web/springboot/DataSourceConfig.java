package com.etoak.bbs.web.springboot;
//package com.etoak;
//
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
///**
// * 多数据原管理。 数据源参数写在application.properties里。
// * 
// * @author lsc
// *
// */
//@Configuration
//public class DataSourceConfig {
//
//	@Primary
//	@Bean(name = "dataSourceEtoak")
//	@ConfigurationProperties(prefix = "spring.datasource.etoak")
//	public DataSource dataSource() throws SQLException {
//		return DataSourceBuilder.create().build();
//	}
//}