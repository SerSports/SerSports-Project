package Testing;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import database.MlbPlayer;
import database.User;

public class UserTest {
	
	@Test
	public void testAuthenticateUser() {
		assertNotNull(User.authenticateUser("ser_sports", "admin"));
	}
	
	@Test
	public void testNewUser() {
		assertNotNull(User.newUser("Test", "test", "Colton", "Test", 19));
	}
}
