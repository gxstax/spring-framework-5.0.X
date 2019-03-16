package com.ant.importselector.selector;

import com.ant.importselector.dao.IndexDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: MyInvocationHandler
 * @Description: MyInvocationHandler
 * @datetime 2019/3/16 17:51
 * @Version 1.0
 */
public class MyInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		method.invoke(IndexDao.class, proxy, args);
		System.out.println("asdfasfdsadasdf");
		return null;
	}
}
