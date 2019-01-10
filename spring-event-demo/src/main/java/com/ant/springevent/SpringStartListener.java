package com.ant.springevent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Ant
 * @ClassName: SpringStartListener
 * @Description: Spring事件的监听器
 * @datetime 2019/1/9 9:33
 * @Version 1.0
 */
@Component
public class SpringStartListener implements ApplicationListener<ContextStoppedEvent> {

	@Override
	public void onApplicationEvent(ContextStoppedEvent event) {
		System.out.println("spring start listener");
	}
}
