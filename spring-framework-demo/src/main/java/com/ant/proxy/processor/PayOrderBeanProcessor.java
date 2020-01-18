package com.ant.proxy.processor;

import com.ant.proxy.anno.SetMemberAndOrder;
import com.ant.proxy.service.impl.ServiceBImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-10-22 08:52
 */
public class PayOrderBeanProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ServiceBImpl) {
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                SetMemberAndOrder annotation = method.getAnnotation(SetMemberAndOrder.class);
                if (annotation != null) {
                    Object o = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new PayOrderInvocationHandler());
                    return o;
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return null;
    }
}
