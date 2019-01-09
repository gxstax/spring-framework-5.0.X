package com.ant.context.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ant
 * @ClassName: Test
 * @Description: TODO
 * @datetime 2019/1/7 8:35
 * @Version 1.0
 */
public class Test {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		set1.add("1");
		set2.add("1");
		set1.add("2");
		set2.add("2");
		ttest(set1, set2);
	}


	public static void ttest(Set<?> s1, Set<?> s2) {
		for (Object obj:s1) {
			if(s2.contains(obj)) {
				System.out.println(obj.toString());
			}
		}
	}
}
