package com.hnl.poc.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hnl.poc.entity.Account;

@Repository("accountDao")
@Transactional
public class AccountDaoImpl extends AbstractJpaDAO <Account> implements AccountDao {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public AccountDaoImpl(){
		setClazz(Account.class);
	}
	/**
	 * saveAccount 
	 * @param Account account
	 **/
	public void saveAccount(Account account) {
		if(account!=null){
			save(account);
		}
	}
	/**
	 * updateAccount 
	 * @param Account account
	 **/
	public void updateAccount(Account account) {
		if(account!=null){
			update(account);
		}
	}
	/**
	 * retreiveAccountById - get account by id
	 * @param String accountID
	 * @return Account
	 **/
	public Account retreiveAccountById(String accountID) {
		Query query = entityManager.createQuery("from Account a where a.id=:id").setParameter("id", accountID);
		Account account = (Account)query.getSingleResult();
		return account;
	}
	/**
	 * retreiveAccounts - get list of accounts by lastname
	 * @param String lastname
	 * @return List<Account>
	 **/
	public List<Account> retrieveAccounts(String lastname) {
		Query query = entityManager.createQuery("from Account a where a.lastname=:lastname").setParameter("lastname", lastname);
		List<Account> accountResult = query.getResultList();
		return accountResult;
	}
	/**
	 * retrieveAccounts - gets all accounts
	 * @return List<Account>
	 **/
	public List<Account> retrieveAccounts() {
		List<Account> accountResult = entityManager.createQuery("from Account", Account.class).getResultList();
		return accountResult;
	}
	
	/**
	 * deleteAccount
	 **/
	public void deleteAccount(Account account){
		if(account != null){
			entityManager.remove(account);
		}
	}
}
