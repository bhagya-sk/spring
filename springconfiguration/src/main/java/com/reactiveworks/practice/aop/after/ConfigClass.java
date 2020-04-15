package com.reactiveworks.practice.aop.after;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.reactiveworks.practice.aop.after")
@EnableAspectJAutoProxy
public class ConfigClass {

}
