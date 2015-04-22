/*package Testing;
import database.Database;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@Before
	public void setUp() throws Exception {
	
	}
	
	@Test
	public void testexecuteSQL() {
		// Invalid Inputs

		assertFalse(Database.executeSQL("2131"));
		assertFalse(Database.executeSQL("INSERT INTO mlbPlayers(incorrectfield, lastName, team, number, position) VALUES(\"Bob\", \"Dole\", \"Bears\", 23, \"Belly Itcher\")l"));
		assertFalse(Database.executeSQL("SELECT * FROM mlbPlayers WHERE incorrectfield = 123"));
		
		// Valid Inputs
		assertTrue(Database.executeSQL("INSERT INTO mlbPlayers(firstName, lastName, team) VALUES(\"Bob\", \"Dole\", \"Bears\");"));
		assertTrue(Database.executeSQL("INSERT INTO mlbPlayers(firstName, lastName, team) VALUES(\"Bob\", \"Dole\", \"Bears\");"));
		assertTrue(Database.executeSQL("INSERT INTO mlbPlayers(firstName, lastName, team) VALUES(\"Bob\", \"Dole\", \"Bears\");"));
	}

	@Test
	public void testgetResultSetFromSQL() {
				// Invalid Inputs
		assertNull(Database.getResultSetFromSQL(null));
		assertNull(Database.getResultSetFromSQL(""));
		assertNull(Database.getResultSetFromSQL("2131"));
		assertNull(Database.getResultSetFromSQL("INSERT INTO mlbPlayers(firstName, lastName, team, number, position) VALUES(\"Bob\", \"Dole\", \"Bears\", 23, \"Belly Itcher\")"));
		assertNull(Database.getResultSetFromSQL("SELECT * FROM mlbPlayers WHERE incorrectfield = 123"));
		assertNull(Database.getResultSetFromSQL("SELECT incorrectfield FROM mlbPlayers WHERE mlbPlayerId = 123"));
		
		// Valid Inputs
		assertNotNull(Database.getResultSetFromSQL("SELECT * FROM mlbPlayers"));
		assertNotNull(Database.getResultSetFromSQL("SELECT * FROM mlbPlayers WHERE firstName = \"Paul\""));
		assertNotNull(Database.getResultSetFromSQL("SELECT lastName FROM mlbPlayers WHERE firstName = \"Paul\""));
	}
}*/
