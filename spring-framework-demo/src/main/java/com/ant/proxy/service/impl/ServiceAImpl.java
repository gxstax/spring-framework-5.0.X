package com.ant.proxy.service.impl;

import com.ant.proxy.anno.SetMemberAndOrder;
import com.ant.proxy.service.ServiceA;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-10-22 09:39
 */
@Service
public class ServiceAImpl implements ServiceA {

	@Override
	@SetMemberAndOrder
	public String a() {
		return "A";
	}
}
