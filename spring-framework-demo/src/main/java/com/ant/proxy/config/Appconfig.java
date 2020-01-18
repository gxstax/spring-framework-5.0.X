package com.ant.proxy.config;

import com.ant.proxy.processor.PayOrderBeanProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-10-22 09:36
 */
@Configuration
@ComponentScan("com.ant.proxy")
@Import(value = PayOrderBeanProcessor.class)
public class Appconfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
}
