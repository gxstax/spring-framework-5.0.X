package com.ant.importselector.selector;

import com.ant.importselector.dao.IndexDao;
import com.ant.importselector.dao.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
		if(beanName.equals("aaa")) {
			try {
				Field name = bean.getClass().getDeclaredField("name");
				Method setName = bean.getClass().getDeclaredMethod("setName", String.class);
				setName.invoke(bean, "ljsladjdfljfa");
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
//		System.out.println("after---");
		return null;
	}
}
