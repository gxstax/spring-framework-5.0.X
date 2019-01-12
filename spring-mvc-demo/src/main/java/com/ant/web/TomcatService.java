package com.ant.web;

import com.ant.config.Appconfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletException;
import java.io.File;

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
		Context context = tomcat.addContext("/", base.getAbsolutePath());
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(Appconfig.class);

		DispatcherServlet servlet = new DispatcherServlet(applicationContext);
		// tomcat启动的过程就会调用DispatcherServlet#init方法
		// 初始化tomcat请求以及请求映射
		tomcat.addServlet(context, "ant", servlet).setLoadOnStartup(0);
		// 设置映射拦截路径
		context.addServletMapping("/", "ant");


		// 启动tomcat
		tomcat.start();
		// tomcat服务保持
		tomcat.getServer().await();



	}
}
