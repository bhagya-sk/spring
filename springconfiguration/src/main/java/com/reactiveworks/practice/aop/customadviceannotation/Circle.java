package com.reactiveworks.practice.aop.customadviceannotation;

public class Circle {

	private String name;

	@Loggable
	public String getName() {
		System.out.println("inside getName() method. name is " + name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
