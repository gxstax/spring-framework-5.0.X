package com.ant.test;

import com.ant.web.TomcatService;
import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

/**
 * @author Ant
 * @ClassName: WebMvcTest
 * @Description: 测试类
 * @datetime 2019/1/11 8:16
 * @Version 1.0
 */
public class WebMvcTest {

	public static void main(String[] args) {
		try {
			TomcatService.run();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}
