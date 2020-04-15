package com.reactiveworks.practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.reactiveworks.practice.factory.ProcessDataFactory;
import com.reactiveworks.practice.interfaces.IProcessData;

@Component
@ComponentScan(basePackages = "com.reactiveworks.practice.*")
public class ProcessConfig {
	@Autowired
	ProcessDataFactory processDataFactory;
	
	@Bean("processData")
	public IProcessData processDataBean() {
		return processDataFactory.getInstance();
	}

}