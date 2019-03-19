package com.ant.context.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Ant
 * @ClassName: IndexDao
 * @Description: TODO
 * @datetime 2018/11/17 16:25
 * @Version 1.0
 */
@Component
public class IndexDao implements Dao, ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public String query () {
		return "this is xiao xie de ";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
