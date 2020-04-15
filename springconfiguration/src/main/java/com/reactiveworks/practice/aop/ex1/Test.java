package com.reactiveworks.practice.aop.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ShapeServiceConfig1.xml");
		ShapeService shapeServiceObj = context.getBean("shapeService", ShapeService.class);
		//System.out.println(shapeServiceObj.getCircle().getName());
		shapeServiceObj.getCircle().setName("new circle");
		((ClassPathXmlApplicationContext) (context)).close();
	}

}
