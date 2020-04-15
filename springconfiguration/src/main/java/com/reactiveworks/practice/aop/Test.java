package com.reactiveworks.practice.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ShapeServiceConfig.xml");
		ShapeService shapeServiceObj = context.getBean("shapeService",ShapeService.class);
        System.out.println(shapeServiceObj.getCircle().getName());
       // System.out.println(shapeServiceObj.getTriangle().getName());
        ((ClassPathXmlApplicationContext)(context)).close();
	}

}
