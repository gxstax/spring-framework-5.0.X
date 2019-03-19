package com.ant.importregistrar.dao;

import org.apache.ibatis.annotations.Select;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: UserDao
 * @Description: UserDao
 * @datetime 2019/3/16 18:37
 * @Version 1.0
 */
public interface UserDao {
	@Select("select name from user where id = 1 ")
	String query();
}
