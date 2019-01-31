package com.qa.persistence.repository;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.utilities.JSONUtil;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Transactional(SUPPORTS)
public class AccountDBRepository implements AccountRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	JSONUtil util;

	@Override
	public String getAllAccounts() {
		Query query = manager.createQuery("SELECT a FROM Account a");
		return util.getJSONForObject(query.getResultList());
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		manager.persist(acc);
		
		return "{\"message\": \"account " + acc.getAccountNumber() + " has been added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		manager.remove(findAccount(id));
		return "{\"message\": \"account has been removed\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		deleteAccount(id);
		createAccount(account);
		return "{\"message\": \"account has been updated\"}";
	}
	
	public Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}

	@Override
	public int getCountByFirstName(String firstName) {
		Query query = manager.createQuery("SELECT COUNT(a) FROM Account a WHERE firstName = ?");
		query = query.setParameter(0, firstName);  
		return query.getFirstResult();
	}

}
