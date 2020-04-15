package com.reactiveworks.practice.configuration.ex3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.reactiveworks.practice.configuration.ex3")
@PropertySource("classpath:employee-info.properties")
public class EmployeeConfig {

}