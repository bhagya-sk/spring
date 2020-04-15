package com.reactiveworks.accountservice.dao;

import java.util.List;

import com.reactiveworks.accountservice.dao.model.Account;

public interface IAccountDao {

	public List<Account> getAccountUser();

	public void deposit(long toAccountNo, double amount);

	public void withdraw(long fromAccountNo, double amount);

	public Account getAcccountDetails(long accountNo);

}
