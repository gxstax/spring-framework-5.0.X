package com.ant.fattiger;

/**
 * @author Ant
 * @ClassName: BigBear4JDK
 * @Description: 大熊类
 * @datetime 2019/1/9 8:19
 * @Version 1.0
 */
public class BigBear implements MovieListener{
	@Override
	public void handleEvent(MovieEvent me) {
		if(me.getType() == 1){
			System.out.println("bigBear cry");
		}
		if(me.getType() == 2){
			System.out.println("bigBear wc");
		}
	}
}
