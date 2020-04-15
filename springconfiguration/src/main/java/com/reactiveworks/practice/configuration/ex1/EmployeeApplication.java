package com.reactiveworks.practice.configuration.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApplication {

	public static void main(String args[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		Employee emp1 = (Employee) context.getBean("employeeBean");
		System.out.println("emp1 " + emp1);
		((AnnotationConfigApplicationContext) context).close();

	}
}
