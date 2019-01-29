package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.utilities.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	
	private Long id =  0L;
	private Map<Long, Account> account = new HashMap<>();
	private JSONUtil gSON = new JSONUtil();
	private Account acc;
	private StringBuilder accountsString;

	public String getAllAccounts() {
		
		for (Map.Entry<Long, Account> entry : this.account.entrySet()) {
			accountsString.append(entry.getValue().toString());
		}
		return accountsString.toString();
	}

	public String createAccount(String account) {
		id++;
		acc = gSON.getObjectForJSON(account, Account.class);
		this.account.put(id, acc);
		return account;
	}

	public String deleteAccount(Long id) {
		String output = (this.account.get(id)).toString();
		this.account.remove(id);
		return output;
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
