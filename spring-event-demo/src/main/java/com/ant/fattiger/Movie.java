package com.ant.fattiger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ant
 * @ClassName: Movie
 * @Description: TODO
 * @datetime 2019/1/8 8:40
 * @Version 1.0
 */
public class Movie implements Runnable{

	private List<MovieListener> movieListenerList = new ArrayList<>();

	public void addMovieListener(MovieListener movieListener) {
		movieListenerList.add(movieListener);
	}

	public void play() {
		try {
			System.out.println("开始播放电影");
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MovieEvent movieEvent = new MovieEvent();
		movieEvent.setType(2);
		movieEvent.setContext("only");

		for (MovieListener movie:movieListenerList) {
			movie.handleEvent(movieEvent);
		}
	}

	@Override
	public void run() {
		play();
	}

}
