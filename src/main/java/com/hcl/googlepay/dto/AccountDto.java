package com.hcl.googlepay.dto;

public class AccountDto {

	private Integer accountId;
	
	private int userId;
	
	public int acountNumber;
	
	private int availableBallance;
	
	private int phoneNumber;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAcountNumber() {
		return acountNumber;
	}

	public void setAcountNumber(int acountNumber) {
		this.acountNumber = acountNumber;
	}

	public int getAvailableBallance() {
		return availableBallance;
	}

	public void setAvailableBallance(int availableBallance) {
		this.availableBallance = availableBallance;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
