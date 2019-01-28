package com.ant.context.invocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Ant
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
		String result = method.invoke(obj,args).toString().toUpperCase();
		return result;
	}
}
