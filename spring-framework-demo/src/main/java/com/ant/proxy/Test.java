package com.ant.proxy;

import com.ant.proxy.config.Appconfig;
import com.ant.proxy.service.ServiceB;
import com.ant.proxy.service.impl.ServiceBImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-10-22 09:43
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.register(Appconfig.class);
		context.refresh();

		ServiceB bean = context.getBean(ServiceB.class);
		bean.b();
	}
}
