package com.reactiveworks.practice.dependencyinjection.collection.map;

import java.util.Map;

public class Subject {

	private String subName;
	private int maxMarks;
	private Map<String, String> marks;

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

	public Map<String, String> getMarks() {
		return marks;
	}

	public void setMarks(Map<String, String> marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Subject [subName=" + subName + ", maxMarks=" + maxMarks + ", marks=" + marks + "]";
	}

}
