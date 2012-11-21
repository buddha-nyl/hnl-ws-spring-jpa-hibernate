package com.hnl.poc.service.ws;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.hnl.poc.entity.Account;
import com.hnl.poc.service.AccountService;

@WebService(endpointInterface = "com.hnl.poc.service.ws.AccountServiceWS")
public class AccountServiceWSImpl implements AccountServiceWS {
	
	//default constructor
	public AccountServiceWSImpl(){
	}

	@Autowired
	private AccountService accountService;
	
	@Override
	public Account retrieveAccountById(Long accountID) {
		Account account = accountService.retrieveAccountById(accountID);
		return account;
	}

	@Override
	public Long saveAccount(Account account) {
		Long aId = accountService.saveAccount(account);
		return aId;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}
