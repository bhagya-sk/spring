package com.reactiveworks.practice.aop.customadviceannotation.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeApplication {
	// private static final Logger LOGGER_OBJ =
	// Logger.getLogger(EmployeeApplication.class);

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AopEmployeeConfiguration.xml");
		Employee emp1 = (Employee) context.getBean("employee");
		emp1.getEname();
		((ClassPathXmlApplicationContext) context).close();

	}
}