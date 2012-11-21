package com.hnl.test.poc;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnl.poc.dao.AccountDao;
import com.hnl.poc.entity.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations="/spring/test-service-beans.xml")
public class DAOEntityManagerTest {
	final Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private AccountDao accountDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDAO() {
		logger.debug("******Inside testDAO******");
		Long maryId = accountDao.saveAccount(new Account("Mary", "Jane", new Date()));
		Long jayId = accountDao.saveAccount(new Account("Jay", "Jane", new Date()));
		Long janeId = accountDao.saveAccount(new Account("Bob", "Dylan", new Date()));
		
		//get accounts
		logger.debug("*****&^%***First Account ("+maryId+") ******");
		Account maccount = accountDao.retreiveAccountById(maryId);
		if(maccount != null) {
			logger.debug("*****GOT THE First Account ("+maryId+") = " + maccount.toString() +"*******");
		}
		
		//retrieve all accounts
		List<Account> accountList = accountDao.retrieveAccounts("Jane");
		assertNotNull("Account List is null.", accountList);
		
		logger.debug("****before loop: size of accountList "+ accountList.size() +"***");
		for(Account account : accountList){
			logger.debug("****DAO Accessing Account: " + account.toString());
		}
	}

}
