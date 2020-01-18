package com.ant.aop.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @ClassName AppConfig
 * @Description AppConfig
 * @Author Ant
 * @Date 2019-05-25 18:23
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.ant.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
//	@Bean
//	public JdbcTemplate jdbcTemplate (DataSource dataSource) {
//		JdbcTemplate jdbcTemplate = new JdbcTemplate();
//		jdbcTemplate.setDataSource(dataSource);
//		return jdbcTemplate;
//	}
//
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		return dataSource;
//	}
}
