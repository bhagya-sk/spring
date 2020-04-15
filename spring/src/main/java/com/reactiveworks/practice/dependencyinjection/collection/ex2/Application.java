package com.reactiveworks.practice.dependencyinjection.collection.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
	
		ApplicationContext context=new ClassPathXmlApplicationContext("QuestionContext.xml");
		Question question=context.getBean("q",Question.class);
		question.displayInfo();
	}

}
