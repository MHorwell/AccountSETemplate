package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.utilities.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	
	private Map<Long, Account> account = new HashMap<>();
	private JSONUtil json = new JSONUtil();
	private StringBuilder accountsString;

	public String getAllAccounts() {
		
		for (Map.Entry<Long, Account> entry : this.account.entrySet()) {
			accountsString.append(entry.getValue().toString());
		}
		return accountsString.toString();
	}

	public String createAccount(String account) {
		Account acc = json.getObjectForJSON(account, Account.class);
		long id = (long) acc.getAccountNumber();
		this.account.put(id, acc);
		return null;
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
		Account acc = json.getObjectForJSON(account, Account.class);
		this.account.put(id, acc);
		return this.account.get(id).toString();
	}
	
	public int getSize() {
		return account.size();
	}

	public int getCountByFirstName(String string) {
		int count = 0;
		for (Map.Entry<Long, Account> entry : this.account.entrySet()) {
			if (entry.getValue().getFirstName().equals(string)) {
				count ++;
			}
		}
		return count;
	}

}
