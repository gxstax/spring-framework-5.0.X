package com.ant.context.dao;

import com.ant.context.invocationhandler.MyInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

/**
 * @author Ant
 * @ClassName: IndexDao
 * @Description: TODO
 * @datetime 2018/11/17 16:25
 * @Version 1.0
 */

public class IndexDao3 implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		if(beanName.equals("indexDao")) {
//			bean = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Dao.class}, new MyInvocationHandler(bean));
//		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("indexDao")) {
			Object object  = Proxy.newProxyInstance(this.getClass().getClassLoader(), bean.getClass().getInterfaces(), new MyInvocationHandler(bean));
			return object;
		}
		return bean;
	}

}
