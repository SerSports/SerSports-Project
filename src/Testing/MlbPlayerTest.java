package Testing;

import database.MlbPlayer;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MlbPlayerTest {
	
	static ArrayList<MlbPlayer> players;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		players = MlbPlayer.getListOfPlayersFromDatabase();
	}

	@Before
	public void setUp() throws Exception {
	
	}

	@Test
	public void testMlbPlayer() {
		MlbPlayer test = players.get(0);
		assertNotNull(test);
	}

	@Test
	public void testGettersAndSetters() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveMlbPlayerToDatabase() {
		MlbPlayer test = players.get(0);
		assertTrue(test.saveMlbPlayerToDatabase());
	}
	
	@Test
	public void testGetListOfPlayersFromDatabase() {
		assertNotNull(MlbPlayer.getListOfPlayersFromDatabase()); 
	}

	@Test
	public void testGetPlayersFromDatabase() {
		assertNotNull(MlbPlayer.getPlayersFromDatabase("", "", "", ""));
	}
}