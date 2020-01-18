package com.ant.applicationcontextaware.conf;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * <p>
 * 测试ApplicationContextAware功能点
 * </p>
 *
 * @author GaoXin
 * @since 2019-08-28 14:55
 */
@Configuration
@ComponentScan("com.ant.applicationcontextaware")
@MapperScan("com.ant.applicationcontextaware.mapper")
public class AppConfig {

	@Bean
	public SqlSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		return sessionFactoryBean;
	}

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
