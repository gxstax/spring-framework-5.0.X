package com.ant.web;

import com.ant.config.Appconfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletException;
import java.io.File;
import java.util.Iterator;

/**
 * @author Ant
 * @ClassName: TomcatService
 * @Description: tomcat服务
 * @datetime 2019/1/10 15:40
 * @Version 1.0
 */
public class TomcatService {
	public static void run() throws ServletException, LifecycleException {

		File base = new File(System.getProperty("java.io.tmpdir"));

		Tomcat tomcat = new Tomcat();

		// 设置端口号
		tomcat.setPort(9090);

		// addWebapp表示这是一个web项目，现在不需要，因为我们不需要建一个web项目（springboot也没有这么做）
		// contextPath：tomcat的访问路径
		// docbase: 项目的web目录
//		tomcat.addWebapp("/", base.getAbsolutePath());
		// tomcat 在添加容器的时候会初始化一个服务
		// 大概的代码如下：
		//Service service = new StandardService();
		//        service.setName("Tomcat");
		//        server.addService(service);
		//        return server;

		Context context = tomcat.addContext("/", base.getAbsolutePath());
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(Appconfig.class);
		applicationContext.refresh();

		DispatcherServlet servlet = new DispatcherServlet(applicationContext);
		// tomcat启动的过程就会调用DispatcherServlet#init方法
		// 初始化tomcat请求以及请求映射
		// 把我们定义的DispatcherServlet添加到tomcat中去
		tomcat.addServlet(context, "ant", servlet).setLoadOnStartup(0);
		// 设置映射拦截路径
		context.addServletMapping("/", "ant");


		// 启动tomcat
		// 这里需要说明的是，tomcat启动的时候会去调用LifecycleBase.start()方法
		// 然后这个start方法中去调用了startInternal();这个方法(这里其实会经过很多层调用，涉及tomcat源码，不一一去看)
		// 最终会去调用DispatcherServlet的父类的父类HttpServletBean.init()
		// 所以我们直接把断点打在HttpServletBean.init()这个方法上去调试
		tomcat.start();
		// tomcat服务保持
		tomcat.getServer().await();

	}
}
