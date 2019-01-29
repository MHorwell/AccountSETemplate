package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.utilities.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	
	Long id = (long) 0;
	Map<Long, Account> account = new HashMap<>();
	JSONUtil gSON = new JSONUtil();
	Account acc;
	StringBuilder accountsString;

	public String getAllAccounts() {
		
		for (Long id: this.account.keySet()) {
			accountsString.append(this.account.get(id).toString());
		}
		return accountsString.toString();
	}

	public String createAccount(String account) {
		id++;
		acc = gSON.getObjectForJSON(account, acc.getClass());
		this.account.put(id, acc);
		return account;
	}

	public String deleteAccount(Long id) {
		this.account.remove(id);
		return this.account.get(id).toString();
	}

	public String updateAccount(Long id, String account) {
		acc = gSON.getObjectForJSON(account, acc.getClass());
		this.account.put(id, acc);
		return this.account.get(id).toString();
	}
	
	public int getMapSize() {
		return account.size();
	}

}
