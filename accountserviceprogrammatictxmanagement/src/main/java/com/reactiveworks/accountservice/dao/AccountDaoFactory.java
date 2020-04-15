package com.reactiveworks.accountservice.dao;

import com.reactiveworks.accountservice.dao.implementation.AccountDaoImpl;

public class AccountDaoFactory {

	private static AccountDaoImpl accountDaoImpl;

	public AccountDaoImpl getAccountDaoImpl() {
		return accountDaoImpl;
	}

	public void setAccountDaoImpl(AccountDaoImpl accountDaoImpl) {
		AccountDaoFactory.accountDaoImpl = accountDaoImpl;
	}

	public static IAccountDao getInstance() {

		return accountDaoImpl;
	}

}
