package testing;

import java.util.List;

import sersports.mlb.*;

public class testConsole {

	public static void main(String[] args) throws Exception 
	{	
		// Test for Player Statistics Api
		System.out.println("Getting Player Statistics using SportsStatsApi");
		List<MlbPlayerStatistics> mlbPlayers = SportsStatsApi.getListOfMlbPlayerStatisticsForYear(2013);
		System.out.println(mlbPlayers.size() + " players received.");
		
		// Print out one to test.
		System.out.println(mlbPlayers.get(12).toString());
	}
}
