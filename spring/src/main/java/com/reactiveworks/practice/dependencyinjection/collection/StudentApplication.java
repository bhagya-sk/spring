package com.reactiveworks.practice.dependencyinjection.collection;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApplication {
	private static final Logger LOGGER_OBJ=Logger.getLogger(StudentApplication.class);
	
	public static void main(String rgs[]) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("StudentContext.xml");
		
		Student student1=context.getBean("student", Student.class);
		//Student student2=context.getBean("student", Student.class);
		LOGGER_OBJ.debug(student1);
		
		((ClassPathXmlApplicationContext)(context)).close();
	}

}
