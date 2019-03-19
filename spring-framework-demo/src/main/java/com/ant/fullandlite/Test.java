package com.ant.fullandlite;

import com.ant.fullandlite.conf.Appconfig;
import com.ant.fullandlite.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Test
 * @Description Test
 * @Author Ant
 * @Date 2019-03-19 22:43
 * @Version 1.0
 **/
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext();

		annotationConfigApplicationContext.register(Appconfig.class);
		annotationConfigApplicationContext.refresh();

		annotationConfigApplicationContext.getBean(IndexDao.class).query();
	}
}
