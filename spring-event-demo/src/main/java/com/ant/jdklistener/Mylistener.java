package com.ant.jdklistener;

import java.util.Map;

/**
 * @author Ant
 * @ClassName: Mylistener
 * @Description: TODO
 * @datetime 2019/1/8 18:03
 * @Version 1.0
 */
public class Mylistener implements MyEventListener{

	private MyEventSource myEventSource;
	private String name;

	private int i = 0 ;

	public Mylistener(Map<Integer, String> map){
		MyEventSource myEventSource = new MyEventSource();
		myEventSource.addMyEventListener(this);
		myEventSource.setsName("ant");

	}

	@Override
	public void handleEvent(MovieEvent me) {
		System.out.println(me.getSourceObj());
		System.out.println(me.getSourceName());
	}

}
