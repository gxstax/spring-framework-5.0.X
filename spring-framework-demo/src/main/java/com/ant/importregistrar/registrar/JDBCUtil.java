package com.ant.importregistrar.registrar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: JDBCUtil
 * @Description: JDBCUtil
 * @datetime 2019/3/25 19:40
 * @Version 1.0
 */
@Component
public class JDBCUtil extends ApplicationObjectSupport {

	// 获取spring的上下文环境
	private ApplicationContext applicationContext;

	public JDBCUtil(){
		applicationContext = getApplicationContext();
	}



}
