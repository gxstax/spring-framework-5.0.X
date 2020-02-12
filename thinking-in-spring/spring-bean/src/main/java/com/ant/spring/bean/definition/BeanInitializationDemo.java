package com.ant.spring.bean.definition;

import com.ant.spring.bean.factory.DefaultUserFactory;
import com.ant.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>
 * Bean 的初始化示例
 * </p>
 *
 * @author Ant gxstax@163.com
 * @since 2020/1/20 8:40 上午
 */
@ComponentScan("com.ant.spring.bean")
public class BeanInitializationDemo {
    public static void main(String[] args) {
        // 初始化Spring上下文环境
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册Configuration Class(配置类)
        context.register(BeanInitializationDemo.class);
        // 启动 Spring 应用上下文
        context.refresh();

        // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
        System.out.println("------------------------- Spring 应用上下文已启动... ---------------------------");

        UserFactory userFactory = context.getBean(UserFactory.class);

        System.out.println("------------------------- Spring 应用上下文准备关闭 ---------------------------");

        // 关闭 Spring 应用上下文
        context.close();

        System.out.println("------------------------- Spring 应用上下文已经关闭 ---------------------------");
    }

//    @Lazy
    @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
