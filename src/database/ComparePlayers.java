package database;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// TO DO LIST:
// 1. Account for Local Player per game stats vs MLB PLayer Season Stats
// 2. Add Pitching Comparison
// 3. Implement compareToPlayerList()

// Modified Similarity Score.  Adapted from http://www.baseball-reference.com/about/similarity.shtml
public class ComparePlayers {
	
	private static float[] localScore;
	private static float[] mlbScore;
	private static int[] differenceNums = {20, 75, 10, 15, 5, 4, 2, 10, 150, 20};
	private static float localBAverage;
	private static float localSlug;
	private static float mlbBAverage;
	private static float mlbSlug;
	
	public static ArrayList<ComparisonResult> compareToPlayerList(LocalPlayer lp, ArrayList<MlbPlayer> mlbList) {
		ArrayList<ComparisonResult> results = new ArrayList<ComparisonResult>();
		
		Comparator<ComparisonResult> comparator = new ComparisonResult.ComparisonResultComparator();
        PriorityQueue<ComparisonResult> queue = new PriorityQueue<ComparisonResult>(mlbList.size(), comparator);
		
		for (MlbPlayer player : mlbList) {
			float score = compareToPlayer(lp, player);
			queue.add(new ComparisonResult(player, score));
		}
		
		for (int i = 0; i < 10; i++) {
			results.add(queue.remove());
		}
		
		return results;
	}
	
	public static float compareToPlayer(LocalPlayer lp, MlbPlayer mlbPlayer) {
		
		loadScores(lp, mlbPlayer);
		
		float startScore = 1000.0f;
		for(int i = 0; i < differenceNums.length; i++) {
			startScore -= returnDifference(localScore[i], mlbScore[i], i);
		}
		startScore -= returnDifference(localBAverage, mlbBAverage, .001f);
		startScore -= returnDifference(localSlug, mlbSlug, .002f);
		
		return (startScore / 1000.0f);
	}
	
	private static float returnDifference(float firstNum, float secNum, int position) {
		float difference = Math.abs(firstNum - secNum);
		int remainder = (int)(difference % differenceNums[position]);
		return remainder;
	}
	
	private static float returnDifference(float firstNum, float secNum, float differenceNum) {
		float difference = Math.abs(firstNum - secNum);
		int remainder = (int)(difference % differenceNum);
		return remainder;
	}
	
	private static void loadScores(LocalPlayer lb, MlbPlayer mlbPlayer) {
		// Load Local Player Stats
		
		ArrayList<LocalPlayerBattingStatistics> lpStatsBat = LocalPlayerBattingStatistics.getStatisticsFromDatabase(lb.getLocalPlayerId());
		
		LocalPlayerBattingStatistics lpStats = lpStatsBat.get(0);
		// local player batting average
		float battingAverageLocal = 0.00f;
		if (lpStats.getHitting_ab() != 0) {
			battingAverageLocal = lpStats.getHitting_onbase_h() / lpStats.getHitting_ab();
		}
		else {
			battingAverageLocal = 0.00f;
		}
		
		float[] localScores = {lpStats.getHitting_games_play(), lpStats.getHitting_ab(), lpStats.getHitting_runs_total(), lpStats.getHitting_onbase_h(), 
				lpStats.getHitting_onbase_d(), lpStats.getHitting_onbase_t(), lpStats.getHitting_onbase_hr(), lpStats.getHitting_rbi(),
				lpStats.getHitting_outs_ktotal(), lpStats.getHitting_steal_stolen()};
		localBAverage = battingAverageLocal;
		localSlug = lpStats.getSlugging();
		localScore = localScores;
		
		// Load Mlb Player Stats
		float [] mlbScores  = {mlbPlayer.getHitting_games_play(), mlbPlayer.getHitting_ab(), mlbPlayer.getHitting_runs_total(), mlbPlayer.getHitting_onbase_h(), 
				mlbPlayer.getHitting_onbase_d(), mlbPlayer.getHitting_onbase_t(), mlbPlayer.getHitting_onbase_hr(), mlbPlayer.getHitting_rbi(),
				mlbPlayer.getHitting_outs_ktotal(), mlbPlayer.getHitting_steal_stolen()};
		mlbScore = mlbScores;
		mlbBAverage = mlbPlayer.getBattingAverage();
		mlbSlug = mlbPlayer.getSlugging();
	}
}
