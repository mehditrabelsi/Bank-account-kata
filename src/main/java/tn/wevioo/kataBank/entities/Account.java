package tn.wevioo.kataBank.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Account entity
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 */
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Account informations
	 */
	private String accountNumber;
	private double balance;

	private LocalDate openingDate;
	/**
	 * Operations history
	 *
	 * @see Operation
	 */
	private List<Operation> operations;

	// Constructors
	public Account() {
		operations = new ArrayList<>();
	}

	/**
	 * Creates an Account with the specified informations
	 *
	 * @param accountNumber
	 *            is the identifier of the account
	 * @param openingDate
	 *            the creation date of the account
	 * @param operations
	 *            a list of the account operations
	 * @param balance
	 *            the account balance
	 */
	public Account(String accountNumber, LocalDate openingDate, List<Operation> operations, double balance) {
		this.accountNumber = accountNumber;
		this.openingDate = openingDate;
		this.operations = operations;
		this.balance = balance;
	}

	// Getters & setters

	/**
	 * Gets the account number
	 *
	 * @return a String representing the account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number
	 *
	 * @param accountNumber
	 *            a string representing the value to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Gets the account opening date
	 *
	 * @return a date representing the opening date
	 */
	public LocalDate getOpeningDate() {
		return openingDate;
	}

	/**
	 * Sets an account opening date
	 *
	 * @param openingDate
	 *            a date representing the value to set
	 */
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	/**
	 * Gets a list of operations for the account
	 *
	 * @return an Operation List containing all account operations
	 */
	public List<Operation> getOperations() {
		return operations;
	}

	/**
	 * Sets an operation list to the account
	 *
	 * @param operations
	 *            represents an operation list to set
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	/**
	 * Gets the account balance
	 *
	 * @return a double representing the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets a balance into an account
	 *
	 * @param balance
	 *            is a double representing the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account{" + "accountNumber='" + accountNumber + '\'' + ", openingDate=" + openingDate + ", operations="
				+ operations + ", balance=" + balance + '}';
	}
}
