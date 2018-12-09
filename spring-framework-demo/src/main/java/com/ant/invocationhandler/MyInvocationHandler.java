package com.ant.invocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: MyInvocationHandler
 * @Description: TODO
 * @datetime 2018/12/6 8:17
 * @Version 1.0
 */
public class MyInvocationHandler implements InvocationHandler{
	Object obj;

	public MyInvocationHandler(Object obj){
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我是代理增强");
		return method.invoke(obj,args);
	}
}
