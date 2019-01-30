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
	private String jSONAccount = "{\"firstName\":\"FirstName\",\"lastName\":\"LastName\",\"accountNumber\":10}";
	private String jSONAccount2 = "{\"firstName\":\"FirstName\",\"lastName\":\"LastName\",\"accountNumber\":11}";

	@Before
	public void setup() {
		mapRepo = new AccountMapRepository();
	}

	@Test
	public void addAccountTest() {
		mapRepo.createAccount(jSONAccount);
		assertEquals(1, mapRepo.getSize());
	}

	@Test
	public void add2AccountTest() {
		mapRepo.createAccount(jSONAccount);
		mapRepo.createAccount(jSONAccount2);
		assertEquals(2, mapRepo.getSize());
	}

	@Test
	public void removeAccountTest() {
		mapRepo.createAccount(jSONAccount);
		mapRepo.deleteAccount(10L);
		assertEquals(0, mapRepo.getSize());

	}

	@Test
	public void remove2AccountTest() {
		mapRepo.createAccount(jSONAccount);
		mapRepo.createAccount(jSONAccount2);
		assertEquals(2, mapRepo.getSize());
		mapRepo.deleteAccount(10L);
		mapRepo.deleteAccount(11L);
		assertEquals(0, mapRepo.getSize());
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		mapRepo.createAccount(jSONAccount);
		mapRepo.createAccount(jSONAccount2);
		mapRepo.deleteAccount(10L);
		for(int i = 0; i < 2; i++)
		try {
			mapRepo.deleteAccount(11L);
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
		
	}

	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
		Account testAccount = new Account("first", "last", 123);
		String accountString = json.getJSONForObject(testAccount);
		assertEquals("{\"firstName\":\"first\",\"lastName\":\"last\",\"accountNumber\":123}", accountString);
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
