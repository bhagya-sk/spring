package com.reactiveworks.practice.dependencyinjection.collection.map;

import java.util.List;

public class Student {

	private String name;
	private int rNo;
	private List<Subject> subjects;

	public Student(String name, int rNo, List<Subject> subjects) {
		super();
		this.name = name;
		this.rNo = rNo;
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rNo=" + rNo + ", subjects=" + subjects + "]";
	}

}
