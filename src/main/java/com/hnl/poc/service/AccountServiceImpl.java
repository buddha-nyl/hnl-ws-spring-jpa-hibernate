package com.hnl.poc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hnl.poc.dao.AccountDao;
import com.hnl.poc.entity.Account;

public class AccountServiceImpl implements AccountService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private AccountDao accountDao;

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public Account retrieveAccountById(Long accountID) {
		if(logger.isDebugEnabled()){
			logger.debug("retrieveAccountById:" + accountID);
		}
		Account account = accountDao.retreiveAccountById(accountID);
		return account;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Long saveAccount(Account account) {
		if(logger.isDebugEnabled()){
			logger.debug("savingAccount:" + account.toString());
			logger.debug("**accountDao = " + accountDao);
		}
		accountDao.saveAccount(account);
		return account.getId();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void updateAccount(Account account) {
		if(logger.isDebugEnabled()){
			logger.debug("updateAccount:" + account.toString());
		}
		accountDao.updateAccount(account);

	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteAccount(Account account) {
		if(logger.isDebugEnabled()){
			logger.debug("deleteAccount:" + account.toString());
		}
		accountDao.deleteAccount(account);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<Account> retrieveAccounts(String lastname) {
		if(logger.isDebugEnabled()){
			logger.debug("retrieveAccount with lastname:" + lastname);
		}
		List <Account> accounts = accountDao.retrieveAccounts(lastname);
		return accounts;
	}

}
