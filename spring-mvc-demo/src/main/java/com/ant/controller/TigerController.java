package com.ant.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ant
 * @ClassName: TigerController
 * @Description: 通过实现 Controller接口实现Controller控制器
 * @datetime 2019/1/12 16:28
 * @Version 1.0
 */
@Component("/tiger")
public class TigerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("==== 通过实现 Controller接口实现Controller控制器 =====");
		return null;
	}
}
