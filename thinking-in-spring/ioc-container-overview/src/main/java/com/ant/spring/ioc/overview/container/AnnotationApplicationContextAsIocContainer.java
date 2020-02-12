package com.ant.spring.ioc.overview.container;

import com.ant.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * <p>
 *
 * 注解能力的 {@link org.springframework.context.ApplicationContext} 作为 IOC 容器
 * </p>
 *
 * @author  Ant gxstax@163.com
 * @since 2020-01-10 09:17
 */
public class AnnotationApplicationContextAsIocContainer {

    public static void main(String[] args) {
        // 创建 ApplicationContext 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 加载配置
        context.register(AnnotationApplicationContextAsIocContainer.class);

        // 启动IOC上下文
        context.refresh();

        // 依赖查找集合对象
        lookupByCollectionType(context);

        // 关闭IOC
        context.close();

    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("马以");
        return user;
    }


    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + beansOfType);
        }
    }
}
