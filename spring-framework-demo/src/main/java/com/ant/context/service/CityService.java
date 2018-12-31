package com.ant.context.service;

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
public class CityService {

	@Autowired()
	private UserService userService;

	public void query() {
		System.out.println("cityService query");
	}

//	public static Object query() {
//		return new Ant();
//	}
}
