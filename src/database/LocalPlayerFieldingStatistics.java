package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Compiles all statistics related to the fielding category that a player accumulated in
 * general.
 * 
 * @author SerSports
 */
public class LocalPlayerFieldingStatistics
{
	
	private static final String TABLE_NAME = "localplayersfieldingstatistics";
	private static final String FIELD_ID = "localPlayersFieldingStatisticsID";
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_TEAM_NAME = "team_name";
	private static final String FIELD_POSITION = "position";
	private static final String FIELD_GAME_DATE = "game_date";
	private static final String FIELD_FIELDING_PO = "fielding_po";
	private static final String FIELD_FIELDING_ERROR = "fielding_error";
	private static final String FIELD_FIELDING_ASSIST = "fielding_assist";
	private static final String FIELD_FIELDING_FPCT = "fielding_fpct";
	private static final String FIELD_FIELDING_GAME_WON = "fielding_game_won";
	
	private int localPlayersFieldingStatisticsID; // Identifier used to track the
													// currently selected statistic
	private int localPlayerId; // Identifier used to track all local players
	private String team_name; // Team's name
	private String position; // Player's position
	private String game_date; // Date Of Game
	private int fielding_po; // Put-outs
	private int fielding_error; // Errors
	private int fielding_assist; // Assists
	private float fielding_fpct; // Fielding Percentage
	private int fielding_game_won; // Games Won
	
	public int getLocalPlayersFieldingStatisticsID()
	{
		return localPlayersFieldingStatisticsID;
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
	
	public int getFielding_po()
	{
		return fielding_po;
	}
	
	public int getFielding_error()
	{
		return fielding_error;
	}
	
	public int getFielding_assist()
	{
		return fielding_assist;
	}
	
	public float getFielding_fpct()
	{
		return fielding_fpct;
	}
	
	public int getFielding_game_won()
	{
		return fielding_game_won;
	}
	
	/**
	 * Loads information from the Result Set that has queried data from the database
	 * relevant to the characteristics of a local player's fielding statistics in general.
	 * 
	 * @param rs
	 *            Used to get information from the database.
	 */
	private LocalPlayerFieldingStatistics(ResultSet rs)
	{
		try
		{
			this.localPlayersFieldingStatisticsID = rs.getInt(FIELD_ID);
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID);
			this.team_name = rs.getString(FIELD_TEAM_NAME);
			this.position = rs.getString(FIELD_POSITION);
			this.game_date = rs.getString(FIELD_GAME_DATE);
			this.fielding_po = rs.getInt(FIELD_FIELDING_PO);
			this.fielding_error = rs.getInt(FIELD_FIELDING_ERROR);
			this.fielding_assist = rs.getInt(FIELD_FIELDING_ASSIST);
			this.fielding_fpct = rs.getFloat(FIELD_FIELDING_FPCT);
			this.fielding_game_won = rs.getInt(FIELD_FIELDING_GAME_WON);
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
	public static ArrayList<LocalPlayerFieldingStatistics> getStatisticsFromDatabase(
			int localPlayerId)
	{
		ArrayList<LocalPlayerFieldingStatistics> resultList = new ArrayList<LocalPlayerFieldingStatistics>();
		
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_LOCAL_PLAYER_ID
				+ " = " + localPlayerId + " ORDER BY " + FIELD_GAME_DATE + " DESC";
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		if (rs != null)
		{
			try
			{
				while (rs.next())
				{
					LocalPlayerFieldingStatistics player = new LocalPlayerFieldingStatistics(
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
	 * Adds all of the local player's fielding statistics to a table and parses strings
	 * when applicable.
	 * 
	 * @param date
	 *            Current Date
	 * @param won
	 *            True if won, False if lost
	 * @param po
	 *            Put-outs
	 * @param error
	 *            Errors
	 * @param assist
	 *            Assists
	 * @param fpct
	 *            Fielding Percentage
	 * @param statsID
	 *            Identifier used to determine if the list is being initially inserted
	 *            into or updated
	 */
	public static void addOrUpdateLocalPlayerFieldingStatistics(String date, Boolean won,
			String po, String error, String assist, String fpct, int statsID)
	{
		
		int iwon, ipo, ierror, iassist;
		float ifpct;
		try
		{
			if (won)
				iwon = 1;
			else
				iwon = 0;
			ipo = parseToInt(po);
			ierror = parseToInt(error);
			iassist = parseToInt(assist);
			ifpct = parseToFloat(fpct);
			
			User currentUser = User.getCurrentUser();
			
			if (statsID == -1)
			{
				Database.executeSQL("INSERT INTO " + TABLE_NAME + "("
						+ FIELD_LOCAL_PLAYER_ID + ", " + FIELD_GAME_DATE + ", "
						+ FIELD_FIELDING_PO + ", " + FIELD_FIELDING_ERROR + ", "
						+ FIELD_FIELDING_ASSIST + ", " + FIELD_FIELDING_FPCT + ", "
						+ FIELD_FIELDING_GAME_WON + ") " + "VALUES (\""
						+ currentUser.getLocalPlayerId() + "\", " + "\"" + date + "\", "
						+ "\"" + ipo + "\", " + "\"" + ierror + "\", " + "\"" + iassist
						+ "\", " + "\"" + ifpct + "\", " + "\"" + iwon + "\");");
			}
			else
			{
				Database.executeSQL("UPDATE " + TABLE_NAME + " SET " + FIELD_GAME_DATE
						+ " = \"" + date + "\", " + FIELD_FIELDING_PO + " = \"" + ipo
						+ "\", " + FIELD_FIELDING_ERROR + " = \"" + ierror + "\", "
						+ FIELD_FIELDING_ASSIST + " = \"" + iassist + "\", "
						+ FIELD_FIELDING_FPCT + " = \"" + ifpct + "\", "
						+ FIELD_FIELDING_GAME_WON + " = \"" + iwon + "\"" + " WHERE "
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
	 * @param localPlayerFieldingStatisticID
	 *            Statistic that the user is in question of deleting.
	 */
	public static void deleteLocalPlayerFieldingStatistic(
			int localPlayerFieldingStatisticID)
	{
		Database.executeSQL("DELETE FROM " + TABLE_NAME + " WHERE " + FIELD_ID + " = "
				+ localPlayerFieldingStatisticID + ";");
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
