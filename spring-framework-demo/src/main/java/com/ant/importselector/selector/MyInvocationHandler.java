package com.ant.importselector.selector;

import com.ant.importselector.dao.IndexDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

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
		for (Object arg : args) {
			if (arg.getClass().equals(HashMap.class)) {
				HashMap map = new HashMap();
				map.put("key", "扯犊子");
				arg = map;
			}

		}
		Object invoke = method.invoke(IndexDao.class, proxy, args);

		return invoke;
	}
}
