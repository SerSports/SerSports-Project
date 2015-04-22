package Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import database.ComparePlayers;
import database.ComparisonResult;
import database.LocalPlayer;
import database.LocalPlayerBattingStatistics_Season;
import database.LocalPlayerPitchingStatistics;
import database.LocalPlayerPitchingStatistics_Season;
import database.MlbPlayer;

public class ComparePlayersTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	// public static float compareToPlayer(LocalPlayer lp, MlbPlayer mlbPlayer)
	@Test 
	public void compareToPlayer_test() {
		// public static float compareToPlayer(LocalPlayer lp, MlbPlayer mlbPlayer) 
		assertTrue(ComparePlayers.compareToPlayer(null, null) == 0.0f);
		assertTrue(ComparePlayers.compareToPlayer(LocalPlayer.getLocalPlayerForId(4), MlbPlayer.getPlayerForId("617e6d98-d7dc-49ea-adbd-22e00e3ccc81")) == 0);
		assertTrue(ComparePlayers.compareToPlayer(LocalPlayer.getLocalPlayerForId(1), MlbPlayer.getPlayerForId("c177b52d-7e9e-4780-a5d2-23ca59469ff5")) > 0);
	}

	@Test
	public void compareToPlayerStats_test() {

		LocalPlayerBattingStatistics_Season lpBatting = null;
		LocalPlayerPitchingStatistics_Season lpPitching = null;

		assertTrue(ComparePlayers.compareToPlayer(lpBatting, lpPitching, MlbPlayer.getPlayerForId("617e6d98-d7dc-49ea-adbd-22e00e3ccc81")) == 0);

		LocalPlayer lp = LocalPlayer.getLocalPlayerForId(1);
		ArrayList<LocalPlayerBattingStatistics_Season> listBat = LocalPlayerBattingStatistics_Season.getStatisticsFromDatabase(lp.getLocalPlayerId());
		lpBatting = listBat.get(0);
		ArrayList<LocalPlayerPitchingStatistics_Season> listPitch = LocalPlayerPitchingStatistics_Season.getStatisticsFromDatabase(lp.getLocalPlayerId());
		lpPitching = listPitch.get(0);
		assertTrue(ComparePlayers.compareToPlayer(lpBatting, lpPitching, MlbPlayer.getPlayerForId("617e6d98-d7dc-49ea-adbd-22e00e3ccc81")) > 0);
	}

	// public static ArrayList<ComparisonResult> compareToPlayerList(LocalPlayer lp, ArrayList<MlbPlayer> mlbList)
	@Test 
	public void compareToPlayerStatsList_test() {
		ArrayList<MlbPlayer> mlbList = null;
		assertTrue(ComparePlayers.compareToPlayerList(null, mlbList).size() == 0);
		assertTrue(ComparePlayers.compareToPlayerList(LocalPlayer.getLocalPlayerForId(1), mlbList).size() == 0);
		mlbList = new ArrayList<MlbPlayer>();
		assertTrue(ComparePlayers.compareToPlayerList(LocalPlayer.getLocalPlayerForId(1), mlbList).size() == 0);
		mlbList = MlbPlayer.getListOfPlayersFromDatabase();
		assertTrue(ComparePlayers.compareToPlayerList(LocalPlayer.getLocalPlayerForId(1), mlbList).size() > 0);
	}
}
