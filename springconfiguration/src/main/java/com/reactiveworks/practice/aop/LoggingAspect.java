package com.reactiveworks.practice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("execution( public String com.reactiveworks.practice.aop.Circle.getName())")
	public void displayAdvice(JoinPoint joinPoint) {
		System.out.println("aspect advice run by " + joinPoint);	
	}
	
	@Before("allMethods()")
	public void displayAdvice2(JoinPoint joinPoint) {
		System.out.println("aspect advice2 run by "+joinPoint);
	}
	
	@Pointcut("within(com.reactiveworks.practice.aop.*)")
	public void allMethods() {
		System.out.println("within allMethods()");
	}

}
