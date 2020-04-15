package com.reactiveworks.practice.configuration.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApplication {

	public static void main(String args[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		Address addrBean = context.getBean("bean", Address.class);
		System.out.println("address " + addrBean);
		((AnnotationConfigApplicationContext) context).close();
	}
}
