package com.qa.persistence.domain;

import com.qa.utilities.JSONUtil;

public class Account {
	
	JSONUtil json = new JSONUtil();
	
	private String firstName;
	
	private String lastName;
	
	private int accountNumber;
	
	public Account() {
	}

	public Account(String firstName, String lastName, int accountNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Override
	public String toString() {
		return json.getJSONForObject(this);
	}
	
}
