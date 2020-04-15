package com.reactiveworks.practice.autowiring.bytype;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeApplication {
	private static final Logger LOGGER_OBJ = Logger.getLogger(EmployeeApplication.class);

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeBeanConfiguration8.xml");
		Employee emp1 = context.getBean("emp", Employee.class);
		LOGGER_OBJ.debug("emp1 " + emp1);
		((ClassPathXmlApplicationContext) context).close();

	}
}
