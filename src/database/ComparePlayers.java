package database;

import java.util.ArrayList;

public class ComparePlayers {
	
	private static float[] localScore;
	private static float[] mlbScore;
	private static float[] differenceNums;
	
	public static ArrayList<MlbPlayer> compareToPlayerList(LocalPlayer lp, ArrayList<MlbPlayer> mlbList) {
		return mlbList;
	}
	
	public static float compareToPlayer(LocalPlayer lb, MlbPlayer mlbPlayer) {
		loadScores(lb, mlbPlayer);
		float startScore = 100.00f;
		for(int i = 0; i < differenceNums.length; i++) {
			startScore -= returnDifference(localScore[i], mlbScore[i]);
		}
		return 50.0f;
	}
	
	private static int returnDifference(float firstNum, float secNum) {
		
		return 1;
	}
	
	private static void loadScores(LocalPlayer lb, MlbPlayer mlbPlayer) {
		// Load Local Player Stats
		
		ArrayList<LocalPlayerBattingStatistics> lpStatsBat = LocalPlayerBattingStatistics.getStatisticsFromDatabase(lb.getLocalPlayerId());
		
		
		LocalPlayerBattingStatistics lbStats = lpStatsBat.get(0);
		// local player batting average
		float battingAverageLocal = 0.00f;
		if (lbStats.getHitting_ab() != 0) {
			battingAverageLocal = lbStats.getHitting_onbase_h() / lbStats.getHitting_ab();
		}
		else {
			battingAverageLocal = 0.00f;
		}
		
		float[] localScores = {lbStats.getHitting_games_play(), lbStats.getHitting_ab(), lbStats.getHitting_runs_total(), lbStats.getHitting_onbase_h(), 
				lbStats.getHitting_onbase_d(), lbStats.getHitting_onbase_t(), lbStats.getHitting_onbase_hr(), lbStats.getHitting_rbi(),
				lbStats.getHitting_outs_ktotal(), lbStats.getHitting_steal_stolen(), battingAverageLocal};
		localScore = localScores;
		
		// Load Mlb Player Stats
		float [] mlbScores  = {mlbPlayer.getHitting_games_play(), mlbPlayer.getHitting_ab(), mlbPlayer.getHitting_runs_total(), mlbPlayer.getHitting_onbase_h(), 
				mlbPlayer.getHitting_onbase_d(), mlbPlayer.getHitting_onbase_t(), mlbPlayer.getHitting_onbase_hr(), mlbPlayer.getHitting_rbi(),
				mlbPlayer.getHitting_outs_ktotal(), mlbPlayer.getHitting_steal_stolen(), mlbPlayer.getBattingAverage()};
		mlbScore = mlbScores;
		System.out.println("Not implemented yet");
	}

}
