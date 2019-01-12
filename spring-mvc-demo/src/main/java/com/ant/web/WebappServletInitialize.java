package com.ant.web;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author Ant
 * @ClassName: WebappServletInitialize
 * @Description: web服务入口
 * @datetime 2019/1/11 8:29
 * @Version 1.0
 */
public class WebappServletInitialize implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("----------------onStartup------------------");
	}
}
