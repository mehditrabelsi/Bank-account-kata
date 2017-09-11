package tn.wevioo.kataBank.test;

import tn.wevioo.kataBank.entities.Account;
import tn.wevioo.kataBank.entities.Operation;
import tn.wevioo.kataBank.exception.AccountNotFoundException;
import tn.wevioo.kataBank.exception.AmountLowerThanBalance;
import tn.wevioo.kataBank.exception.AmountMinMaxValueException;
import tn.wevioo.kataBank.service.OperationService;
import tn.wevioo.kataBank.service.OperationServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Test for OperationService class
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 */
public class OperationServiceTest {

	/**
	 * instance of operationService to execute operations
	 * 
	 * @see OperationService
	 */
	private OperationService operationService = new OperationServiceImpl();

	/**
	 * instance of Account
	 * 
	 * @see Account
	 */
	private Account account;

	@Before // testing the instance of account
	public void initializeOperationServiceTest() {
		account = new Account();
		account.setAccountNumber("001");
		account.setBalance(7000);
		account.setOpeningDate(LocalDate.of(2017, 9, 10));
		account.setOperations(new ArrayList<Operation>());

		Assert.assertNotNull(account);
	}

	// ********************Deposit operation************************

	/**
	 * In order to save money As a bank client I want to make a deposit in my
	 * account
	 * @throws AmountMinMaxValueException 
	 * @throws AccountNotFoundException 
	 */

	@Test // testing the deposit operation
	public void deposit() throws AccountNotFoundException, AmountMinMaxValueException {
		operationService.deposit(account, 250);
		Assert.assertEquals(account.getBalance(), 7250, 0);
	}

	@Test
	public void oneDeposit() throws AccountNotFoundException, AmountMinMaxValueException {

		operationService.deposit(account, 250);

		Assert.assertEquals(account.getOperations().size(), 1);
	}

	@Test
	public void multipleDeposit() throws AccountNotFoundException, AmountMinMaxValueException {

		operationService.deposit(account, 250);
		operationService.deposit(account, 500);

		Assert.assertEquals(account.getOperations().size(), 2);
	}

	// ********************Withdrawal operation************************

	/**
	 * In order to retrieve some or all of my savings As a bank client I want to
	 * make a withdrawal from my account
	 * @throws AmountMinMaxValueException 
	 * @throws AmountLowerThanBalance 
	 * @throws AccountNotFoundException 
	 */
	@Test // testing the retrive operation
	public void retrive() throws AccountNotFoundException, AmountLowerThanBalance, AmountMinMaxValueException {
		operationService.retrive(account, 250);
		Assert.assertEquals(account.getBalance(), 6750, 0);
	}

	@Test
	public void oneWithdrawal() throws AccountNotFoundException, AmountLowerThanBalance, AmountMinMaxValueException {

		operationService.retrive(account, 250);

		Assert.assertEquals(account.getOperations().size(), 1);
	}

	@Test
	public void multipleWithdrawal() throws AccountNotFoundException, AmountLowerThanBalance, AmountMinMaxValueException {
		operationService.retrive(account, 250);
		operationService.retrive(account, 555);
		operationService.retrive(account, 250);
		Assert.assertEquals(account.getOperations().size(), 3);
	}

	// ********************History operation************************
	/**
	 * In order to check my operations As a bank client I want to see the
	 * history (operation, date, amount, balance) of my operations
	 * 
	 * @throws AmountMinMaxValueException
	 * @throws AccountNotFoundException
	 * @throws AmountLowerThanBalance
	 */
	@Test // testing the history operation
	public void historyOfMultipleOperations() throws AccountNotFoundException, AmountMinMaxValueException, AmountLowerThanBalance {
		operationService.deposit(account, 550);
		operationService.deposit(account, 250);
		operationService.retrive(account, 50);
		operationService.history(account);
		Assert.assertNotNull(account.getOperations());

	}

	@Test // testing the history operation of one deposit
	public void historyOfOneDeposit() throws AccountNotFoundException, AmountMinMaxValueException {
		operationService.deposit(account, 550);

		operationService.history(account);
		Assert.assertNotNull(account.getOperations());
		Assert.assertEquals(account.getOperations().size(), 1);

		Assert.assertEquals(account.getBalance(), 7550, 0);
	}

	@Test // testing the history operation of one withdrawal
	public void HistoryOfOneWithdrawal() throws AccountNotFoundException, AmountLowerThanBalance, AmountMinMaxValueException {
		operationService.retrive(account, 550);

		operationService.history(account);
		Assert.assertNotNull(account.getOperations());
		Assert.assertEquals(account.getOperations().size(), 1);

		Assert.assertEquals(account.getBalance(), 6450, 0);
	}
}
