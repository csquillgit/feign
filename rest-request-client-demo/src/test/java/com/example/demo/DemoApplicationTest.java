package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest {

	@Autowired
	private AccountFacade accountFacade;

	@Test
	public void findAccounts() {
		List<Account> accounts;
		try {
			accounts = accountFacade.findAll();
			assertTrue(accounts.size() > 0);
		} catch (FacadeException e) {
			fail();
		}
	}

	@Test
	public void findAccount() {

		try {
			Account account = accountFacade.find(1L);
			assertTrue(account.getId() == 1);
		} catch (FacadeException e) {
			fail();
		}
	}

	@Test
	public void updateAccount() {

		try {
			Account account = new Account();
			account.setId(1L);
			account.setNumber("123");
			account.setOwner("Test");
			Account returnedAccount = accountFacade.update(account);
			assertTrue(returnedAccount.getBalance() > 0L);
			assertTrue(returnedAccount.getNumber().equals("123"));
		} catch (FacadeException e) {
			fail();
		}
	}

	@Test
	public void throwNullPointerException() {

		try {
			accountFacade.nullPointer();
			fail();
		} catch (FacadeException e) {
			assertEquals(e.getException(), "java.lang.NullPointerException");
		}

	}

	@Test
	public void throwFacadeException() {
		try {
			accountFacade.facadeException();
			fail();
		} catch (FacadeException e) {
			assertEquals(e.getMessage(), "Couldn't do something");
		}
	}

}
