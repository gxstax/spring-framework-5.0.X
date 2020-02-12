package com.ant.spring.bean.definition;

import com.ant.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * BeanAlias Demo
 * </p>
 *
 * @author Ant gxstax@163.com
 * @since 2020/1/16 7:55 下午
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");

        User user = (User) beanFactory.getBean("user");

        User antUser = (User) beanFactory.getBean("ant-user");

        System.out.printf("user 是否和 antUser 是同一个对象 -> " + (user == antUser));
    }
}
