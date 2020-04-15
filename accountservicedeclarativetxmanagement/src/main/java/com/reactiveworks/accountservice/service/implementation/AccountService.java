package com.reactiveworks.accountservice.service.implementation;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reactiveworks.accountservice.dao.IAccountDao;
import com.reactiveworks.accountservice.service.IAccountService;

public class AccountService implements IAccountService {

	private IAccountDao accountDao;
//	private TransactionTemplate transactionTemplate;
//
//	public TransactionTemplate getTransactionTemplate() {
//		return transactionTemplate;
//	}
//
//	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
//		this.transactionTemplate = transactionTemplate;
//	}

	public IAccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,readOnly = false)
	public void transfer(long fromAccount, long toAccount, double amount) {

		
				accountDao.withdraw(fromAccount, amount);
				accountDao.deposit(toAccount, amount);
			
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
