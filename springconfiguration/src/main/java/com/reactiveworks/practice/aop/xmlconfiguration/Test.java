package com.reactiveworks.practice.aop.xmlconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("AopXmlConfiguration.xml");
		ShapeService shapeServiceObj = context.getBean("shapeService", ShapeService.class);
		shapeServiceObj.getCircle().getName();
		shapeServiceObj.getCircle().setName("new circle name");
		// System.out.println(shapeServiceObj.getTriangle().getName());
		((ClassPathXmlApplicationContext) (context)).close();
	}

}
