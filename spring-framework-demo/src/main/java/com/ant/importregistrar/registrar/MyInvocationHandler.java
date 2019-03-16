package com.ant.importregistrar.registrar;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: MyInvocationHandler
 * @Description: MyInvocationHandler
 * @datetime 2019/3/16 22:00
 * @Version 1.0
 */
public class MyInvocationHandler<T> implements InvocationHandler {

	T target;

	public MyInvocationHandler(T target) {
		this.target=target;
	}

	public MyInvocationHandler() {}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 得到注解对象
		Select select = method.getDeclaredAnnotation(Select.class);
		// 输出sql语句
		System.out.println(select.value()[0]);
		// 返回执行结果
		return "";
	}
}
