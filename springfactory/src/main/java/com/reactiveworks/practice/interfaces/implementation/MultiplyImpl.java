package com.reactiveworks.practice.interfaces.implementation;

import org.springframework.stereotype.Component;

import com.reactiveworks.practice.interfaces.IProcessData;

@Component
public class MultiplyImpl implements IProcessData {

	@Override
	public void processData(int a, int b) {
		
		System.out.println("a*b= " + a * b);

	}

}
