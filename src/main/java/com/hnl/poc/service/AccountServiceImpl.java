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
	public AccountDao accountDao;

	public Account retrieveAccountById(String accountID) {
		if(logger.isDebugEnabled()){
			logger.debug("retrieveAccountById:" + accountID);
		}
		Account account = accountDao.retreiveAccountById(accountID);
		return account;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void saveAccount(Account account) {
		if(logger.isDebugEnabled()){
			logger.debug("savingAccount:" + account.toString());
		}
		accountDao.saveAccount(account);
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
