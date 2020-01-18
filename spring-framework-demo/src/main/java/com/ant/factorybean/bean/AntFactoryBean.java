package com.ant.factorybean.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-10-21 08:25
 */
@Component
public class AntFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return new Ant();
	}

	@Override
	public Class<?> getObjectType() {
		return Ant.class;
	}
}
