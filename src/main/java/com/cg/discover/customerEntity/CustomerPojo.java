package com.cg.discover.customerEntity;

public class CustomerPojo {
	
	private int customerId;
	private String customerName;
	private long accountNumber;
	private long accountBalance;
	private long loanAmount;
	
	public CustomerPojo() {
	
	}
	
	public CustomerPojo(int customerId, String customerName, long accountNumber, long accountBalance, long loanAmount) {
	
		this.customerId = customerId;
		this.customerName = customerName;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.loanAmount = loanAmount;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	
	
	

}
