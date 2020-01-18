package com.ant.proxy.processor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-10-22 08:53
 */
public class PayOrderInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getMethods());
        return method.invoke(proxy, args);
    }
}
