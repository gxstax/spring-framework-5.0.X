package com.ant.importselector.dao;

import com.ant.importselector.anno.AntAuto;
import org.springframework.stereotype.Component;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: UserDao
 * @Description: UserDao
 * @datetime 2019/3/18 9:23
 * @Version 1.0
 */
@Component("aaa")
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

	@AntAuto
	public void setName(String name) {
		this.name = name;
	}

}
