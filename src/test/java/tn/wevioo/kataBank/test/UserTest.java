package tn.wevioo.kataBank.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tn.wevioo.kataBank.entities.User;

/**
 * Tests for User class
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 */
public class UserTest {

	/**
	 * Instanciate a User
	 * 
	 * @see User
	 */
	private User user;

	@Before // testing User instantiation
	public void beforeTestingUser() {
		user = new User();

		Assert.assertNotNull(user);
	}

	@Test // testing user attributes
	public void testUser() {
		user.setFirstName("Mehdi");
		user.setLastName("Trabelsi");
		user.setLogin("mehdi");
		user.setPwd("mehdi");

		Assert.assertEquals("Mehdi", user.getFirstName());
	}
}
