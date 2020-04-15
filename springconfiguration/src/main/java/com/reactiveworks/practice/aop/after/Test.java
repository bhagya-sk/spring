package com.reactiveworks.practice.aop.after;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(ShapeService.class);
		ShapeService shapeServiceObj = context.getBean("shapeService", ShapeService.class);
	//	shapeServiceObj.getCircle().setName("new circle");
		//shapeServiceObj.getTriangle().setName("new triangle");
		shapeServiceObj.getCircle().setNameAndReturn("circle");
		((AnnotationConfigApplicationContext) (context)).close();
	}

}
