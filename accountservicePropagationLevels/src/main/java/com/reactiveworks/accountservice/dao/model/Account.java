package com.reactiveworks.accountservice.dao.model;

import org.springframework.stereotype.Component;

@Component
public class Account {

	private long accountNo;
	private String accountType;
	private double amount;

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", amount=" + amount + "]";
	}

}
