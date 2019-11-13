package com.ant.importselector.selector;

import com.ant.importselector.anno.AntAuto;
import com.ant.importselector.dao.IndexDao;
import com.ant.importselector.dao.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.HashMap;

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

				AntAuto annotation = bean.getClass().getAnnotation(AntAuto.class);
				if (null != annotation) {
					System.out.println(bean.getClass().getMethods());
				}


				Field[] fields = bean.getClass().getDeclaredFields();
				for (Field field : fields) {
					System.out.println(field.getName());
				}

				Field baiduParamsMap = bean.getClass().getDeclaredField("name");
				HashMap options = new HashMap(3);
				// 传入可选参数调用接口
				options.put("language_type", "CHN_ENG");
				options.put("detect_direction", "true");
				options.put("detect_language", "true");
				baiduParamsMap.setAccessible(true);
				baiduParamsMap.set(bean, "caojjjjjjs");


				Class<?> aClass = bean.getClass();

				Method[] methods = aClass.getMethods();
				for (Method method : methods) {
					AntAuto annotation1 = method.getAnnotation(AntAuto.class);

					if (null != annotation1) {


//						HashMap map = new HashMap(1);
//						map.put("key", "扯淡");
//
//						Parameter[] parameters = method.getParameters();
//						Parameter[] newParams;
//						if (parameters.length > 1) {
//							newParams = new Parameter[parameters.length-1];
//							for (int i = 0; i < parameters.length; i++) {
//
//							}
//						} else {
//							newParams = parameters;
//						}
//
//						Method setName = aClass.getDeclaredMethod(method.getName(), String.class, HashMap.class);
//
//						setName.invoke(bean, parameters);
					}

				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
//		System.out.println("after---");
		return bean;
	}
}
