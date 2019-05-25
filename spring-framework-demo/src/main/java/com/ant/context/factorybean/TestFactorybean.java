package com.ant.context.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestFactorybean
 * @Description TestFactorybean
 * @Author Ant
 * @Date 2019-05-23 19:20
 * @Version 1.0
 **/

@Component("testFactoryBean")
public class TestFactorybean implements FactoryBean {

	public void testBean () {
		System.out.println("testBean");
	}

	@Override
	public Object getObject() throws Exception {
		return new TempFactoryBean();
	}

	@Override
	public Class<?> getObjectType() {
		return TempFactoryBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
