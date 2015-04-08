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
		int startScore = 1000;
		for(int i = 0; i < differenceNums.length; i++) {
			startScore -= returnDifference(localScores[i], mlbScores[i]);
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
		float[] localScores = {lbStats.getHitting_games_play(), lbStats.getHitting_ab(), lbStats.getHitting_runs_total(), lbStats.getHitting_onbase_h(), 
				lbStats.getHitting_onbase_d(), lbStats.getHitting_onbase_t(), lbStats.getHitting_onbase_hr(), lbStats.getHitting_rbi(),
				lbStats.getHitting_outs_ktotal(), lbStats.getHitting_steal_stolen()};
		
		// Load Mlb Player Stats
		float [] mlbScores = {};
		System.out.println("Not implemented");
	}

}
