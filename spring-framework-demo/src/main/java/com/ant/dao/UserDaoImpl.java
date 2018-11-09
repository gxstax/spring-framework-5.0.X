package com.ant.dao;

import org.springframework.stereotype.Repository;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: UserDaoImpl
 * @Description: TODO
 * @datetime 2018/11/8 20:08
 * @Version 1.0
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@Override
	public void query() {
		System.out.println("query");
	}
}
