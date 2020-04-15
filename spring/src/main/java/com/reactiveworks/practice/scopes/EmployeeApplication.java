package com.reactiveworks.practice.scopes;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeApplication {
	private static final Logger LOGGER_OBJ = Logger.getLogger(EmployeeApplication.class);

	public static void main(String args[]) {

		// using ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeBeanConfiguration3.xml");
		Employee emp1 = (Employee) context.getBean("emp1");
		emp1.seteId(40);
		// Employee emp2=(Employee) context.getBean("emp2");
		Employee emp = (Employee) context.getBean("emp1");
 //	  LOGGER_OBJ.debug("emp1: "+emp1);
//	  LOGGER_OBJ.debug("emp "+emp);

		LOGGER_OBJ.debug("singleton obj? " + emp.equals(emp1));

	}
}