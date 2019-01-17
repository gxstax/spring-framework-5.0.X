package com.ant.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ant
 * @ClassName: BigBearController
 * @Description: 通过实现 HttpRequestHandler 接口来实现Controller
 * @datetime 2019/1/12 18:21
 * @Version 1.0
 */
@Component("/bear")
public class BigBearController implements HttpRequestHandler {
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===== 通过实现 HttpRequestHandler 接口来实现Controller =====");
	}
}
