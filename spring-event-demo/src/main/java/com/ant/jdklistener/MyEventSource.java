package com.ant.jdklistener;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author Ant
 * @ClassName: MyEventSource
 * @Description: 自定义事件源
 * @datetime 2019/1/8 17:59
 * @Version 1.0
 */
public class MyEventSource {

	private Vector list = new Vector();

	private String sName  = "";

	public MyEventSource() {
		super();
	}

	public void notifyMyEvent(MovieEvent me) {
		Iterator it = list.iterator();
		while (it.hasNext()) {
			//在类中实例化自定义的监听器对象,并调用监听器方法
			((MyEventListener) it.next()).handleEvent(me);
		}
	}

	public void addMyEventListener(MyEventListener me) {
		list.add(me);
	}

	public void deleteMyEventListener(MyEventListener me) {
		list.remove(me);
	}

	public Vector getList() {
		return list;
	}

	public void setList(Vector list) {
		this.list = list;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		if(sName != ""){
			this.sName = sName;
			notifyMyEvent(new MovieEvent(this, sName));
		}
	}
}
