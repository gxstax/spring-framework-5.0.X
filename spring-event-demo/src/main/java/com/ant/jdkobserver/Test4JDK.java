package com.ant.jdkobserver;

/**
 * @author Ant
 * @ClassName: Test4JDK
 * @Description: JDK监听测试类
 * @datetime 2019/1/9 8:42
 * @Version 1.0
 */
public class Test4JDK {
	public static void main(String[] args) {
		Movie4JDK movie4JDK = new Movie4JDK();

		BigBear4JDK bear4JDK = new BigBear4JDK();
		FatTiger4JDK tiger4JDK = new FatTiger4JDK();

		// 把监听者添加进来，让他们能够接收到监听事件
		movie4JDK.addObserver(bear4JDK);
		movie4JDK.addObserver(tiger4JDK);

		// 如果有天你不想让胖虎接收监听事件，则在这里去掉即可
		movie4JDK.deleteObserver(tiger4JDK);

		movie4JDK.action();
	}
}
