package com.ant.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Ant
 * @ClassName: SpringFilmWatchListener
 * @Description: TODO
 * @datetime 2019/1/10 8:23
 * @Version 1.0
 */
@Component
public class SpringFilmWatchListener implements ApplicationListener<SpringFilmWatchEvent> {
	@Override
	public void onApplicationEvent(SpringFilmWatchEvent event) {
		System.out.println("filmWatch");
	}
}
