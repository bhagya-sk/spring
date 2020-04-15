package com.reactiveworks.practice.dependencyinjection;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeApplication {
	private static final Logger LOGGER_OBJ = Logger.getLogger(EmployeeApplication.class);

	public static void main(String args[]) {
         //singleton object will be injected
		// using ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeBeanConfiguration2.xml");
		Employee emp1 = (Employee) context.getBean("emp1");
//		Employee emp2 = (Employee) context.getBean("emp2");
//		Employee emp = (Employee) context.getBean("emp1");
//		LOGGER_OBJ.debug("emp1: " + emp1);
//		emp1.seteId(21);
		LOGGER_OBJ.debug("emp2" + emp1.getEname());
	//	LOGGER_OBJ.debug("singleton object? "+emp1.equals(emp));
		((ClassPathXmlApplicationContext) context).close();

	}
}
