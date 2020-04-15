package com.reactiveworks.practice.configuration.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApplication {

	public static void main(String args[]) {
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		Employee employee = context.getBean("employee", Employee.class);
		System.out.println("employee " + employee);
		Address addr1=employee.getAddrs1();
		//addr1.setCity("kalaburagi");
		Address addr2=employee.getAddrs2();
		System.out.println("addr1==addr2: " +(addr1==addr2));
		System.out.println("addr1: "+ addr1);
		System.out.println("addr2: "+ addr2);
		((AnnotationConfigApplicationContext) context).close();
	}
}
