package com.ant.spring.ioc.overview.dependency.lookup;

import com.ant.spring.ioc.overview.annotation.Super;
import com.ant.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * <p>
 * 依赖查找示例
 * </p>
 *
 * @author Ant gxstax@163.com
 * @since 2020-01-03 09:21
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 初始化spring容器上下文环境
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("/META-INF/dependency-lookup-context.xml");

        // 按照类型查找
        lookupByType(context);

        // 查找集合对象
        lookupByCollectionType(context);

        // 通过注解查找
        lookupByAnnotation(context);

        // 延迟查找
//        lookupInLazy(context);

        // 实时查找
//        lookupInRealTime(context);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super注解的所有 User 集合对象：" + beansOfType);
        }
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + beansOfType);
        }
    }

    public static void lookupByType(BeanFactory beanFactory) {
        User bean = beanFactory.getBean(User.class);
        System.out.println("类型查找：" + bean);
    }

    public static void lookupInLazy(BeanFactory beanFactory) {
        // ObjectFactory 并没有生成新的bean，而FactoryBean会生成一个新的bean，这就是它俩的区别
        ObjectFactory<User> objectBeanFactory = (ObjectFactory<User>) beanFactory.getBean("objectBeanFactory");
        User user = objectBeanFactory.getObject();
        System.out.println("延时查找：" + user);
    }

    public static void lookupInRealTime(BeanFactory beanFactory) {
        User bean = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + bean);
    }
}
