package com.qa.MapTests;

import static org.junit.Assert.*;
import com.qa.utilities.JSONUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {

	private AccountMapRepository mapRepo;
	private JSONUtil json = new JSONUtil();
	private String jSONAccount;

	@Before
	public void setup() {
		mapRepo = new AccountMapRepository();
		Account account = new Account("FirstName", "LastName", 123456);
		System.out.println(json.getJSONForObject(account));
		
		
	}

	@Test
	public void addAccountTest() {
		mapRepo.createAccount(jSONAccount);
		assertEquals(1, mapRepo.getMapSize());
	}

	@Test
	public void add2AccountTest() {
		mapRepo.createAccount(jSONAccount);
		mapRepo.createAccount(jSONAccount);
		assertEquals(2, mapRepo.getMapSize());
	}

	@Test
	public void removeAccountTest() {
		mapRepo.createAccount(jSONAccount);
		mapRepo.deleteAccount((long) 0);
		assertEquals(0, mapRepo.getMapSize());

	}

	@Test
	public void remove2AccountTest() {
		mapRepo.createAccount(jSONAccount);
		mapRepo.createAccount(jSONAccount);
		assertEquals(2, mapRepo.getMapSize());
		mapRepo.deleteAccount((long) 1);
		mapRepo.deleteAccount((long) 2);
		assertEquals(0, mapRepo.getMapSize());
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		mapRepo.createAccount(jSONAccount);
		mapRepo.createAccount(jSONAccount);
		mapRepo.deleteAccount((long) 1);
		mapRepo.deleteAccount((long) 2);
		mapRepo.deleteAccount((long) 3);
		
		
	}

	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
		
		
	}

	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {
		
	}

	@Test
	public void accountConversionToJSONTest() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {

	}

}
