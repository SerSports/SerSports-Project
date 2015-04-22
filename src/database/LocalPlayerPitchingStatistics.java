package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Compiles all statistics related to the pitching category that a player accumulated in
 * general.
 * 
 * @author SerSports
 */
public class LocalPlayerPitchingStatistics
{
	
	/*
	 * All statistics related to pitching.
	 */
	private static final String TABLE_NAME = "localplayerspitchingstatistics";
	private static final String FIELD_ID = "localPlayersPitchingStatisticsID";
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_TEAM_NAME = "team_name";
	private static final String FIELD_POSITION = "position";
	private static final String FIELD_GAME_DATE = "game_date";
	private static final String FIELD_PITCHING_GAME_WON = "pitching_game_won";
	private static final String FIELD_PITCHING_ERA = "pitching_era";
	private static final String FIELD_PITCHING_GAMES_SAVE = "pitching_games_save";
	private static final String FIELD_PITCHING_GAMES_HIT = "pitching_games_hit";
	private static final String FIELD_PITCHING_GAMES_HOLD = "pitching_games_hold";
	private static final String FIELD_PITCHING_RUNS = "pitching_runs";
	private static final String FIELD_PITCHING_HBP = "pitching_hbp";
	
	private int localPlayersPitchingStatisticsID; // Identifier used to track the
													// currently selected statistic
	private int localPlayerId; // Identifier used to track all local players
	private String team_name; // Team's name
	private String position; // Player's position
	private String game_date; // Date Of Game
	private int pitching_game_won; // Games Won
	private float pitching_era; // Earned Run Average
	private int pitching_games_save; // Saves
	private int pitching_games_hit; // Hits Given Up
	private int pitching_games_hold; // Holds
	private int pitching_runs; // Runs Given Up
	private int pitching_hbp; // Batters Hit By Pitch
	
	public int getLocalPlayersPitchingStatisticsID()
	{
		return localPlayersPitchingStatisticsID;
	}
	
	public int getLocalPlayerId()
	{
		return localPlayerId;
	}
	
	public String getTeam_name()
	{
		return team_name;
	}
	
	public String getPosition()
	{
		return position;
	}
	
	public String getGame_date()
	{
		return game_date;
	}
	
	public float getPitching_era()
	{
		return pitching_era;
	}
	
	public int getPitching_runs()
	{
		return pitching_runs;
	}
	
	public int getPitching_game_won()
	{
		return pitching_game_won;
	}
	
	public int getPitching_games_save()
	{
		return pitching_games_save;
	}
	
	public int getPitching_games_hold()
	{
		return pitching_games_hold;
	}
	
	public int getPitching_games_hit()
	{
		return pitching_games_hit;
	}
	
	public int getPitching_hbp()
	{
		return pitching_hbp;
	}
	
	/**
	 * Loads information from the Result Set that has queried data from the database
	 * relevant to the characteristics of a local player's pitching statistics in general.
	 * 
	 * @param rs
	 *            Used to get information from the database.
	 */
	private LocalPlayerPitchingStatistics(ResultSet rs)
	{
		try
		{
			this.localPlayersPitchingStatisticsID = rs.getInt(FIELD_ID);
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID);
			this.team_name = rs.getString(FIELD_TEAM_NAME);
			this.position = rs.getString(FIELD_POSITION);
			this.game_date = rs.getString(FIELD_GAME_DATE);
			this.pitching_era = rs.getFloat(FIELD_PITCHING_ERA);
			this.pitching_runs = rs.getInt(FIELD_PITCHING_RUNS);
			this.pitching_game_won = rs.getInt(FIELD_PITCHING_GAME_WON);
			this.pitching_games_save = rs.getInt(FIELD_PITCHING_GAMES_SAVE);
			this.pitching_games_hold = rs.getInt(FIELD_PITCHING_GAMES_HOLD);
			this.pitching_games_hit = rs.getInt(FIELD_PITCHING_GAMES_HIT);
			this.pitching_hbp = rs.getInt(FIELD_PITCHING_HBP);
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
	public static ArrayList<LocalPlayerPitchingStatistics> getStatisticsFromDatabase(
			int localPlayerId)
	{
		ArrayList<LocalPlayerPitchingStatistics> resultList = new ArrayList<LocalPlayerPitchingStatistics>();
		
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_LOCAL_PLAYER_ID
				+ " = " + localPlayerId + " ORDER BY " + FIELD_GAME_DATE + " DESC";
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		if (rs != null)
		{
			try
			{
				while (rs.next())
				{
					LocalPlayerPitchingStatistics player = new LocalPlayerPitchingStatistics(
							rs);
					resultList.add(player);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		// Clean up
		Database.close();
		
		return resultList;
	}
	
	/**
	 * Adds all of the local player's pitching statistics to a table and parses strings
	 * when applicable.
	 * 
	 * @param date
	 *            Current Date
	 * @param won
	 *            True if won, False if lost
	 * @param era
	 *            Earned Run Average
	 * @param saves
	 *            Saves
	 * @param hits
	 *            Hits Given Up
	 * @param holds
	 *            Holds
	 * @param runs
	 *            Runs Given Up
	 * @param hbp
	 *            Batters Hit By Pitch
	 * @param statsID
	 *            Identifier used to determine if the list is being initially inserted
	 *            into or updated
	 */
	public static void addOrUpdateLocalPlayerPitchingStatistics(String date, Boolean won,
			String era, String saves, String hits, String holds, String runs, String hbp,
			int statsID)
	{
		
		int iwon, isaves, ihits, iholds, iruns, ihbp;
		float iera;
		try
		{
			if (won)
				iwon = 1;
			else
				iwon = 0;
			iera = parseToFloat(era);
			isaves = parseToInt(saves);
			ihits = parseToInt(hits);
			iholds = parseToInt(holds);
			iruns = parseToInt(runs);
			ihbp = parseToInt(hbp);
			
			User currentUser = User.getCurrentUser();
			
			if (statsID == -1)
			{
				Database.executeSQL("INSERT INTO " + TABLE_NAME + "("
						+ FIELD_LOCAL_PLAYER_ID + ", " + FIELD_GAME_DATE + ", "
						+ FIELD_PITCHING_ERA + ", " + FIELD_PITCHING_GAMES_SAVE + ", "
						+ FIELD_PITCHING_GAMES_HIT + ", " + FIELD_PITCHING_GAMES_HOLD
						+ ", " + FIELD_PITCHING_RUNS + ", " + FIELD_PITCHING_HBP + ", "
						+ FIELD_PITCHING_GAME_WON + ") " + "VALUES (\""
						+ currentUser.getLocalPlayerId() + "\", " + "\"" + date + "\", "
						+ "\"" + iera + "\", " + "\"" + isaves + "\", " + "\"" + ihits
						+ "\", " + "\"" + iholds + "\", " + "\"" + iruns + "\", " + "\""
						+ ihbp + "\", " + "\"" + iwon + "\");");
			}
			else
			{
				Database.executeSQL("UPDATE " + TABLE_NAME + " SET " + FIELD_GAME_DATE
						+ " = \"" + date + "\", " + FIELD_PITCHING_ERA + " = \"" + iera
						+ "\", " + FIELD_PITCHING_GAMES_SAVE + " = \"" + isaves + "\", "
						+ FIELD_PITCHING_GAMES_HIT + " = \"" + ihits + "\", "
						+ FIELD_PITCHING_GAMES_HOLD + " = \"" + iholds + "\", "
						+ FIELD_PITCHING_RUNS + " = \"" + iruns + "\", "
						+ FIELD_PITCHING_HBP + " = \"" + ihbp + "\", "
						+ FIELD_PITCHING_GAME_WON + " = \"" + iwon + "\"" + " WHERE "
						+ FIELD_ID + " = \"" + statsID + "\";");
			}
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/**
	 * Removes the selected statistic from the table.
	 * 
	 * @param localPlayerPitchingStatisticID
	 *            Statistic that the user is in question of deleting.
	 */
	public static void deleteLocalPlayerPitchingStatistic(
			int localPlayerPitchingStatisticID)
	{
		Database.executeSQL("DELETE FROM " + TABLE_NAME + " WHERE " + FIELD_ID + " = "
				+ localPlayerPitchingStatisticID + ";");
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
	
	/**
	 * @param value
	 *            The String value being assessed.
	 * @return An integer parsed from a String if the value is not already numeric and 0
	 *         if it is.
	 */
	public static int parseToInt(String value)
	{
		int result;
		if (notNumeric(value) != true)
			result = Integer.parseInt(value);
		else
			result = 0;
		return result;
	}
	
	/**
	 * @param value
	 *            The String value being assessed.
	 * @return A float parsed from a String if the value is not already numeric and 0 if
	 *         it is.
	 */
	public static float parseToFloat(String value)
	{
		return Float.parseFloat(value);
	}
}
