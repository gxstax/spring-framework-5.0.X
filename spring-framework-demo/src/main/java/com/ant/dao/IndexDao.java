package com.ant.dao;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: IndexDao
 * @Description: TODO
 * @datetime 2018/11/17 16:25
 * @Version 1.0
 */
@Repository
//	@Description("indexDao")
public class IndexDao {

	public IndexDao(){
		System.out.println("构造");
	}

	@PostConstruct
	public void init() {
		System.out.println("init......");
	}

	public void query () {
		System.out.println("indexDao");
	}
}
