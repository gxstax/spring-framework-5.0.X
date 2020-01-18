package com.ant.proxy.service.impl;

import com.ant.proxy.anno.SetMemberAndOrder;
import com.ant.proxy.service.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-10-22 09:40
 */
@Service
public class ServiceBImpl implements com.ant.proxy.service.ServiceB {

	@Autowired
	private ServiceA serviceA;

	@Override
	@SetMemberAndOrder
	public void b() {
		System.out.println("b");
	}
}
