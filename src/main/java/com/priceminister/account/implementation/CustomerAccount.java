package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

	private Double balance;

	public CustomerAccount() {
		this.balance = 0.0;
	}
	
	private CustomerAccount(final Double balance) {
		this.balance = balance;
	}
	
	/**  To instantiate with 
	 * @param balance
	 * @return
	 * @throws IllegalBalanceException
	 * 
	 */
	public static CustomerAccount createValidBalance(final Double balance) throws IllegalBalanceException {
		if (balance >= 0) {
			return new CustomerAccount(balance);
		} else {
			throw new IllegalBalanceException(balance);
		}
	}

	public void add(Double addedAmount) {
		balance += addedAmount;
    }
 
    public Double getBalance() {
    	return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
    	if(withdrawnAmount != null && rule != null) {
    		Double newBalance = balance - withdrawnAmount;
	    	if(rule.withdrawPermitted(newBalance)) {
	    		return balance - withdrawnAmount; 		
	    	}else{
	    		throw new IllegalBalanceException(balance);
	    	}
    	}
		return balance;
    	
    }

}
