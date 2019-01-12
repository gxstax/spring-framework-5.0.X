package com.ant.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ant
 * @ClassName: TigerController
 * @Description: 继承Controller形式的Controller
 * @datetime 2019/1/12 16:28
 * @Version 1.0
 */
@Component("/tiger")
public class TigerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("implement Controller");
		return null;
	}
}
