package com.ant.spring.bean.definition;

import com.ant.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *  Bean 实例化示例
 * </p>
 *
 * @Author Ant
 * @since 2020/1/18 10:59 下午
 **/
public class BeanInstantinationDemo {
    public static void main(String[] args) {
        // 配置 XML 文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-creation-context.xml");

        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);

        System.out.println(user);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);

        System.out.println(user == userByInstanceMethod);
        System.out.println(user == userByFactoryBean);
    }
}
