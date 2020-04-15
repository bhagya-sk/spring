package com.reactiveworks.practice.dependencyinjection.collection.map;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApplication {
	private static final Logger LOGGER_OBJ=Logger.getLogger(StudentApplication.class);
	
	public static void main(String rgs[]) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("StudentMapContext2.xml");
		
		Student student1=context.getBean("student", Student.class);
		List<Subject> subjects = student1.getSubjects();
		LOGGER_OBJ.debug(student1);
		
		((ClassPathXmlApplicationContext)(context)).close();
	}

}
