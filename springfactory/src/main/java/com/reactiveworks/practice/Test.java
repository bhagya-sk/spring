package com.reactiveworks.practice;

import java.io.InputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.reactiveworks.practice.config.ProcessConfig;
import com.reactiveworks.practice.interfaces.IProcessData;

public class Test {

	public static void main(String[] args) {
		//System.out.println(Test.class.getClassLoader().getResource("processConfig.properties").getFile());
		ApplicationContext context = new AnnotationConfigApplicationContext(ProcessConfig.class);
		IProcessData processData = (IProcessData) context.getBean("processData");

		processData.processData(2, 3);
		((AnnotationConfigApplicationContext) (context)).close();
	}

}
