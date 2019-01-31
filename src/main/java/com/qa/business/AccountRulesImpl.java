package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.utilities.JSONUtil;

public class AccountRulesImpl implements AccountRules {
	
	@Inject
	private AccountRepository repo;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		if (acc.getAccountNumber() == 9) {
			return "{\"message\": \"account number: '" + acc.getAccountNumber() + "' is not allowed\"}";
		}
		return repo.createAccount(account);
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

	@Override
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	@Override
	public int getCountByFirstName(String firstName) {
		return repo.getCountByFirstName(firstName);
	}

}
