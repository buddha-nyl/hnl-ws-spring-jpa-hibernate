/**
 * 
 */
package com.hnl.poc.service;

import java.util.List;

import com.hnl.poc.entity.Account;

/**
 * @author UGHN13
 *
 */
public interface AccountService {
	public Account retrieveAccountById(String accountID);
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public void deleteAccount(Account account);
	public List<Account> retrieveAccounts(String lastname);
}
