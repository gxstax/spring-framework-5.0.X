package com.ant.spring.bean.definition;

import com.ant.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 注解方式的Bean
 * </p>
 *
 * @author Ant gxstax@163.com
 * @since 2020/1/16 8:06 下午
 */
// 3.通过 @Import 的方式来进行导入
@Import(AnnotaionBeanDefinitionDemo.Config.class)
public class AnnotaionBeanDefinitionDemo {

    public static void main(String[] args) {
        // 初始化Spring上下文环境
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册Configuration Class(配置类)
        context.register(Config.class);
        // 启动 Spring 应用上下文
        context.refresh();

        // 通过 API 注册 Bean （命名方式）
        registerBeanDefinition(context, "ant", User.class);
        // 通过 API 注册 Bean （非命名方式）
        registerBeanDefinition(context);

        System.out.println("Config 类型的所有 Beans" + context.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans" + context.getBeansOfType(User.class));

        // 显式的关闭Spring应用上下文
        context.close();
    }

    /**
     * <p>
     * 命名 Bean 的注册
     * </p>
     *
     * @param registry
     * @param beanName
     * @param beanClass
     * @return void
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        beanDefinitionBuilder
                .addPropertyValue("id", 1L)
                .addPropertyValue("name", "马以");
        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefiniton
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    /**
     * <p>
     * 非命名 Bean 方式注册
     * </p>
     *
     * @param registry
     * @return void
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry) {
        registerBeanDefinition(registry, null, User.class);
    }


    // 2.通过 @Component 方式
    @Component // 定义当前类作为 Spring Bean (组件)
    public static class Config {
        // 1.通过 @Bean 方式定义
        @Bean(name = {"user", "ant-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("马以");
            return user;
        }
    }

}
