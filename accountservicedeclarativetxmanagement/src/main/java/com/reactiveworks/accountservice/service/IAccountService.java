package com.reactiveworks.accountservice.service;

public interface IAccountService {
	
	public void transfer(long fromAccount, long toAccount,double amount);

}
