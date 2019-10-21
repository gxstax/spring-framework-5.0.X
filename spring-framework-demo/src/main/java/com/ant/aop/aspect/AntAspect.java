package com.ant.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName AntAspect
 * @Description AntAspect
 * @Author Ant
 * @Date 2019-05-25 18:24
 * @Version 1.0
 **/

@Component
@Aspect
public class AntAspect {

	@Pointcut("execution(* com.ant.aop.dao..*.*(..))")
	public void pointCut () {

	}

//	@Before("pointCut()")
//	public void before () {
//		System.out.println("proxy before");
//	}
//
//	@After("pointCut()")
//	public void after() {
//		try {
//			System.out.println(1/0);
//		} catch (Exception e) {
//			System.out.println("prox wocao ");
//		}
//	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		System.out.println("proxy before");
		Object proceed = point.proceed();
		System.out.println(1/0);

		return proceed;
	}
}
