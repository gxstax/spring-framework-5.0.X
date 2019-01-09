package com.ant.jdklistener;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ant
 * @ClassName: Test
 * @Description: TODO
 * @datetime 2019/1/8 18:52
 * @Version 1.0
 */
public class Test {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Mylistener mylistener = new Mylistener(map);
	}
}
