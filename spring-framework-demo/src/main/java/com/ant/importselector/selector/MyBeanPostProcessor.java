package com.ant.importselector.selector;

import com.ant.importselector.dao.IndexDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: MyBeanPostProcessor
 * @Description: MyBeanPostProcessor
 * @datetime 2019/3/14 21:35
 * @Version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("before---");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Object obj = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{IndexDao.class}, new MyInvocationHandler());
//		System.out.println("after---");
		return null;
	}
}
