package com.qa.business;

public interface AccountRules {
	
	String getAllAccounts();
	
	String createAccount(String account);
	
	String deleteAccount(Long id);
	
	String updateAccount(Long id, String account);
	
	int getCountByFirstName(String firstName);

}
