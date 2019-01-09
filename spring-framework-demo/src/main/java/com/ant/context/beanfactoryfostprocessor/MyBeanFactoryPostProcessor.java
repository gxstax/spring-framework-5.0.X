package com.ant.context.beanfactoryfostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Iterator;

/**
 * @author Ant
 * @ClassName: MyBeanFactoryPostProcessor
 * @Description: TODO
 * @datetime 2018/12/3 8:24
 * @Version 1.0
 */

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {


//
		GenericBeanDefinition beanDefinition1 = (GenericBeanDefinition) beanFactory.getBeanDefinition("indexDao");
		beanDefinition1.removeAttribute("ant");

//		System.out.println("MyBeanFactoryPostProcessor");
	}
}
