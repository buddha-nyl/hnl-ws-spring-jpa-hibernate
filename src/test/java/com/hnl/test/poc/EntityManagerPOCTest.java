package com.hnl.test.poc;

/**
 * EntityManager TestCase of Hibernate as JPA Provider
 * @author Hawn Nguyen
 **/

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hnl.poc.entity.Account;

public class EntityManagerPOCTest extends TestCase {
	
	private EntityManagerFactory entityManagerFactory;

	@Before
	protected void setUp() throws Exception {
		// the name matches the persistence-unit in persistence.xml
		entityManagerFactory = Persistence.createEntityManagerFactory("com.hnl.jpa.unit");
	}

	@After
	protected void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	@Test
	public void testEntity1() {
		// create a couple of events
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(new Account("John", "Doe", new Date()));
		entityManager.persist(new Account("Mary", "Jane", new Date()));
		entityManager.getTransaction().commit();
		entityManager.close();
		
		//pull accounts from the database and list
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Account> accountResult = entityManager.createQuery("from Account", Account.class).getResultList();
		
		for(Account account : accountResult){
			System.out.println("Account (" + account.getFirstname()+" " + account.getLastname() + " created on " + account.getDate() + ")");
		}
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
