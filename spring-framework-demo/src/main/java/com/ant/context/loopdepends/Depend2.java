package com.ant.context.loopdepends;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName Depend2
 * @Description Depend2
 * @Author Ant
 * @Date 2019-05-26 18:43
 * @Version 1.0
 **/
@Component
public class Depend2 {
	@Autowired
	private Depend1 depend1;

	public void call () {
		depend1.print();
	}

	public void print() {
		System.out.println("this is Depend2");
	}
}
