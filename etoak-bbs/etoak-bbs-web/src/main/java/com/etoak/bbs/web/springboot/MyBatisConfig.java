package com.etoak.bbs.web.springboot;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ClassUtils;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;

/**
 * MyBatis 配置，初始化MyBatis,定义SqlSession 与SqlSessionFactory
 * 
 * @author lsc
 *
 */
@Configuration
@MapperScan(basePackages = "com.etoak")
public class MyBatisConfig {
	public static Log logger = LogFactory.getLog(MyBatisConfig.class);


	@Autowired
	@Qualifier("dataSourceEtoak")
	private DataSource dataSourceEtoak;


	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sbmSqlSessionFactory() throws Exception {
		logger.info("初始化MyBatis.....");
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(new Log4jdbcProxyDataSource(dataSourceEtoak));
		sessionFactory.setFailFast(true);
		sessionFactory.setMapperLocations(getResource("com/etoak/bbs/data/mapper", "**/*Mapper.xml"));
		return sessionFactory.getObject();
	}

	@Bean
	public SqlSession sqlSession() throws Exception {
		return sbmSqlSessionFactory().openSession();

	}

	public Resource[] getResource(String basePackage, String pattern) throws IOException {
		String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils
				.convertClassNameToResourcePath(new StandardEnvironment().resolveRequiredPlaceholders(basePackage))
				+ "/" + pattern;
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources(packageSearchPath);
		return resources;
	}

}