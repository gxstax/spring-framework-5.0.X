package com.ant.context.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ant
 * @ClassName: Ant
 * @Description: TODO
 * @datetime 2018/12/31 10:28
 * @Version 1.0
 */

@Component("ant")
public class Ant {

	@Autowired
	private UserService userService;
}
