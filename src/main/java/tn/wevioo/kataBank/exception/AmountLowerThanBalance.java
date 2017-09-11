package tn.wevioo.kataBank.exception;

/**
 * Exception levé lorsque le montant est inférieure a la balance
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 */
public class AmountLowerThanBalance extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AmountLowerThanBalance(String msg) {
		// TODO Auto-generated constructor stub
		System.out.println(msg);
	}
}
