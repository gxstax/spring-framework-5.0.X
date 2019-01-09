package com.ant.jdkobserver;

import java.util.Observable;

/**
 * @author Ant
 * @ClassName: Movie4JDK
 * @Description: 被监听者电影
 * @datetime 2019/1/9 8:38
 * @Version 1.0
 */
public class Movie4JDK extends Observable {

	/**
	 * 动作执行
	 */
	public void action(){
		// 在这里我们可以灵活控制监听事件的执行
		// 如果有一天，你不要这个监听事件，我不想让别人响应这个事件
		// 只要把下面这行去掉即可
		setChanged();
		notifyObservers();
	}
}
