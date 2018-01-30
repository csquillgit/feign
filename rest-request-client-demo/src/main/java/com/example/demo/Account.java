package com.example.demo;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id;

	protected String number;

	protected String owner;

	protected Long balance;

	protected Account() {
		balance = 0L;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

}
