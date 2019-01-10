package com.ant.springevent;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author Ant
 * @ClassName: SpringFilmWatchEvent
 * @Description: 定义自己的事件
 * @datetime 2019/1/9 10:52
 * @Version 1.0
 */
public class SpringFilmWatchEvent extends ApplicationEvent {

	private String content;

	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public SpringFilmWatchEvent(Object source) {
		super(source);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
