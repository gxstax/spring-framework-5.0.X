package com.ant.importregistrar.config;

import com.ant.importregistrar.anno.AntMapperScan;
import com.ant.importregistrar.registrar.MyImportBeanDefinitionRegistrar;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: Appconfig
 * @Description: Appconfig
 * @datetime 2019/3/16 18:37
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.ant.importregistrar")
@Import(MyImportBeanDefinitionRegistrar.class)
@AntMapperScan
//@MapperScan
public class Appconfig {
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
