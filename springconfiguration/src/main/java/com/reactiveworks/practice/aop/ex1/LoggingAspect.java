package com.reactiveworks.practice.aop.ex1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	//it will be triggered when getNme() of circle class will be called
	@Before("execution( public String com.reactiveworks.practice.aop.ex1.Circle.getName())")
	public void displayAdvice(JoinPoint joinPoint) {
		System.out.println("aspect advice run by " + joinPoint);

	}

	// it will be triggered when method with string argument will be called
	@Before("args(name)")
	public void displayAdvice3(String name) {
		System.out.println("method which takes string argument has been called. value is: " + name);

	}

	@Before("allMethods()")
	public void displayAdvice2(JoinPoint joinPoint) {
		System.out.println("aspect advice2 run by " + joinPoint);

	}

	@Before("allMethods()")
	public void displayAdvice3(JoinPoint joinPoint) {
		System.out.println("aspect advice3 run by " + joinPoint);
	}

	// we need to use pointcut when we have to apply multiple advises on the same
	// method
	@Pointcut("within(com.reactiveworks.practice.aop.ex1.*)")
	public void allMethods() {
		System.out.println("within allMethods()");
	}

}
