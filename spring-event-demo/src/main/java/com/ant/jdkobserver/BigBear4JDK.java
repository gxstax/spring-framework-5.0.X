package com.ant.jdkobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Ant
 * @ClassName: BigBear4JDK
 * @Description: 监听者大雄
 * @datetime 2019/1/9 8:34
 * @Version 1.0
 */
public class BigBear4JDK implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("我大雄收到了监听事件");
	}
}
