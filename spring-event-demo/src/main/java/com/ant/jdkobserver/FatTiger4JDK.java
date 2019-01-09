package com.ant.jdkobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Ant
 * @ClassName: FatTiger4JDK
 * @Description: 监听者胖虎
 * @datetime 2019/1/9 8:35
 * @Version 1.0
 */
public class FatTiger4JDK implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("我胖虎收到了监听事件");
	}
}
