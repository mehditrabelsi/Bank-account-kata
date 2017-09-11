package tn.wevioo.kataBank.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tn.wevioo.kataBank.entities.Account;
import tn.wevioo.kataBank.entities.Operation;
import tn.wevioo.kataBank.exception.AccountNotFoundException;
import tn.wevioo.kataBank.exception.AmountLowerThanBalance;
import tn.wevioo.kataBank.exception.AmountMinMaxValueException;
import tn.wevioo.kataBank.service.OperationService;
import tn.wevioo.kataBank.service.OperationServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Test for Account class
 * 
 * @author Mehdi
 */
public class AccountTest {

	/**
	 * Instance of Account
	 * 
	 * @since 10 septembre 2017
	 * @author Mehdi
	 * @see Account
	 */
	private Account account;

	private OperationService operationService = new OperationServiceImpl();

	@Before
	// testing the instantiation of an Account object
	public void initializeAccountServiceTest() {
		account = new Account();
		account.setAccountNumber("001");
		account.setBalance(1000);
		account.setOpeningDate(LocalDate.of(2017, 9, 10));
		account.setOperations(new ArrayList<Operation>());
		Assert.assertNotNull(account);
	}

	@Test
	// Testing if the Account is not empty
	public void account() {
		account.setAccountNumber("001");
		account.setBalance(1000);
		account.setOpeningDate(LocalDate.of(2017, 9, 10));
		account.setOperations(new ArrayList<Operation>());

		Assert.assertEquals(account.getBalance(), 1000, 0);
	}

	@Test
	public void shouldReturnEmptyBalanceWhenNoOperation() {

		Assert.assertEquals(account.getBalance(), 1000, 0);
	}

	@Test
	public void shouldCalculateWhenMultipeDeposite()
			throws AccountNotFoundException, AmountMinMaxValueException {
		operationService.deposit(account, 250);
		operationService.deposit(account, 250);
		operationService.deposit(account, 350);
		Assert.assertEquals(account.getBalance(), 1850, 0);

	}

	@Test
	public void shouldCalculateWhenOneWithdraw()
			throws AccountNotFoundException, AmountLowerThanBalance,
			AmountMinMaxValueException {
		operationService.retrive(account, 100);

		Assert.assertEquals(account.getBalance(), 900, 0);
	}

	@Test
	public void shouldCalculateWhenMultipleWithdraw()
			throws AccountNotFoundException, AmountLowerThanBalance,
			AmountMinMaxValueException {
		operationService.retrive(account, 100);
		operationService.retrive(account, 250);
		Assert.assertEquals(account.getBalance(), 650, 0);
	}

	@Test(expected = AmountLowerThanBalance.class)
	public void shouldRefuseToMakeAWithdrawalGreaterThanBalance()
			throws AccountNotFoundException, AmountLowerThanBalance,
			AmountMinMaxValueException {
		operationService.retrive(account, 20000);

	}

	@Test
	public void shouldeCalculateWhenWithdrawsAndDeposits()
			throws AccountNotFoundException, AmountLowerThanBalance,
			AmountMinMaxValueException {
		operationService.deposit(account, 250);
		operationService.retrive(account, 100);
		operationService.deposit(account, 300);
		operationService.retrive(account, 50);
		Assert.assertEquals(account.getBalance(), 1400, 0);
	}

}
