package com.reactiveworks.practice.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrototypeDemo {
	
	public static void main(String args[]) {
		ApplicationContext context=new ClassPathXmlApplicationContext("StudentConfig.xml");
		Student student=context.getBean("student",Student.class);
		System.out.println(student);
		((ClassPathXmlApplicationContext)(context)).close();
		System.out.println(student);
	}

}
