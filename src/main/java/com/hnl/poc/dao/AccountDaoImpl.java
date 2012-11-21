package com.hnl.poc.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hnl.poc.entity.Account;

@Repository("accountDao")
@Transactional
public class AccountDaoImpl extends AbstractJpaDAO<Account> implements
		AccountDao {
	private Logger logger = Logger.getLogger(this.getClass());

	public AccountDaoImpl() {
		setClazz(Account.class);
	}

	/**
	 * saveAccount
	 * 
	 * @param Account
	 *            account
	 **/
	public Long saveAccount(Account account) {
		if (account != null) {
			save(account);
		}
		
		return account.getId();
	}

	/**
	 * updateAccount
	 * 
	 * @param Account
	 *            account
	 **/
	public void updateAccount(Account account) {
		if (account != null) {
			update(account);
		}
	}

	/**
	 * retreiveAccountById - get account by id
	 * 
	 * @param String
	 *            accountID
	 * @return Account
	 **/
	public Account retreiveAccountById(Long accountID) {
		Account account = null;
		try {
			logger.debug("**inside retrievedAccountByID: " + accountID);
			Query query = entityManager.createQuery(
					"Select a from Account a where a.id=:accountId",
					Account.class);
			query.setParameter("accountId", accountID);
			logger.debug("***BEFORE execute Query***");

			account = (Account) query.setMaxResults(1)
					.getSingleResult();

			logger.debug("***got the account " + account.toString() + "***");
		} catch (NoResultException nre) {
			logger.info("***No results found for " + accountID + "**");
		}
		return account;
	}

	/**
	 * retreiveAccounts - get list of accounts by lastname
	 * 
	 * @param String
	 *            lastname
	 * @return List<Account>
	 **/
	public List<Account> retrieveAccounts(String lastname) {
		Query query = entityManager.createQuery(
				"Select a from Account a where a.lastname=:lastname", Account.class).setParameter("lastname", lastname);
		List<Account> accountResult = query.getResultList();
		
		return accountResult;
	}

	/**
	 * retrieveAccounts - gets all accounts
	 * 
	 * @return List<Account>
	 **/
	public List<Account> retrieveAccounts() {
		logger.debug("******inside retrieveAccounts()*********");
		List<Account> accountResult = entityManager.createQuery(
				"Select a from Account", Account.class).getResultList();
		return accountResult;
	}

	/**
	 * deleteAccount
	 **/
	public void deleteAccount(Account account) {
		if (account != null) {
			entityManager.remove(account);
		}
	}
}
