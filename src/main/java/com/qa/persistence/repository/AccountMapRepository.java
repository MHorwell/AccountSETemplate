package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Account;
import com.qa.utilities.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository{
	
	Map<Long, Account> account = new HashMap<>();
	JSONUtil util = new JSONUtil();

	public String getAllAccounts() {
		return util.getJSONForObject(account.values());
	}

	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		long id = (long) acc.getAccountNumber();
		this.account.put(id, acc);
		return "Account Created";
	}

	public Map<Long, Account> getAccount() {
		return account;
	}

	public void setAccount(Map<Long, Account> account) {
		this.account = account;
	}
	
	public String deleteAccount(Long id) {
		String output = (this.account.get(id)).toString();
		this.account.remove(id);
		return output;
	}

	public String updateAccount(Long id, String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		this.account.put(id, acc);
		return this.account.get(id).toString();
	}
	
	public int getSize() {
		return account.size();
	}

	public int getCountByFirstName(String firstName) {
		int count = 0;
		for (Map.Entry<Long, Account> entry : this.account.entrySet()) {
			if (entry.getValue().getFirstName().equals(firstName)) {
				count ++;
			}
		}
		return count;
	}

}
