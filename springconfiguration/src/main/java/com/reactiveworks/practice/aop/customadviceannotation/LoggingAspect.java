package com.reactiveworks.practice.aop.customadviceannotation;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	private static final Logger LOGGER_OBJ = Logger.getLogger(LoggingAspect.class);

	@Around("@annotation(com.reactiveworks.practice.aop.customadviceannotation.Loggable)")
	public void displayAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER_OBJ.debug(joinPoint.getSignature().getName() + "() is executing");
		joinPoint.proceed();
		LOGGER_OBJ.debug(joinPoint.getSignature().getName() + "() has completed it's execution");

	}

}