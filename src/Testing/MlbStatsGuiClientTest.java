package Testing;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import database.MlbPlayer;

public class MlbStatsGuiClientTest {
	MlbPlayer test;
	String id;

	@Before
	public void setUp() throws Exception {
		//select david ortiz
		id = "fadd12b6-4d2d-4e03-82d9-c5e8b6cb0b83";
		test = MlbPlayer.getPlayerForId(id);
	}

	@After
	public void tearDown() throws Exception {
		//this.test.close();
	}

	@Test
	public void test() {
		assertNotNull(MlbPlayer.getStatisticsFromDatabase(id));		
	}

}
