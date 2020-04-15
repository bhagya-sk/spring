package com.reactiveworks.practice.dependencyinjection.collection;

public class Subject {

	private String subName;
	private int maxMarks;
	private int marks;

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Subject [subName=" + subName + ", maxMarks=" + maxMarks + ", marks=" + marks + "]";
	}

}
