package com.qa.business;

import javax.inject.Inject;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.utilities.JSONUtil;

@Transactional(SUPPORTS)
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
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		if (acc.getAccountNumber() == 9) {
			return "{\"message\": \"account number: '" + acc.getAccountNumber() + "' is not allowed\"}";
		}
		return repo.createAccount(account);
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	@Override
	public int getCountByFirstName(String firstName) {
		return repo.getCountByFirstName(firstName);
	}

}
