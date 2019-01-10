package com.ant.springevent.test;

import com.ant.app.Appconfig;
import com.ant.springevent.FilmWatchTrigger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Ant
 * @ClassName: SpringEventTest
 * @Description: Spring事件监听测试
 * @datetime 2019/1/9 10:53
 * @Version 1.0
 */
public class SpringEventTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
		applicationContext.getBean(FilmWatchTrigger.class).filmWatch();

	}
}
