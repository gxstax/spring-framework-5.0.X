package com.ant.circulreference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: IndexService
 * @Description: IndexService
 * @datetime 2019/3/25 8:34
 * @Version 1.0
 */

@Component("index")
public class IndexService {

	@Autowired
	private AntBean1 antBean1;



	public void query() {
		System.out.println("IndexService query");
	}

	public void test() {
		antBean1.query();
	}

}
