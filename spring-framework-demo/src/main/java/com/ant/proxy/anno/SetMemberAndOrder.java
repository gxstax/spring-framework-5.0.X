package com.ant.proxy.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-10-22 08:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SetMemberAndOrder {

}
