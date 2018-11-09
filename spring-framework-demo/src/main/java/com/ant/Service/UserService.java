package com.ant.Service;

import com.ant.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: UserService
 * @Description: TODO
 * @datetime 2018/11/8 19:53
 * @Version 1.0
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public void query() {
		System.out.println("query()");
		userDao.query();
	}
}
