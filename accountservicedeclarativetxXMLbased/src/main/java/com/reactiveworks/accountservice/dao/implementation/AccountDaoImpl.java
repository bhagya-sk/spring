package com.reactiveworks.accountservice.dao.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.reactiveworks.accountservice.dao.IAccountDao;
import com.reactiveworks.accountservice.dao.model.Account;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

	private static final String GET_QUERY = "SELECT * FROM account;";
	private static final String UPDATE_QUERY = "UPDATE account SET amount=? WHERE account_no=?;";
	private static final String GET_ACCOUNT = "SELECT * FROM account WHERE account_no=?;";

	@Override
	public List<Account> getAccountUser() {
		List<Account> accountsList = getJdbcTemplate().query(GET_QUERY, new AccountMapper());

		return accountsList;
	}

	public void withdraw(long fromAccount, double amount) {

		Account accountObj = getAcccountDetails(fromAccount);
		double amt = 0;
		if (amount <= accountObj.getAmount())
			amt = accountObj.getAmount() - amount;
		getJdbcTemplate().update(UPDATE_QUERY, new Object[] { amt, fromAccount });
		System.out.println(amount + " is debited from the account number: " + fromAccount);

	}

	public void deposit(long toAccount, double amount) {
		// String QUERY="UPDATE account SET amount1=? WHERE account_no=?;";
		String QUERY = "UPDATE account SET amount=? WHERE account_no=?;";
		Account accountObj = getAcccountDetails(toAccount);
		double amt = accountObj.getAmount() + amount;
		getJdbcTemplate().update(QUERY, new Object[] { amt, toAccount });
		System.out.println(amount + " is credit into the account number: " + toAccount);
		// throw new RuntimeException();  // if this exception is thrown debited amount will
		// be credited back into the sender's account
	}

	@Override
	public Account getAcccountDetails(long accountNo) {
		Account accountObj = getJdbcTemplate().queryForObject(GET_ACCOUNT, new Object[] { accountNo },
				new AccountMapper());
		return accountObj;
	}

	private static final class AccountMapper implements RowMapper<Account> {

		@Override
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account accountObj = new Account();
			accountObj.setAccountNo(rs.getLong(1));
			accountObj.setAccountType(rs.getString(2));
			accountObj.setAmount(rs.getDouble(3));
			return accountObj;
		}

	}

}