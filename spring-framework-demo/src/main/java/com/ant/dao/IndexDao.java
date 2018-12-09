package com.ant.dao;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

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
