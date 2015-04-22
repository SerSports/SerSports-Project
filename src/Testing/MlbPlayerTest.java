package Testing;

import database.MlbPlayer;
import database.MlbPlayerFilter;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MlbPlayerTest {
	
/*	static ArrayList<MlbPlayer> players;

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
		assertTrue(true);
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

	@Test(expected=AssertionError.class)
	public void testGetPlayersFromDatabase() {
		
		MlbPlayerFilter filter = new MlbPlayerFilter();
		assertNotNull(MlbPlayer.getPlayersFromDatabase(filter));
		assertTrue(MlbPlayer.getPlayersFromDatabase(filter).size() > 0);

		filter.setIdValue(null);
		assertNotNull(MlbPlayer.getPlayersFromDatabase(filter));
		assertTrue(MlbPlayer.getPlayersFromDatabase(filter).size() > 0);

		filter.setIdValue("00856892-9a5a-4161-b979-4335dab399cc");
		assertNotNull(MlbPlayer.getPlayersFromDatabase(filter));
		assertTrue(MlbPlayer.getPlayersFromDatabase(filter).size() > 0);

		filter.setIdValue(null);
		filter.setFirstNameValue("Jose");
		assertNotNull(MlbPlayer.getPlayersFromDatabase(filter));
		assertTrue(MlbPlayer.getPlayersFromDatabase(filter).size() > 0);

		filter.setFirstNameValue(null);
		filter.setLastNameValue("Johnson");
		assertNotNull(MlbPlayer.getPlayersFromDatabase(filter));
		assertTrue(MlbPlayer.getPlayersFromDatabase(filter).size() > 0);

		filter.setLastNameValue(null);
		filter.setTeamNameValue("Cardinals");
		assertNotNull(MlbPlayer.getPlayersFromDatabase(filter));
		assertTrue(MlbPlayer.getPlayersFromDatabase(filter).size() > 0);

		filter.setLastNameValue("Goldschmidt");
		filter.setTeamNameValue("Diamondbacks");
		assertNotNull(MlbPlayer.getPlayersFromDatabase(filter));
		assertTrue(MlbPlayer.getPlayersFromDatabase(filter).size() > 0);

		filter.setLastNameValue("x");
		filter.setTeamNameValue("x");
		assertNotNull(MlbPlayer.getPlayersFromDatabase(filter));
		assertTrue(MlbPlayer.getPlayersFromDatabase(filter).size() == 0);
	}*/
}