package com.ant.context.dao;

import com.ant.importregistrar.dao.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: TestDao
 * @Description: TestDao
 * @datetime 2019/3/28 20:20
 * @Version 1.0
 */
public class TestDao  implements ApplicationContextAware {
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		applicationContext.getBean(UserDao.class);
	}
}
