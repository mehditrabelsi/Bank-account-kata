package tn.wevioo.kataBank.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tn.wevioo.kataBank.entities.Operation;
import tn.wevioo.kataBank.entities.TypeOperation;

import java.time.LocalDate;

/**
 * Test for Operation class
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 */
public class OperationTest {

	/**
	 * Instance of operation
	 * 
	 * @see Operation
	 */
	private Operation operation;

	@Before // testing the operation creation
	public void beforeTestingOperation() {
		operation = new Operation();

		Assert.assertNotNull(operation);
	}

	@Test // testing operation attributes
	public void testOperation() {
		operation.setAmount(100);
		operation.setBalance(50);
		operation.setDate(LocalDate.now());
		operation.setNumOperation(1);
		operation.setType(TypeOperation.Deposit);

		Assert.assertEquals(100, operation.getAmount(), 0);
	}

}
