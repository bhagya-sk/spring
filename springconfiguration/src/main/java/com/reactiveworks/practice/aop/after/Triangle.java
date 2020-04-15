package com.reactiveworks.practice.aop.after;

import org.springframework.stereotype.Component;

@Component
public class Triangle {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
