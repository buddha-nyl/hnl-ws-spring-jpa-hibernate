/**
 * 
 */
package com.hnl.poc.service.ws;

import javax.jws.WebService;

import com.hnl.poc.entity.Account;

/**
 * @author hawnnguyen
 *
 */
@WebService
public interface AccountServiceWS {
	Account retrieveAccountById(Long accountID);
	Long saveAccount(Account account);
}
