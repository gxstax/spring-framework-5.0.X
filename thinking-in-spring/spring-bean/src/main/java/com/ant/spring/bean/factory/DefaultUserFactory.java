package com.ant.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <p>
 * 默认 {@link UserFactory} 实现
 * </p>
 *
 * @Author Ant gxstax@163.com
 * @since 2020/1/18 11:10 下午
 **/
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {
    // 1. 基于 @PostConstruct 注解初始化Bean
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct : UserFactory 初始化中...");
    }

    public void initUserFactory() {
        System.out.println("自定义初始化方法 initUserFactory(): UserFactory 初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet: UserFactory 初始化中...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy : UserFactory 销毁中...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("@DisposableBean#destroy : UserFactory 销毁中...");
    }

    public void doDestroy() {
        System.out.println("自定义销毁方法 doDestroy() : UserFactory 销毁中...");
    }
}
