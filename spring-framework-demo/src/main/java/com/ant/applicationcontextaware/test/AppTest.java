package com.ant.applicationcontextaware.test;

import com.ant.applicationcontextaware.conf.AppConfig;
import com.ant.applicationcontextaware.service.StrategyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-08-28 14:56
 */
public class AppTest {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext();
		acx.register(AppConfig.class);
		acx.refresh();

//		AnnotationConfigWebApplicationContext awcx = new AnnotationConfigWebApplicationContext();
//		awcx.register(AppConfig.class);
//		awcx.refresh();

		StrategyFactory bean = acx.getBean(StrategyFactory.class);
		bean.test();
	}
}
