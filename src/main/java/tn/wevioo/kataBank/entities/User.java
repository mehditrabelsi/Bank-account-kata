package tn.wevioo.kataBank.entities;

import java.io.Serializable;

/**
 * User entity
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * User informations
	 */
	private String firstName;
	private String lastName;
	private String login;
	private String pwd;

	/**
	 * The account of user
	 *
	 * @see Account
	 */
	private Account account;

	// Constructors
	public User() {
	}

	/**
	 * @param firstName
	 *            represents the user first name.
	 * @param lastName
	 *            represents the user last name
	 * @param login
	 *            represents the user login
	 * @param pwd
	 *            represents the password
	 * @param account
	 *            represents the user account
	 */
	public User(String firstName, String lastName, String login, String pwd, Account account) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.pwd = pwd;
		this.account = account;
	}

	// Getters & setters

	/**
	 * Gets the user's first name
	 *
	 * @return a string representing the user first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets a first name to the user
	 *
	 * @param firstName
	 *            A string representing the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the user's last name
	 *
	 * @return a string representing the user last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets a last name to the user
	 *
	 * @param lastName
	 *            A string representing the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the user's login
	 *
	 * @return a string representing the user login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets a login to the user
	 *
	 * @param login
	 *            A string representing the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the user's password
	 *
	 * @return a string representing the user password
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Sets a password to the user
	 *
	 * @param pwd
	 *            A string representing the password to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Gets the user Account
	 *
	 * @return An Account entity representing the user account
	 * @see Account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Sets an account to the user
	 *
	 * @param account
	 *            An account representing the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User : " + "firstName = '" + firstName + '\'' + ", lastName = '" + lastName + '\'' + ", account = "
				+ account;
	}
}
