package com.ant.applicationcontextaware.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-08-28 14:57
 */
@Component
public class StrategyFactory implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}


	public void test() {
		Collection<CreateOrderStrategy> values = applicationContext.getBeansOfType(CreateOrderStrategy.class).values();

		System.out.println("-------------------"+values);
	}
}
