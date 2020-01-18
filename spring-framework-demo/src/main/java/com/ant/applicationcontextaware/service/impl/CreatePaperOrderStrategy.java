package com.ant.applicationcontextaware.service.impl;

import com.ant.applicationcontextaware.mapper.TestMapper;
import com.ant.applicationcontextaware.service.CreateOrderStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-08-28 15:39
 */
@Component
public class CreatePaperOrderStrategy implements CreateOrderStrategy {

	@Autowired
	private TestMapper testMapper;

	@Override
	@Transactional
	public void createOrder() {
		testMapper.test();
		System.out.println("createOrder。。。。。。。。。。。");
	}
}
