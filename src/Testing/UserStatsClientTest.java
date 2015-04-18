package Testing;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.UserBattingStatsClient;
import client.UserFieldingStatsClient;
import client.UserPitchingStatsClient;

public class UserStatsClientTest {

	UserBattingStatsClient batter = new UserBattingStatsClient();
	UserFieldingStatsClient fielder = new UserFieldingStatsClient();
	UserPitchingStatsClient pitcher = new UserPitchingStatsClient();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void battingTest() {
		batter.debug("Testing in UserBattingStatsClient");
		assertTrue(batter.isValidDate("2/2/2001"));
		assertFalse(batter.isValidDate(" "));
		assertFalse(batter.isValidDate("MM/DD/YYYY"));
		batter.setBattingAverage(0.0, 0.0);
		batter.setBattingAverage(10.0, 5.0);
		batter.getBattingAverage();
		
		fielder.debug("Testing in UserFieldingStatsClient");
		assertTrue(fielder.isValidDate("2/2/2001"));
		assertFalse(fielder.isValidDate(""));
		assertFalse(fielder.isValidDate("MM/DD/YYYY"));
		
		pitcher.debug("Testing in UserPitchingStatsClient");
		assertTrue(pitcher.isValidDate("2/2/2001"));
		assertFalse(pitcher.isValidDate(""));
		assertFalse(pitcher.isValidDate("MM/DD/YYYY"));
		
	}

}
