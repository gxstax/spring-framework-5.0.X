package com.ant.fattiger;

/**
 * @author Ant
 * @ClassName: FatTiger4JDK
 * @Description: 胖虎类
 * @datetime 2019/1/8 8:46
 * @Version 1.0
 */
public class FatTiger implements MovieListener{

	@Override
	public void handleEvent(MovieEvent me) {
		if(me.getType() == 1){
			System.out.println("fattiger wc");
		}
		if(me.getType() == 2){
			System.out.println("fattiger cry");
		}
	}
}
