package com.hnl.test.poc;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnl.poc.entity.Account;
import com.hnl.poc.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/test-service-beans.xml")
public class AccountServiceTest {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public AccountService accountService;
	
	@Test
	public void testAccountService() {
		logger.debug("****inside Account Service Test****");
		Long bobId = accountService.saveAccount(new Account("Bob", "Dylan", new Date()));
		
		logger.debug("BobID: " + bobId);
		Account a = accountService.retrieveAccountById(bobId);
		logger.debug("****Account: " + a.toString());
	}

}
