package com.reactiveworks.annotationbasedconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.reactiveworks.annotationbasedconfig.configuration.EmployeeConfig;
import com.reactiveworks.annotationbasedconfig.dao.implementation.EmployeeDaoImpl;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeDaoImpl employeeDaoImpl = context.getBean("employeeDaoImpl", EmployeeDaoImpl.class);
		System.out.println(employeeDaoImpl.getEmployees());
		context.close();
	}

}
