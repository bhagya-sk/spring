package com.reactiveworks.practice.aop.after;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	//this will be triggered only if the method execution is successful
	@AfterReturning(pointcut = "args(name) && execution( public String com.reactiveworks.practice.aop.after.Circle.*(..))", returning = "returnedValue")
	public void displayAdvice1(String name, String returnedValue) {
		System.out.println("method which takes string argument has been called. value is: " + name
				+ " returnedValue is: " + returnedValue);
	}

	//this will be triggered only if method throws exception 
	@AfterThrowing(pointcut = "execution( public void com.reactiveworks.practice.aop.after.Circle.setName(..))", throwing = "exp")
	public void adviceAfterThrowingException(JoinPoint joinPoint, Exception exp) {
		System.out.println(joinPoint.getSignature().getName() + " has thrown exception " + exp.getStackTrace());
	}

}