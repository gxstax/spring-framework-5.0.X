package com.ant.importregistrar.registrar;

import org.apache.ibatis.annotations.Select;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: MyInvocationHandler
 * @Description: MyInvocationHandler
 * @datetime 2019/3/16 22:00
 * @Version 1.0
 */
public class MyInvocationHandler implements InvocationHandler {

	Object target;

	public MyInvocationHandler(Object target) {
		this.target=target;
	}

	public MyInvocationHandler() {}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 得到注解对象
		Select select = method.getDeclaredAnnotation(Select.class);
		String sqlStr = select.value()[0];
		// 输出sql语句
		System.out.println("sql语句是:" + sqlStr);
		// 返回执行结果
		return "sql语句[" + sqlStr +"]执行结果:" + getJdbcResult(sqlStr);
	}


	public String getJdbcResult(String sql) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

		// 定义JdbcTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		// 定义数据源
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		jdbcTemplate.setDataSource(dataSource);

		// 查询结构
		ResultSetExtractor resultSetExtractor = new SqlRowSetResultSetExtractor();
		ResultSetWrappingSqlRowSet rs = (ResultSetWrappingSqlRowSet) jdbcTemplate.query(sql, resultSetExtractor);
		ResultSet resultSet = rs.getResultSet();
		try {
			if (resultSet.next())
				return resultSet.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

}
