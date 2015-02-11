package testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sersports.mlb.MlbPlayerStatistics;
import sersports.mlb.SportsStatsApi;

public class SportsStatsApiTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetListOfMlbPlayerStatisticsForYear()
	{
		try {

			// Valid Input Tests
			List<MlbPlayerStatistics> list = SportsStatsApi.getListOfMlbPlayerStatisticsForYear(2013);
			assertNotNull(list);
			assertTrue(list.size() > 0);

			// Invalid Input Tests
			list = SportsStatsApi.getListOfMlbPlayerStatisticsForYear(-1);
			assertNull(list);
			list = SportsStatsApi.getListOfMlbPlayerStatisticsForYear(0);
			assertNull(list);
			list = SportsStatsApi.getListOfMlbPlayerStatisticsForYear(1);
			assertNull(list);
			list = SportsStatsApi.getListOfMlbPlayerStatisticsForYear(50000);
			assertNull(list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
