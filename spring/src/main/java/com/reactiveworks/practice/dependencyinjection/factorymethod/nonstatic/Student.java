package com.reactiveworks.practice.dependencyinjection.factorymethod.nonstatic;

public class Student {

	private String name;
	private int rollNo;
	private Subject sub;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", subject=" + sub + "]";
	}

}
