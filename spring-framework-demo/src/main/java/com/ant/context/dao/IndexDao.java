package com.ant.context.dao;

import org.springframework.stereotype.Component;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: IndexDao
 * @Description: TODO
 * @datetime 2018/11/17 16:25
 * @Version 1.0
 */
@Component
public class IndexDao implements Dao{

	@Override
	public void query () {
		System.out.println("indexDao");
	}
}
