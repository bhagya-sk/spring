package com.reactiveworks.accountservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reactiveworks.accountservice.dao.IAccountDao;
import com.reactiveworks.accountservice.service.IAccountService;

@Component
public class AccountService implements IAccountService {

	@Autowired
	private IAccountDao accountDao;

//	public IAccountDao getAccountDao() {
//		return accountDao;
//	}
//	
//	public void setAccountDao(IAccountDao accountDao) {
//		this.accountDao = accountDao;
//	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void transfer(long fromAccount, long toAccount, double amount) {

		accountDao.withdraw(fromAccount, amount);
		accountDao.deposit(toAccount, amount);

		System.out.println(amount + " is transfered from " + fromAccount + " to " + toAccount);

	}

}
