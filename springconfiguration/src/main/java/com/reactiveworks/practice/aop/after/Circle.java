package com.reactiveworks.practice.aop.after;

import org.springframework.stereotype.Component;

@Component
public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name)  {
		this.name = name;
	//	throw new Exception();
		System.out.println("circle name is set to: "+ name);
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("value of circle name is set to: "+ name);

		return name;
	}

}
