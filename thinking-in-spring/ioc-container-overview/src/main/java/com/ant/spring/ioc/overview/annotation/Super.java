package com.ant.spring.ioc.overview.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author Ant gxstax@163.com
 * @since 2020-01-06 09:06
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Super {
}
