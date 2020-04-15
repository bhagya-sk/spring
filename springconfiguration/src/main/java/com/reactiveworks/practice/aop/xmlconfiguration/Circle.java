package com.reactiveworks.practice.aop.xmlconfiguration;

public class Circle {

	private String name;

	public String getName(){
		System.out.println("inside circle's getName()");
		
		return name;
	}

	public void setName(String name) throws Exception {
		System.out.println("inside circle's setName()");
		//throw new Exception();
		this.name = name;
	}

}
