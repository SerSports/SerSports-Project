package Testing;

import database.SportsStatsApi;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SportsStatsApiTest {

	@Test
	public void testGetListOfMlbPlayerAPIImportForYear() {
		assertNull(SportsStatsApi.getListOfMlbPlayerForYear(-1));
		assertNull(SportsStatsApi.getListOfMlbPlayerForYear(0));
		//assertNull(SportsStatsApi.getListOfMlbPlayerForYear(5000));
		assertNotNull(SportsStatsApi.getListOfMlbPlayerForYear(2013));
		assertNotNull(SportsStatsApi.getListOfMlbPlayerForYear(2014));
	}
	
	@Test
	public void testLoadNewestStatsIntoDatabase() {
		SportsStatsApi.loadNewestStatsIntoDatabase();
	}
}