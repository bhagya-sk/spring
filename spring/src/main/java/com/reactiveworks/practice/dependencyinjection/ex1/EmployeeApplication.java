package com.reactiveworks.practice.dependencyinjection.ex1;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeApplication {
	private static final Logger LOGGER_OBJ = Logger.getLogger(EmployeeApplication.class);

	public static void main(String args[]) {
     //primitive type dependency injection
		
		// using ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeBeanConfiguration4.xml");
		Employee emp1 = (Employee) context.getBean("emp1");
		Employee emp2= context.getBean("emp2", Employee.class);
		LOGGER_OBJ.debug("emp1: " + emp1);
		LOGGER_OBJ.debug("emp2: " + emp2);
		((ClassPathXmlApplicationContext) context).close();

	}
}
