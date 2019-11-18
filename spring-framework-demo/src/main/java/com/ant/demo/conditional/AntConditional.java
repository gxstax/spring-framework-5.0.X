package com.ant.demo.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-11-14 15:55
 */
public class AntConditional implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");

		//包含Windows则说明是windows系统，返回true
		if (property.contains("Mac")){
			return true;
		}
		return false;

	}
}
