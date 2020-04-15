package com.reactiveworks.accountservice.service.implementation;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.reactiveworks.accountservice.dao.IAccountDao;
import com.reactiveworks.accountservice.service.IAccountService;

public class AccountService implements IAccountService {

	private IAccountDao accountDao;
	private TransactionTemplate transactionTemplate;

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public IAccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(long fromAccount, long toAccount, double amount) {

		transactionTemplate.execute(new TransactionCallback<Void>() {

			@Override
			public Void doInTransaction(TransactionStatus status) {
				accountDao.withdraw(fromAccount, amount);
				accountDao.deposit(toAccount, amount);
				return null;
			}
		});

		System.out.println(amount + " is transfered from " + fromAccount + " to " + toAccount);

	}

	// without using transaction management.
//	@Override
//	public void transfer(long fromAccount, long toAccount, double amount) {
//
//		accountDao.withdraw(fromAccount, amount);
//		accountDao.deposit(toAccount, amount);
//
//		System.out.println(amount + " is transfered from " + fromAccount + " to " + toAccount);
//
//	}

}
