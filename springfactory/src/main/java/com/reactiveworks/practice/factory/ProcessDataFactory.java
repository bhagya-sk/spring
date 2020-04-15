package com.reactiveworks.practice.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.reactiveworks.practice.interfaces.IProcessData;
import com.reactiveworks.practice.interfaces.implementation.MultiplyImpl;
import com.reactiveworks.practice.interfaces.implementation.SubtractImpl;
import com.reactiveworks.practice.interfaces.implementation.SumImpl;

@Component
@PropertySource("file:C:\\Users\\reactiveworks13\\Desktop\\processConfig.properties")
public class ProcessDataFactory implements EnvironmentAware {
//classpath:processConfig.properties
	private Environment environment;
	@Autowired
	private SumImpl sumImpl;
	@Autowired
	private SubtractImpl subtractImpl;
	@Autowired
	private MultiplyImpl multiplyImpl;

	public void setEnvironment(final Environment environment) {
		this.environment = environment;
	}

	public IProcessData getInstance() {
		System.out.println(environment.getProperty("process"));
		if (environment.getProperty("process").equalsIgnoreCase("add")) {
			return sumImpl;

		} else if (environment.getProperty("process").equalsIgnoreCase("sub")) {
			return subtractImpl;

		} else {
			return multiplyImpl;

		}

	}

}