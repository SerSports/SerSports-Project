package database;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SportsStatsApiTest {

	@Test
	public void testGetListOfMlbPlayerAPIImportForYear() {
		try {
			assertNull(SportsStatsApi.getListOfMlbPlayerAPIImportForYear(-1));
			assertNull(SportsStatsApi.getListOfMlbPlayerAPIImportForYear(0));
			assertNull(SportsStatsApi.getListOfMlbPlayerAPIImportForYear(5000));
			assertNotNull(SportsStatsApi.getListOfMlbPlayerAPIImportForYear(2013));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoadNewestStatsIntoDatabase() {
		SportsStatsApi.loadNewestStatsIntoDatabase();
	}
}