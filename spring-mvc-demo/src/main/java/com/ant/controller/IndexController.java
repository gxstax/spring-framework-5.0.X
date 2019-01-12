package com.ant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ant
 * @ClassName: TestController
 * @Description: 测试Controller
 * @datetime 2019/1/10 17:00
 * @Version 1.0
 */
@Controller
public class IndexController {

	@RequestMapping(value = "/index")
	@ResponseBody
	public String test(){
		return "sss";
	}
}
