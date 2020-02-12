package com.ant.spring.bean.definition;

import com.ant.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * <p>
 *  Bean 实例化示例
 * </p>
 *
 * @Author Ant
 * @since 2020/1/18 10:59 下午
 **/
public class SpecialBeanInstantinationDemo {
    public static void main(String[] args) {
        // 配置 XML 文件
        // 启动 Spring 应用上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-creation-context.xml");

        // 通过 ApplicationContext 获取 AutowireCapableBeanFactory
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);

        displayServiceLoader(serviceLoader);
//        serviceLoaderDemo();


    }

    private static void serviceLoaderDemo() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());

        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory next = iterator.next();
            System.out.println(next.createUser());
        }
    }
}
