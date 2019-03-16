package com.ant.importregistrar.registrar;

import com.ant.importregistrar.dao.UserDao;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: MyImportBeanDefinitionRegistrar
 * @Description: MyImportBeanDefinitionRegistrar
 * @datetime 2019/3/16 18:38
 * @Version 1.0
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 1. 获取一个db (mybatis 扫描得到),我这里直接写死
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserDao.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();

		// 2.增加一个我们bd的构造函数，因为mybatis需要动态的去生成代理类
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
		// 3.这里这里的setBean需要一个beanClass的类对象，而我们的UserDao只是一个接口，
		//   所以我们用factoryBean生成一个UserDao的代理类对象设置为bd的beanClass属性
		beanDefinition.setBeanClass(MyFactoryBean.class);

		// 4. 把我们生成的bd对象注册到我们的spring容器当中去，后面我们就可以直接从spring容器中来拿到这个对象
		registry.registerBeanDefinition(UserDao.class.getName(), beanDefinition);
	}
}

