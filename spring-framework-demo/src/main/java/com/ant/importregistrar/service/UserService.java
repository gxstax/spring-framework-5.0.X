package com.ant.importregistrar.service;

import com.ant.importregistrar.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: UserService
 * @Description: UserService
 * @datetime 2019/3/16 20:12
 * @Version 1.0
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void query() {
		System.out.println(userDao.query());
	}
}
