package com.ant.test;

import com.ant.Service.UserService;
import com.ant.config.AppConfig;
import com.ant.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: TestDemo
 * @Description: TODO
 * @datetime 2018/11/8 19:50
 * @Version 1.0
 */
public class TestDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext acx =
				new AnnotationConfigApplicationContext(AppConfig.class);

		UserService service = acx.getBean(UserService.class);
		service.query();
	}
}
