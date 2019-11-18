package com.ant.demo;

import com.ant.demo.beanfactorypostprocessor.AntBeanFactoryPostProcessor;
import com.ant.demo.config.AppConfig;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author Ant
 * @since 2019-11-14 14:34
 */
public class TestDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);

		context.addBeanFactoryPostProcessor(new AntBeanFactoryPostProcessor());

		context.refresh();

	}
}
