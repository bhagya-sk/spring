package com.reactiveworks.accountservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.reactiveworks.accountservice.configuration.AccountConfiguration;
import com.reactiveworks.accountservice.service.implementation.AccountService;

public class Test {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(AccountConfiguration.class);
		AccountService accountService = context.getBean("accountService", AccountService.class);
		accountService.transfer(123456, 654321, 1000);
		((AnnotationConfigApplicationContext) (context)).close();

	}

}
