package com.ant.context.loopdepends;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName Depend1
 * @Description Depend1
 * @Author Ant
 * @Date 2019-05-26 18:43
 * @Version 1.0
 **/

@Component
public class Depend1 {

	@Autowired
	private Depend2 depend2;

	public void call () {
		depend2.print();
	}

	public void print () {
		System.out.println("this is depend1");
	}
}
