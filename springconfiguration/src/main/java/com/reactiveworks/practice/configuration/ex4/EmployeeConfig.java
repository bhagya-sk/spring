package com.reactiveworks.practice.configuration.ex4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.reactiveworks.practice.configuration")
public class EmployeeConfig {
	
    public EmployeeConfig() {
    	System.out.println( "object of EmployeeConfig is created");
    }
    
    @Bean(name = "bean")   //name=" " to change the bean name
    public Address addressBean() {  //method name is the default bean name
    	return new Address();
    }
}
