package com.ant.spring.ioc.overview.container;

import com.ant.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * <p>
 *
 * {@link org.springframework.beans.factory.BeanFactory} 作为 IOC 容器
 * </p>
 *
 * @author  Ant gxstax@163.com
 * @since 2020-01-10 09:17
 */
public class BeanFactoryAsIocContainer {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 加载配置
        String locationXmlPath = "META-INF/dependency-lookup-context.xml";
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int beanCount = reader.loadBeanDefinitions(locationXmlPath);

        System.out.println("Bean 定义加载的数量 -> " + beanCount);

        /**
         * 用上面这种方式也可以获取IOC容器，
         * 但是这里注意的是这种方式缺少了事件或资源管理的一些特性
         */

        // 依赖查找集合对象
        lookupByCollectionType(beanFactory);

    }


    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + beansOfType);
        }
    }
}
