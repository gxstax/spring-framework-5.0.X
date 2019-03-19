package com.ant.importselector.dao;

import org.springframework.stereotype.Component;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: UserDao
 * @Description: UserDao
 * @datetime 2019/3/18 9:23
 * @Version 1.0
 */
@Component
public class UserDao {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
