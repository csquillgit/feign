package com.example.demo;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="AccountFacade", url="http://localhost:8080")
public interface AccountFacade {
	
	 @RequestMapping(method = RequestMethod.GET, value = "/nullpointer")
	 public void nullPointer() throws FacadeException;
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/facadeexception")
	 public void facadeException() throws FacadeException;
	
	 @RequestMapping(method = RequestMethod.GET, value = "/accounts")
	 public List<Account> findAll() throws FacadeException;
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/accounts/id/{accountId}")
	 public Account find(@PathVariable("accountId") Long accountId) throws FacadeException;

	 @RequestMapping(method = RequestMethod.POST, value = "/accounts/update", consumes = "application/json")
	 public Account update(Account account) throws FacadeException;
}
