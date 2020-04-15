package com.reactiveworks.practice.aop.xmlconfiguration;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	private static final Logger LOGGER_OBJ = Logger.getLogger(LoggingAspect.class);

	public void logBefore(JoinPoint joinPoint) {
		LOGGER_OBJ.debug("execution of " + joinPoint.getSignature().getName() + "() started");

	}

	public void logAfter(JoinPoint joinPoint) {
		LOGGER_OBJ.debug("execution of " + joinPoint.getSignature().getName() + "() completed");

	}

	public void myadvice(ProceedingJoinPoint pjp) throws Throwable {
		logBefore(pjp);
		pjp.proceed();
		logAfter(pjp);

	}

	public void methodCompletion(JoinPoint joinPoint) {
		LOGGER_OBJ.debug("execution of " + joinPoint.getSignature().getName() + "() completed successfully");
	}
	
	public void exceptionThrown(JoinPoint joinPoint) {
		LOGGER_OBJ.debug(joinPoint.getSignature().getName() + "() has thrown exception ");
	}
}