package database;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.experimental.max.MaxCore;

// TO DO LIST:
// 1. Account for Local Player per game stats vs MLB PLayer Season Stats
// 2. Add Pitching Comparison
// 3. Implement compareToPlayerList()

// Modified Similarity Score.  Adapted from http://www.baseball-reference.com/about/similarity.shtml
public class ComparePlayers {
	
	private static float[] mlbScore;
	private static float[] differenceNums_Hitting = {20, 75, 10, 15, 5, 4, 2, 10, 150, 20};
	private static float[] differenceNums_Pitching = {1, 2, .002f, .02f, 10, 50};
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
		return (compareToPlayer_Hitting(lp, mlbPlayer) + compareToPlayer_Pitching(lp, mlbPlayer)) / 2.0f;
	}
	
	private static float compareToPlayer_Hitting(LocalPlayer lp, MlbPlayer mlbPlayer) {
		final float startScore = (11.f/12.f) * 1000.0f;
		float score = startScore;
		
		if (mlbPlayer.getBatting_games_play() > 0)
		{
			float[] localScore = loadScores_Hitting(lp, mlbPlayer);
			
			if (localScore.length > 0) {
				for(int i = 0; i < localScore.length; i++) {
					score -= returnDifference(localScore[i], mlbScore[i], differenceNums_Hitting[i]);
				}
				score -= returnDifference(localBAverage, mlbBAverage, .001f);
				score -= returnDifference(localSlug, mlbSlug, .002f);
			} else {
				score = 0;
			}
		} else {
			score = 0;
		}
		
		if (score < 0) {
			score = 0;
		}
		
		return (score / startScore);	
	}
	
	private static float compareToPlayer_Pitching(LocalPlayer lp, MlbPlayer mlbPlayer) {
		final float startScore = (6.f/13.f) * 1000.0f;
		float score = startScore;
		
		if (mlbPlayer.getPitching_games_play() > 0)
		{
			float[] localScore = loadScores_Pitching(lp, mlbPlayer);
			
			if (localScore.length > 0) {
				for(int i = 0; i < localScore.length; i++) {
					score -= returnDifference(localScore[i], mlbScore[i], differenceNums_Pitching[i]);
				}
			} else {
				score = 0;
			}
		} else {
			score = 0;
		}
		
		if (score < 0) {
			score = 0;
		}
		
		return (score / startScore);	 
	}

	private static float returnDifference(float firstNum, float secNum, float differenceNum) {
		float difference = Math.abs(firstNum - secNum);
		float remainder = (difference / differenceNum);
		return remainder;
	}
	
	private static float[] loadScores_Hitting(LocalPlayer lp, MlbPlayer mlbPlayer) {
		float[] localScore;
		
		// Load Local Player Stats
		ArrayList<LocalPlayerBattingStatistics_Season> lpStatsBat = LocalPlayerBattingStatistics_Season.getStatisticsFromDatabase(lp.getLocalPlayerId());
		LocalPlayerBattingStatistics_Season lpStats = lpStatsBat.get(0);
		
		// local player batting average
		float battingAverageLocal = 0.00f;
		if (lpStats.getBatting_totals_ab() != 0) {
			battingAverageLocal = (float) lpStats.getBatting_onbase_totals_h() / (float) lpStats.getBatting_totals_ab();
		}
		else {
			battingAverageLocal = 0.00f;
		}
		
		float[] localScores = {lpStats.getBatting_game_play(), lpStats.getBatting_totals_ab(), lpStats.getBatting_totals_runs(), lpStats.getBatting_onbase_totals_h(), 
				lpStats.getBatting_onbase_totals_d(), lpStats.getBatting_onbase_totals_t(), lpStats.getBatting_onbase_totals_hr(), lpStats.getBatting_totals_rbi(),
				lpStats.getBatting_totals_outs_k(), lpStats.getBatting_steal_totals_stolen()};
		localBAverage = battingAverageLocal;
		localSlug = lpStats.getSlugging();
		localScore = localScores;
		
		// Load Mlb Player Stats
		float [] mlbScores  = {mlbPlayer.getBatting_games_play(), mlbPlayer.getBatting_ab(), mlbPlayer.getBatting_runs_total(), mlbPlayer.getBatting_onbase_h(), 
				mlbPlayer.getBatting_onbase_d(), mlbPlayer.getBatting_onbase_t(), mlbPlayer.getBatting_onbase_hr(), mlbPlayer.getBatting_rbi(),
				mlbPlayer.getBatting_outs_ktotal(), mlbPlayer.getBatting_steal_stolen()};
		mlbScore = mlbScores;
		mlbBAverage = mlbPlayer.getBattingAverage();
		mlbSlug = mlbPlayer.getSlugging();
		
		return localScore;
	}
	
	private static float[] loadScores_Pitching(LocalPlayer lp, MlbPlayer mlbPlayer) {
		float[] localScore;

		// Load Local Player Stats
		ArrayList<LocalPlayerPitchingStatistics_Season> lpStatsList = LocalPlayerPitchingStatistics_Season.getStatisticsFromDatabase(lp.getLocalPlayerId());
		LocalPlayerPitchingStatistics_Season lpStats = lpStatsList.get(0);

		float[] localScores = {lpStats.getPitching_games_won(), lpStats.getPitching_games_loss(), 
				(lpStats.getPitching_games_won() / lpStats.getPitching_games_play()), lpStats.getPitching_totals_era(), 
				lpStats.getPitching_games_play(), lpStats.getPitching_games_totals_hit()};
		localScore = localScores;

		// Load Mlb Player Stats
		float [] mlbScores  = {mlbPlayer.getPitching_games_win(), mlbPlayer.getPitching_games_loss(), 
				(mlbPlayer.getPitching_games_win() / mlbPlayer.getPitching_games_play()), mlbPlayer.getPitching_era(), 
				mlbPlayer.getPitching_games_play(), mlbPlayer.getPitching_onbase_h()};
		mlbScore = mlbScores;

		return localScore;
	}
}
