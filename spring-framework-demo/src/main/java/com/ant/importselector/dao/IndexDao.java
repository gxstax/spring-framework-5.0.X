package com.ant.importselector.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: IndexDao
 * @Description: IndexDao
 * @datetime 2019/3/14 21:41
 * @Version 1.0
 */

public interface IndexDao {
	@Select("select name from user where id = 1 ")
	String query();


	@Insert({"insert into user(name) values (#{names})"})
	int insert(String names);
}
