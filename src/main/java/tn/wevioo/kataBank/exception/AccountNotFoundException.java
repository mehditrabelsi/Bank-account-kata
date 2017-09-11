package tn.wevioo.kataBank.exception;

/**
 * Exception levé lorsque le compte n'existe pas
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 */
public class AccountNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		System.out.println(msg);
	}

}
