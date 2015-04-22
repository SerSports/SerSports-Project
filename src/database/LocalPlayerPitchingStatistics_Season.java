package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Compiles all statistics related to the pitching category that a player accumulated over
 * a season.
 * 
 * @author SerSports
 */
public class LocalPlayerPitchingStatistics_Season
{
	
	/*
	 * All statistics related to pitching.
	 */
	private static final String TABLE_NAME = "localplayerspitchingstatistics_season";
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_PITCHING_GAME_PLAY = "pitching_games_play";
	private static final String FIELD_PITCHING_GAME_WON = "pitching_games_won";
	private static final String FIELD_PITCHING_GAME_LOSS = "pitching_games_loss";
	private static final String FIELD_PITCHING_TOTALS_ERA = "pitching_totals_era";
	private static final String FIELD_PITCHING_GAMES_TOTALS_SAVE = "pitching_games_totals_save";
	private static final String FIELD_PITCHING_GAMES_TOTALS_HIT = "pitching_games_totals_hit";
	private static final String FIELD_PITCHING_GAMES_TOTALS_HOLD = "pitching_games_totals_hold";
	private static final String FIELD_PITCHING_TOTALS_RUNS = "pitching_totals_runs";
	private static final String FIELD_PITCHING_TOTALS_HBP = "pitching_totals_hbp";
	
	private int localPlayerId; // Identifier used to track all local players
	private int pitching_games_play; // Games Played
	private int pitching_games_won; // Games Won
	private int pitching_games_loss; // Games Lost
	private float pitching_totals_era; // Earned Run Average
	private int pitching_games_totals_save; // Saves
	private int pitching_games_totals_hit; // Hits Given Up
	private int pitching_games_totals_hold; // Holds
	private int pitching_totals_runs; // Runs Given Up
	private int pitching_totals_hbp; // Batters Hit By Pitch
	
	public int getLocalPlayerId()
	{
		return localPlayerId;
	}
	
	public float getPitching_totals_era()
	{
		return pitching_totals_era;
	}
	
	public int getPitching_totals_runs()
	{
		return pitching_totals_runs;
	}
	
	public int getPitching_games_play()
	{
		return pitching_games_play;
	}
	
	public int getPitching_games_won()
	{
		return pitching_games_won;
	}
	
	public int getPitching_games_loss()
	{
		return pitching_games_loss;
	}
	
	public int getPitching_games_totals_save()
	{
		return pitching_games_totals_save;
	}
	
	public int getPitching_games_totals_hold()
	{
		return pitching_games_totals_hold;
	}
	
	public int getPitching_games_totals_hit()
	{
		return pitching_games_totals_hit;
	}
	
	public int getPitching_totals_hbp()
	{
		return pitching_totals_hbp;
	}
	
	/**
	 * Loads information from the Result Set that has queried data from the database
	 * relevant to the characteristics of a local player's pitching statistics over the
	 * span of a season.
	 * 
	 * @param rs
	 *            Used to get information from the database.
	 */
	private LocalPlayerPitchingStatistics_Season(ResultSet rs)
	{
		try
		{
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID);
			this.pitching_totals_era = rs.getFloat(FIELD_PITCHING_TOTALS_ERA);
			this.pitching_totals_runs = rs.getInt(FIELD_PITCHING_TOTALS_RUNS);
			this.pitching_games_play = rs.getInt(FIELD_PITCHING_GAME_PLAY);
			this.pitching_games_won = rs.getInt(FIELD_PITCHING_GAME_WON);
			this.pitching_games_loss = rs.getInt(FIELD_PITCHING_GAME_LOSS);
			this.pitching_games_totals_save = rs.getInt(FIELD_PITCHING_GAMES_TOTALS_SAVE);
			this.pitching_games_totals_hold = rs.getInt(FIELD_PITCHING_GAMES_TOTALS_HOLD);
			this.pitching_games_totals_hit = rs.getInt(FIELD_PITCHING_GAMES_TOTALS_HIT);
			this.pitching_totals_hbp = rs.getInt(FIELD_PITCHING_TOTALS_HBP);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Obtains a result set containing every player and then loops through the result set
	 * and adds each player to an array list.
	 * 
	 * @param localPlayerId
	 *            Identifier used for all local players.
	 * @return Array list consisting of all generated players from the result set.
	 */
	public static ArrayList<LocalPlayerPitchingStatistics_Season> getStatisticsFromDatabase(
			int localPlayerId)
	{
		ArrayList<LocalPlayerPitchingStatistics_Season> resultList = new ArrayList<LocalPlayerPitchingStatistics_Season>();
		
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_LOCAL_PLAYER_ID
				+ " = " + localPlayerId;
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		if (rs != null)
		{
			try
			{
				while (rs.next())
				{
					LocalPlayerPitchingStatistics_Season player = new LocalPlayerPitchingStatistics_Season(
							rs);
					resultList.add(player);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		Database.close();
		
		return resultList;
	}
	
	/**
	 * @param value
	 *            The String value being assessed.
	 * @return The status of the value being checked: evaluates to false if the value is
	 *         numeric and true if the contrary.
	 */
	private static boolean notNumeric(String value)
	{
		
		try
		{
			int number = Integer.parseInt(value);
			
		}
		catch (NumberFormatException ex)
		{
			return true;
		}
		
		return false;
	}
}
