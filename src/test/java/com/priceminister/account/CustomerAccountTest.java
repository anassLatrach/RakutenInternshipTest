package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertEquals(0.0, customerAccount.getBalance(),0);
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
    	Double amountToAdd =  28.54;
        customerAccount.add(amountToAdd);
        assertEquals(amountToAdd, customerAccount.getBalance(),0);
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     * @throws IllegalBalanceException 
     */
    @Test(expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
    	Double amountToAdd = 125.0;
    	Double withdrawnAmount;
    	Double actualBalance;
    	
    	customerAccount.add(amountToAdd);
    	actualBalance = customerAccount.getBalance();
        withdrawnAmount = actualBalance + 100.0;
        
        assertTrue(withdrawnAmount > actualBalance);
        
        customerAccount.withdrawAndReportBalance(withdrawnAmount,this.rule);    
        }
    
    // Also implement missing unit tests for the above functionalities.
	/**
	 *  Adds negative money to the account and checks that the new balance is no affected.
	 */
    @Test
    public void testNegativeAmount() {
    	Double amountToAdd;
    	Double actualBalance;
    	Double newBalance;
    	
        amountToAdd = -53.2;
        actualBalance = customerAccount.getBalance();
        
        customerAccount.add(amountToAdd);
        newBalance = customerAccount.getBalance();
        assertEquals(new Double(actualBalance), new Double(newBalance));

    }
}
