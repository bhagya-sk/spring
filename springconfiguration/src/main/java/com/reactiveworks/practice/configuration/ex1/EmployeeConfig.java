package com.reactiveworks.practice.configuration.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
	
	@Bean(name = "addr1")
	public Address addressBean() {
		
		Address address= new Address(); 
		address.setCity("bengaluru");
		address.setPincode("560040");
		address.setState("karnataka");
		return address; 
	}
	
	@Bean
	public Address addressBean1() {
		
		Address address= new Address(); 
		address.setCity("mysuru");
		address.setPincode("560000");
		address.setState("karnataka");
		return address; 
	}
	
	@Bean
	public Employee employeeBean() {
		Employee employeeObj=new Employee(addressBean() );
		employeeObj.seteId(10);
		employeeObj.setEname("emp1");
		employeeObj.setSalary(10000);
		return employeeObj;
	}

}
