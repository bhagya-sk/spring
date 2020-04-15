package com.reactiveworks.practice.innerbean;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; class EmployeeApplication {
	private static final Logger LOGGER_OBJ = Logger.getLogger(EmployeeApplication.class);

	public static void main(String args[]) {
         //singleton object will be injected
		// using ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeBeanConfiguration10.xml");
		Employee emp1 = (Employee) context.getBean("emp1");
		Employee emp2 = (Employee) context.getBean("emp2");
		LOGGER_OBJ.debug("emp1: " + emp1);
		LOGGER_OBJ.debug("emp1: " + emp2);
		
		
		((ClassPathXmlApplicationContext) context).close();

	}
}
