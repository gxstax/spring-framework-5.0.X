package com.ant.context.test.enhancer;

import com.ant.context.dao.IndexDao;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: EnhancerTest
 * @Description: TODO
 * @datetime 2018/12/9 13:48
 * @Version 1.0
 */
public class EnhancerTest {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		//增强父类，地球人都知道cglib是基于继承来的
		enhancer.setSuperclass(IndexDao.class);

		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);

		enhancer.setCallback(new MyCallback());
		IndexDao indexDao = (IndexDao) enhancer.create();
		indexDao.query();
	}
}
