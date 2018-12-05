package com.ant.beanfactoryfostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: MyBeanFactoryPostProcessor
 * @Description: TODO
 * @datetime 2018/12/3 8:24
 * @Version 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanFactoryPostProcessor");
	}
}
