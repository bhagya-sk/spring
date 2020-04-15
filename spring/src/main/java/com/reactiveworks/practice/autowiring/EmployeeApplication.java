package com.reactiveworks.practice.autowiring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeApplication {
	private static final Logger LOGGER_OBJ = LoggerFactory.getLogger(EmployeeApplication.class);

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeBeanConfiguration7.xml");
		Employee emp1 = (Employee) context.getBean("emp1");
		//Employee emp2 = (Employee) context.getBean("emp2");
		LOGGER_OBJ.debug("emp1 "+emp1);
		//LOGGER_OBJ.debug("emp2 "+emp2);
		((ClassPathXmlApplicationContext) context).close();

	}
}
