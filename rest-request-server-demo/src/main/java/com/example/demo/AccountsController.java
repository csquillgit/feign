package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

	protected Logger logger = Logger.getLogger(AccountsController.class.getName());
	
	@RequestMapping("/nullpointer")
	public void throwNullPointerException() {
		throw new NullPointerException("Couldn't do something");
	}
	
	@RequestMapping("/facadeexception")
	public void throwFacadeException() {
		throw new FacadeException("Couldn't do something", new ArrayIndexOutOfBoundsException());
	}

	@RequestMapping("/accounts")
	public List<Account> all() {
		List<Account> list =  new ArrayList<Account>();	
		Account account =  new Account();
		account.setNumber("123");
		account.setOwner("Test");
		list.add(account);
		Account account2 =  new Account();
		account2.setNumber("321");
		account2.setOwner("Test2");
		list.add(account2);
		return list;
	}
	
	@RequestMapping("/accounts/id/{id}")
	public Account findById(@PathVariable("id") long id) {
		Account account = new Account();
		account.setId(id);
		account.setNumber("123_"  + id);
		account.setOwner("Test_" +  id);
		return account;
	}
	
	@RequestMapping(value = "/accounts/update")
	public Account updateAccount(@RequestBody Account account) {
		account.deposit(1000L);
		return account;
	}
}
