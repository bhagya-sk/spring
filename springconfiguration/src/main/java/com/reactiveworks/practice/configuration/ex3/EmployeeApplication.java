package com.reactiveworks.practice.configuration.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class EmployeeApplication {

	public static void main(String args[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		Employee emp1 =  context.getBean("emp", Employee.class);
		System.out.println("emp1 " + emp1);
		((AnnotationConfigApplicationContext) context).close();
	}
}
