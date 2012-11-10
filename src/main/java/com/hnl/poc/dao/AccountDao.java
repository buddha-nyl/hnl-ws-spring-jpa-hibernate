/**
 * 
 */
package com.hnl.poc.dao;

import java.util.List;

import com.hnl.poc.entity.Account;

/**
 * @author Hawn Nguyen
 *
 */
public interface AccountDao {
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public Account retreiveAccountById(String AccountID);
	public List<Account> retrieveAccounts(String lastname);
	public void deleteAccount(Account account);
}
