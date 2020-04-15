package com.reactiveworks.practice.prototype;

public class Student {

	private int rNo;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [rNo=" + rNo + ", name=" + name + "]";
	}
	
	public void init() {
		System.out.println("inside init() method");
	}
	
	public void destroy() {
		System.out.println("inside destroy() method");
	}
	
	
}
