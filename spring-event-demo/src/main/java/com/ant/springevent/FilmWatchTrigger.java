package com.ant.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Ant
 * @ClassName: FilmWatchTrigger
 * @Description: 看电影事件触发
 * @datetime 2019/1/10 8:36
 * @Version 1.0
 */
@Component
public class FilmWatchTrigger {

	@Autowired
	private ApplicationContext applicationContext;

	public void filmWatch() {
		applicationContext.publishEvent(new SpringFilmWatchEvent(applicationContext));
	}
}
