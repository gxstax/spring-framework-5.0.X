package com.ant.test.enhancer;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: MyCallback
 * @Description: TODO
 * @datetime 2018/12/9 13:51
 * @Version 1.0
 */
public class MyCallback implements MethodInterceptor{

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("method----");
		methodProxy.invokeSuper(o, objects);
		return null;
	}
}
