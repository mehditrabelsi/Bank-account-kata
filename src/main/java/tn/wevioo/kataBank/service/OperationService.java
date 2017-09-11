package tn.wevioo.kataBank.service;

import tn.wevioo.kataBank.entities.Account;
import tn.wevioo.kataBank.exception.AccountNotFoundException;
import tn.wevioo.kataBank.exception.AmountLowerThanBalance;
import tn.wevioo.kataBank.exception.AmountMinMaxValueException;

/**
 * Interface of operation service
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 */
public interface OperationService {
	/**
	 * To make a deposit in the account
	 *
	 * @param account
	 *            the user account
	 * @param amount
	 *            the amount to save
	 * @return true if the deposit succeeded
	 * @throws AccountNotFoundException
	 * @throws AmountMinMaxValueException
	 */
	public boolean deposit(Account account, double amount)
			throws AccountNotFoundException, AmountMinMaxValueException;

	/**
	 * To make a withdrawal for the account
	 *
	 * @param account
	 *            the user account
	 * @param amount
	 *            the amount to be withdrawn
	 * @return true if the withdrawal succeeded
	 * @throws AccountNotFoundException
	 * @throws AmountLowerThanBalance
	 * @throws AmountMinMaxValueException
	 */
	public boolean retrive(Account account, double amount)
			throws AccountNotFoundException, AmountLowerThanBalance,
			AmountMinMaxValueException;

	/**
	 * To print operations history for the account
	 *
	 * @param account
	 *            the user account
	 * @throws AccountNotFoundException
	 */
	public void history(Account account) throws AccountNotFoundException;
}
