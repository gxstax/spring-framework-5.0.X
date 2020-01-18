package com.ant.factorybean;

import com.ant.factorybean.bean.AntFactoryBean;
import com.ant.factorybean.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-10-21 08:27
 */
public class test {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();


		System.out.println(context.getBean("antFactoryBean"));
	}
}
