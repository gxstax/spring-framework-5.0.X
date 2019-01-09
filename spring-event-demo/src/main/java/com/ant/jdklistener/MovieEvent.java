package com.ant.jdklistener;

import java.util.EventObject;

/**
 * @author Ant
 * @ClassName: MovieEvent
 * @Description: 自定义事件
 * @datetime 2019/1/8 17:07
 * @Version 1.0
 */
public class MovieEvent extends EventObject {

	private Object sourceObj;
	private String sourceName;
	/**
	 * Constructs a prototypical Event.
	 *
	 * @param source The object on which the Event initially occurred.
	 * @throws IllegalArgumentException if source is null.
	 */
	public MovieEvent(Object source,String sourceName) {
		super(source);
		this.sourceObj = source;
		this.sourceName = sourceName;
	}

	public Object getSourceObj() {
		return sourceObj;
	}

	public void setSourceObj(Object sourceObj) {
		this.sourceObj = sourceObj;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
}
