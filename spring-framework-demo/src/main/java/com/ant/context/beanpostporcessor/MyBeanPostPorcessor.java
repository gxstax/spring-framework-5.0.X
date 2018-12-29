package com.ant.context.beanpostporcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: MyBeanPostPorcessor
 * @Description: 自定义一个BeanPostPorcessor
 * @datetime 2018/11/18 11:39
 * @Version 1.0
 */
//@Component
public class MyBeanPostPorcessor implements BeanPostProcessor{
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		if(beanName.equals("indexDao")) {

			System.out.println("BeforeInitialization");

		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		if(beanName.equals("indexDao")) {

			System.out.println("AfterInitialization");
		}
		return bean;
	}
}
