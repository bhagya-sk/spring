package com.reactiveworks.practice.dependencyinjection.factorymethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		 ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");  
		    FactoryMethodDI a=(FactoryMethodDI)context.getBean("a");  
		    a.msg();  
	}

}
