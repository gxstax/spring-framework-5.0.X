package com.ant.circulreference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: AntBean1
 * @Description: AntBean1
 * @datetime 2019/3/25 8:35
 * @Version 1.0
 */

@Component
public class AntBean1 {

	@Autowired
	private IndexService indexService;


	public void query() {
		System.out.println("antBean1 query");
	}

	public void test() {
		indexService.query();
	}

}
