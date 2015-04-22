package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Compiles all statistics related to the fielding category that a player accumulated over
 * a season.
 * 
 * @author SerSports
 */
public class localPlayerFieldingStatistics_Season
{
	
	/*
	 * All statistics related to fielding
	 */
	private static final String TABLE_NAME = "localplayersfieldingstatistics_season";
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_FIELDING_GAME_PLAY = "fielding_game_play";
	private static final String FIELD_FIELDING_GAME_WON = "fielding_game_won";
	private static final String FIELD_FIELDING_GAME_LOSS = "fielding_game_loss";
	private static final String FIELD_FIELDING_TOTALS_PO = "fielding_totals_po";
	private static final String FIELD_FIELDING_TOTALS_ERROR = "fielding_totals_error";
	private static final String FIELD_FIELDING_TOTALS_ASSIST = "fielding_totals_assist";
	private static final String FIELD_FIELDING_TOTALS_FPCT = "fielding_totals_fpct";
	
	private int localPlayersFieldingStatisticsID; // Identifier used to track the
													// currently selected statistic
	private int localPlayerId; // Identifier used to track all local players
	private int fielding_totals_po; // Put-outs
	private int fielding_totals_error; // Errors
	private int fielding_totals_assist; // Assists
	private float fielding_totals_fpct; // Fielding Percentage
	private int fielding_games_play; // Games Played
	private int fielding_games_won; // Games Won
	private int fielding_games_loss; // Games Lost
	
	public int getLocalPlayersFieldingStatisticsID()
	{
		return localPlayersFieldingStatisticsID;
	}
	
	public int getLocalPlayerId()
	{
		return localPlayerId;
	}
	
	public int getFielding_totals_po()
	{
		return fielding_totals_po;
	}
	
	public int getFielding_totals_error()
	{
		return fielding_totals_error;
	}
	
	public int getFielding_totals_assist()
	{
		return fielding_totals_assist;
	}
	
	public float getFielding_totals_fpct()
	{
		return fielding_totals_fpct;
	}
	
	public int getFielding_game_play()
	{
		return fielding_games_play;
	}
	
	public int getFielding_games_won()
	{
		return fielding_games_won;
	}
	
	public int getFielding_games_loss()
	{
		return fielding_games_loss;
	}
	
	/**
	 * Loads information from the Result Set that has queried data from the database
	 * relevant to the characteristics of a local player's fielding statistics over the
	 * span of a season.
	 * 
	 * @param rs
	 *            Used to get information from the database.
	 */
	private localPlayerFieldingStatistics_Season(ResultSet rs)
	{
		try
		{
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID);
			this.fielding_totals_po = rs.getInt(FIELD_FIELDING_TOTALS_PO);
			this.fielding_totals_error = rs.getInt(FIELD_FIELDING_TOTALS_ERROR);
			this.fielding_totals_assist = rs.getInt(FIELD_FIELDING_TOTALS_ASSIST);
			this.fielding_totals_fpct = rs.getFloat(FIELD_FIELDING_TOTALS_FPCT);
			this.fielding_games_play = rs.getInt(FIELD_FIELDING_GAME_PLAY);
			this.fielding_games_won = rs.getInt(FIELD_FIELDING_GAME_WON);
			this.fielding_games_loss = rs.getInt(FIELD_FIELDING_GAME_LOSS);
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
	public static ArrayList<localPlayerFieldingStatistics_Season> getStatisticsFromDatabase(
			int localPlayerId)
	{
		ArrayList<localPlayerFieldingStatistics_Season> resultList = new ArrayList<localPlayerFieldingStatistics_Season>();
		
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_LOCAL_PLAYER_ID
				+ " = " + localPlayerId;
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		if (rs != null)
		{
			try
			{
				while (rs.next())
				{
					localPlayerFieldingStatistics_Season player = new localPlayerFieldingStatistics_Season(
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
			Integer.parseInt(value);
		}
		catch (NumberFormatException ex)
		{
			return true;
		}
		
		return false;
	}
	
}
