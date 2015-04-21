package database;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.experimental.max.MaxCore;

/**
 * Calculates a score for a batting component and a pitching component of local player and
 * then compares that score with one generated for an MLB player. Compares those two
 * scores and takes their average to be used for determining a similarity percentage
 * between the two.
 * 
 * @author SerSports
 */
public class ComparePlayers
{
	private static float[] mlbScore;
	private static float[] differenceNums_Hitting = { 20, 75, 10, 15, 5, 4, 2, 10, 150, 20, 001f, 002f };
	private static float[] differenceNums_Pitching = { 1, 2, .002f, .02f, 10, 50 };
	private static float localBAverage; // Local Player Batting Average
	private static float localSlug; // Local Player Slugging Percentage
	private static float mlbBAverage; // MLB Player Batting Average
	private static float mlbSlug; // MLB Player Slugging Percentage
	
	public static ArrayList<ComparisonResult> compareToPlayerList(LocalPlayer lp,
			ArrayList<MlbPlayer> mlbList)
	{
		ArrayList<ComparisonResult> results = new ArrayList<ComparisonResult>();
		
		Comparator<ComparisonResult> comparator = new ComparisonResult.ComparisonResultComparator();
		PriorityQueue<ComparisonResult> queue = new PriorityQueue<ComparisonResult>(
				mlbList.size(), comparator);
		
		LocalPlayerBattingStatistics_Season lpBatting = null;
		LocalPlayerPitchingStatistics_Season lpPitching = null;
		
		ArrayList<LocalPlayerBattingStatistics_Season> lpStatsBat = LocalPlayerBattingStatistics_Season.getStatisticsFromDatabase(lp.getLocalPlayerId());
		if(!lpStatsBat.isEmpty())
		{
			lpBatting = lpStatsBat.get(0);
		}
		ArrayList<LocalPlayerPitchingStatistics_Season> lpStatsList = LocalPlayerPitchingStatistics_Season.getStatisticsFromDatabase(lp.getLocalPlayerId());
		if(!lpStatsList.isEmpty())
		{
			lpPitching = lpStatsList.get(0);
		}
		
		for (MlbPlayer player : mlbList)
		{
			float score = compareToPlayer(lpBatting, lpPitching, player);
			queue.add(new ComparisonResult(player, score));
		}
		for (int i = 0; i < 10; i++)
		{
			results.add(queue.remove());
		}
		
		return results;
	}
	
	/**
	 * Compares the scores of Local and MLB players that they receive through the
	 * compareToPlayer_Hitting and compareToPlayer_Pitching methods and averages them.
	 * 
	 * @param lp
	 *            Local Player model
	 * @param mlbPlayer
	 *            MLB Player model
	 * @return Average of the player's scores.
	 */
	public static float compareToPlayer(LocalPlayer lp, MlbPlayer mlbPlayer)
	{
		float result = 0f;
		
		if (lp != null && mlbPlayer != null) {

			LocalPlayerBattingStatistics_Season lpBatting = null;
			LocalPlayerPitchingStatistics_Season lpPitching = null;
			
			ArrayList<LocalPlayerBattingStatistics_Season> lpStatsBat = LocalPlayerBattingStatistics_Season.getStatisticsFromDatabase(lp.getLocalPlayerId());
			if(!lpStatsBat.isEmpty())
			{
				lpBatting = lpStatsBat.get(0);
			}
			ArrayList<LocalPlayerPitchingStatistics_Season> lpStatsList = LocalPlayerPitchingStatistics_Season.getStatisticsFromDatabase(lp.getLocalPlayerId());
			if(!lpStatsList.isEmpty())
			{
				lpPitching = lpStatsList.get(0);
			}
			
			result = compareToPlayer(lpBatting, lpPitching, mlbPlayer);
		}
		
		return result;
	}

	
	/**
	 * Compares the scores of Local and MLB players that they receive through the
	 * compareToPlayer_Hitting and compareToPlayer_Pitching methods and averages them.
	 * 
	 * @param lpBatting
	 *            Local Player Batting Statistics model
	 * @param lpPitching
	 *            Local Player Pitching Statistics model
	 * @param mlbPlayer
	 *            MLB Player model
	 * @return Average of the player's scores.
	 */
	public static float compareToPlayer(LocalPlayerBattingStatistics_Season lpBatting, 
						LocalPlayerPitchingStatistics_Season lpPitching, MlbPlayer mlbPlayer)
	{
		return (compareToPlayer_Hitting(lpBatting, mlbPlayer) + 
				compareToPlayer_Pitching(lpPitching, mlbPlayer)) / 2.0f;
	}
	
	/**
	 * Determines an overall score for a player with regards to hitting. Takes into
	 * account the player's batting average and slugging percentage.
	 * 
	 * @param lpStats
	 *            Local Player Batting model
	 * @param mlbPlayer
	 *            MLB Player model
	 * @return The player's Batting score.
	 */
	private static float compareToPlayer_Hitting(LocalPlayerBattingStatistics_Season lpStats, MlbPlayer mlbPlayer)
	{
		final float startScore = (11.f / 12.f) * 1000.0f;
		float score = startScore;
		
		if (mlbPlayer.getBatting_games_play() > 0 && lpStats != null)
		{
			float[] localScore = loadScores_Hitting(lpStats, mlbPlayer);
			
			if (localScore != null)
			{
				for (int i = 0; i < localScore.length; i++)
				{
					score -= returnDifference(localScore[i], mlbScore[i],
							differenceNums_Hitting[i]);
				}
			}
			else
			{
				score = 0;
			}
		}
		else
		{
			score = 0;
		}
		
		if (score < 0)
		{
			score = 0;
		}
		
		return (score / startScore);
	}
	
	/**
	 * Determines an overall score for a player with regards to pitching.
	 * 
	 * @param lpStats
	 *            Local Player Pitching model
	 * @param mlbPlayer
	 *            MLB Player model
	 * @return The player's Pitching score.
	 */
	private static float compareToPlayer_Pitching(LocalPlayerPitchingStatistics_Season lpStats, MlbPlayer mlbPlayer)
	{
		final float startScore = (6.f / 13.f) * 1000.0f;
		float score = startScore;
		
		if (mlbPlayer.getPitching_games_play() > 0 && lpStats != null)
		{
			float[] localScore = loadScores_Pitching(lpStats, mlbPlayer);
			if (localScore != null)
			{
				for (int i = 0; i < localScore.length; i++)
				{
					score -= returnDifference(localScore[i], mlbScore[i],
							differenceNums_Pitching[i]);
				}
			}
			else
			{
				score = 0;
			}
		}
		else
		{
			score = 0;
		}
		
		if (score < 0)
		{
			score = 0;
		}
		
		return (score / startScore);
	}
	
	/**
	 * Used to find the difference between any two given numbers.
	 * 
	 * @param firstNum
	 *            First number to be evaluated.
	 * @param secNum
	 *            Second number to be evaluated.
	 * @param differenceNum
	 *            Number that divides initial difference.
	 * @return Difference between the first and second number divided by the difference
	 *         number.
	 */
	private static float returnDifference(float firstNum, float secNum,
			float differenceNum)
	{
		float difference = Math.abs(firstNum - secNum);
		float remainder = (difference / differenceNum);
		return remainder;
	}
	
	/**
	 * Loads the Local Player statistics based on the selected local player's ID.
	 * Calculates the Local Player's batting average by dividing the number of hits the
	 * selected player has accumulated by the number of at bats they've had. Stores this
	 * information in an array as well as other relevant statistics.
	 * 
	 * @param lp
	 *            Local Player model
	 * @param mlbPlayer
	 *            MLB Player model
	 * @return An array with the local player's loaded statistics as well as the generated
	 *         statistics including hits, at bats, and batting average.
	 */
	private static float[] loadScores_Hitting(LocalPlayerBattingStatistics_Season lpStats, MlbPlayer mlbPlayer)
	{
		float[] localScore;
		
		//ArrayList<LocalPlayerBattingStatistics_Season> lpStatsBat = LocalPlayerBattingStatistics_Season
				//.getStatisticsFromDatabase(lp.getLocalPlayerId());
		//LocalPlayerBattingStatistics_Season lpStats = lpStatsBat.get(0);
		
		/*
		 * Generates batting average only if the selected player has at least 1 at bat.
		 * Divides the number of hits by the total at bats to find the player's batting
		 * average.
		 */
		float battingAverageLocal = 0.00f;
		if(lpStats != null){
		
			// Local Player Statistics
			float[] localScores = { lpStats.getBatting_game_play(),
				lpStats.getBatting_totals_ab(), lpStats.getBatting_totals_runs(),
				lpStats.getBatting_onbase_totals_h(),
				lpStats.getBatting_onbase_totals_d(),
				lpStats.getBatting_onbase_totals_t(),
				lpStats.getBatting_onbase_totals_hr(), lpStats.getBatting_totals_rbi(),
				lpStats.getBatting_totals_outs_k(),
				lpStats.getBatting_steal_totals_stolen(),
				lpStats.getBattingAverage(),
				lpStats.getSlugging()};
			localScore = localScores;

		}
		else{
			localScore = null;
		}
		
		// MLB Player Statistics
		float[] mlbScores = { mlbPlayer.getBatting_games_play(),
				mlbPlayer.getBatting_ab(), mlbPlayer.getBatting_runs_total(),
				mlbPlayer.getBatting_onbase_h(), mlbPlayer.getBatting_onbase_d(),
				mlbPlayer.getBatting_onbase_t(), mlbPlayer.getBatting_onbase_hr(),
				mlbPlayer.getBatting_rbi(), mlbPlayer.getBatting_outs_ktotal(),
				mlbPlayer.getBatting_steal_stolen(),
				mlbPlayer.getBattingAverage(),
				mlbPlayer.getSlugging()};
		mlbScore = mlbScores;
		
		return localScore;
	}
	
	/**
	 * Loads the Local Player statistics based on the selected local player's ID. Stores
	 * this information in an array as well as other relevant statistics including wins,
	 * losses, and ERA.
	 * 
	 * @param lp
	 *            Local Player model
	 * @param mlbPlayer
	 *            MLB Player model
	 * @return An array with the local player's loaded statistics pertaining to pitching.
	 */
	private static float[] loadScores_Pitching(LocalPlayerPitchingStatistics_Season lpStats, MlbPlayer mlbPlayer)
	{
		float[] localScore;
		
		//ArrayList<LocalPlayerPitchingStatistics_Season> lpStatsList = LocalPlayerPitchingStatistics_Season
		//		.getStatisticsFromDatabase(lp.getLocalPlayerId());
		//LocalPlayerPitchingStatistics_Season lpStats = lpStatsList.get(0);
		
		if(lpStats != null){

			// Local Player statistics
			float[] localScores = { lpStats.getPitching_games_won(),
				lpStats.getPitching_games_loss(),
				(lpStats.getPitching_games_won() / lpStats.getPitching_games_play()),
				lpStats.getPitching_totals_era(), lpStats.getPitching_games_play(),
				lpStats.getPitching_games_totals_hit() };
			localScore = localScores;
		}
		else{
			localScore = null;
		}
		
		// MLB Player statistics
		float[] mlbScores = { mlbPlayer.getPitching_games_win(),
				mlbPlayer.getPitching_games_loss(),
				(mlbPlayer.getPitching_games_win() / mlbPlayer.getPitching_games_play()),
				mlbPlayer.getPitching_era(), mlbPlayer.getPitching_games_play(),
				mlbPlayer.getPitching_onbase_h() };
		mlbScore = mlbScores;
		
		return localScore;
	}
}
