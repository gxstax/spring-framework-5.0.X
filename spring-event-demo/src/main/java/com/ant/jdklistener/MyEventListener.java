package com.ant.jdklistener;

import java.util.EventListener;

/**
 * @author Ant
 * @ClassName: MyEventListener
 * @Description: 自定义事件监听接口
 * @datetime 2019/1/8 17:08
 * @Version 1.0
 */
public interface MyEventListener extends EventListener {
	void handleEvent (MovieEvent me);
}
