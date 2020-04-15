package com.reactiveworks.practice.configuration.xmlandannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeApplication {

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("employeeConfig.xml");
		Employee emp1 = (Employee) context.getBean("emp");
		System.out.println("emp1 " + emp1);
		((ClassPathXmlApplicationContext) (context)).close();

	}
}
