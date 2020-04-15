package com.reactiveworks.practice.aop.customadviceannotation.ex2;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	private static final Logger LOGGER_OBJ = Logger.getLogger(LoggingAspect.class);

	public void logBefore(JoinPoint joinPoint) {
		LOGGER_OBJ.debug(joinPoint.getSignature().getName()+"() started it's execution");
	}

	public void logAfter(JoinPoint joinPoint) {
		LOGGER_OBJ.debug(joinPoint.getSignature().getName()+"() completed it's execution");
	}
	
	public void log(ProceedingJoinPoint joinPoint) throws Throwable {
		logBefore(joinPoint);
		joinPoint.proceed();
		logAfter(joinPoint);
	}

}
