package com.ant.fattiger;

/**
 * @author Ant
 * @ClassName: EventTest
 * @Description: TODO
 * @datetime 2019/1/8 8:46
 * @Version 1.0
 */
public class EventTest {
	public static void main(String[] args) {
		Movie movie = new Movie();
		BigBear bigBear = new BigBear();
		FatTiger fatTiger = new FatTiger();
		movie.addMovieListener(bigBear);
		movie.addMovieListener(fatTiger);
		Thread thread = new Thread(movie);
		thread.start();
	}
}
