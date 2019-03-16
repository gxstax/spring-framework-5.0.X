package com.ant.importselector.test;

import com.ant.importselector.config.Appconfig;
import com.ant.importselector.dao.IndexDao;
import com.ant.importselector.selector.MyInvocationHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Ant
 * @ClassName: TestDemo
 * @Description: 读取spring5.源码入口
 * @datetime 2018/11/8 19:50
 * @Version 1.0
 */
public class TestDemo {
	static volatile int index = 1;
	public static void main(String[] args) {
		// 把spring的所有前提环境准备好
		// 1、准备工厂 == DefaultListableBeanFactory
		// 2、实例化一个bdReader 和一个 scanner
		AnnotationConfigApplicationContext annotationConfigApplicationContext
				= new AnnotationConfigApplicationContext();

		/**
		 * 这行代码是把我们自己定义的AppConfig.class的class类转换成bd,
		 * 然后put到我们的beanDifinitionMap当中去;
		 * beanDifinitonMap实际上是我们的DefaultListableBeanFactory的属性
		 * 那么我们的DefaultListableBeanFactory是怎么来的呢？在工厂中的什么位置呢？
		 **/

		annotationConfigApplicationContext.register(Appconfig.class);

		annotationConfigApplicationContext.refresh();

//		IndexDao bean = annotationConfigApplicationContext.getBean(IndexDao.class);
//		System.out.println(bean.query());



		IndexDao indexDao = (IndexDao) Proxy.newProxyInstance(TestDemo.class.getClassLoader(), new Class[]{IndexDao.class}, new MyInvocationHandler());

		indexDao.query();



//		ExecutorService executorService = Executors.newCachedThreadPool();
//		for (;index < 100; index++) {
//				executorService.execute(new Runnable() {
//					@Override
//					public void run() {
//						for (int j = index*+100000; j < index*100000+99999; j++){
//							bean.insert("name#"+j);
//						}
//					}
//				});
//			}
		}
}
