package com.ant.test;

import com.ant.Service.UserService;
import com.ant.beanfactoryfostprocessor.MyBeanFactoryPostProcessor;
import com.ant.config.AppConfig;
import com.ant.dao.IndexDao;
import com.ant.dao.UserDao;
import com.ant.dao.UserDaoImpl;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: TestDemo
 * @Description: 读取spring5.源码入口
 * @datetime 2018/11/8 19:50
 * @Version 1.0
 */
public class TestDemo {
	public static void main(String[] args) {
		// 把spring的所有前提环境准备好
		// 1、准备工厂 == DefaultListableBeanFactory
		// 2、实例化一个bdReader 和一个scanner
		AnnotationConfigApplicationContext annotationConfigApplicationContext
				= new AnnotationConfigApplicationContext();

		/**
		 * 测试自定义的BeanFactoryPostProcessor
		 */
//		BeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
//		annotationConfigApplicationContext.addBeanFactoryPostProcessor(beanFactoryPostProcessor);

		/**
		 * 这行代码是把我们自己定义的AppConfig.class的class类转换成bd,
		 * 然后put到我们的beanDifinitionMap当中去;
		 * beanDifinitonMap实际上是我们的DefaultListableBeanFactory的属性
		 * 那么我们的DefaultListableBeanFactory是怎么来的呢？在工厂中的什么位置呢？
		 **/
		annotationConfigApplicationContext.register(AppConfig.class);


		/**
		 * 初始化Spring的环境
		 */
		annotationConfigApplicationContext.refresh();

		IndexDao dao = annotationConfigApplicationContext.getBean(IndexDao.class);
		dao.query();

//		UserService service = annotationConfigApplicationContext.getBean(UserService.class);
//		service.query();
	}
}
