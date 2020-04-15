package com.reactiveworks.practice.dependencyinjection.factorymethod.nonstatic;

public class SubjectFactory {
	
	public static Subject getSubject() {
		return new Subject();
	}
}