package com.ant.spring.bean.definition;

import com.ant.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * <p>
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * </p>
 *
 * @author Ant gxstax@163.com
 * @since 2020-01-11 17:02
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {

        // 1.通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder
                .addPropertyValue("id", 1)
                .addPropertyValue("name", "马以");
        // 获取实例 BeanDefiniton并非bean的终态，所以我们可以自定义修改
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();


        // 2.通过 AbstractBeanDefinition 去派生
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("id", 1);
//        propertyValues.addPropertyValue("name", "马以");
        propertyValues
                .add("id", 1)
                .add("name", "马以");
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
