package com.ant.circulreference;

import com.ant.circulreference.conf.AppConfig;
import com.ant.circulreference.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: Test
 * @Description: Test
 * @datetime 2019/3/25 8:38
 * @Version 1.0
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		context.start();

		IndexService service = (IndexService) context.getBean("index");
		service.query();
	}
}
