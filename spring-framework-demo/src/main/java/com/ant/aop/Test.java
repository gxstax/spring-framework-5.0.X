package com.ant.aop;

import com.ant.aop.conf.AppConfig;
import com.ant.aop.dao.OrderDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Test
 * @Description Test
 * @Author Ant
 * @Date 2019-05-25 18:30
 * @Version 1.0
 **/
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext
				= new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();
		OrderDaoImpl bean = applicationContext.getBean(OrderDaoImpl.class);
		bean.query();
	}
}
