package tn.wevioo.kataBank.entities;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Operation entity
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 */
public class Operation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Operation informations
	 */
	private int numOperation;
	private double amount;
	private double balance;
	private LocalDate date;

	/**
	 * An operation can be a deposit or a withdrawal
	 *
	 * @see TypeOperation
	 */
	private TypeOperation type;

	// Constructors
	public Operation() {
		numOperation++;
	}

	/**
	 * @param numOperation
	 *            represents the operation number
	 * @param amount
	 *            the amount to be withdrawn
	 * @param balance
	 *            the account balance after the operation
	 * @param date
	 *            the date of the operation
	 * @param type
	 *            the type of the operation
	 */
	public Operation(int numOperation, double amount, double balance, LocalDate date, TypeOperation type) {
		this.numOperation = numOperation;
		this.amount = amount;
		this.balance = balance;
		this.date = date;
		this.type = type;
	}

	// Getters & setters

	/**
	 * Gets the operation balance
	 *
	 * @return a double representing the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets a balance to the operation
	 *
	 * @param balance
	 *            represents the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Gets the operation type
	 *
	 * @return deposit or withdrawal
	 */
	public TypeOperation getType() {
		return type;
	}

	/**
	 * Sets a type to the operation
	 *
	 * @param type
	 *            represents the operation type
	 */
	public void setType(TypeOperation type) {
		this.type = type;
	}

	/**
	 * Gets the number of the operation
	 *
	 * @return an integer representing the operation number
	 */
	public int getNumOperation() {
		return numOperation;
	}

	/**
	 * Sets a number to an operation
	 *
	 * @param numOperation
	 *            representing the number to set
	 */
	public void setNumOperation(int numOperation) {
		this.numOperation = numOperation;
	}

	/**
	 * Gets the date of the operation
	 *
	 * @return A date representing the date of the operation
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Sets the operation date
	 *
	 * @param date
	 *            representing the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Gets the operation's amount
	 *
	 * @return a double representing the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets an amount to the operation
	 *
	 * @param amount
	 *            a double representing the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Operation{" + "numOperation='" + numOperation + '\'' + ", date=" + date + ", amount=" + amount + '}';
	}
}
