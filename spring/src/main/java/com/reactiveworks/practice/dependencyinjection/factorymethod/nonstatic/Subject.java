package com.reactiveworks.practice.dependencyinjection.factorymethod.nonstatic;

public class Subject {

	private String subName;
	private int maxMarks;
	private int marksObtained;

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

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	@Override
	public String toString() {
		return "Subject [subName=" + subName + ", maxMarks=" + maxMarks + ", marksObtained=" + marksObtained + "]";
	}

}
