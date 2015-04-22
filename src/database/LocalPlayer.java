package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Contains all components of a local player and calls from a separate database to obtain
 * said components. Appends a list of local players when necessary.
 * 
 * @author SerSports
 */
public class LocalPlayer
{
	
	private static final String TABLE_NAME = "localplayers";
	private static final String FIELD_ID = "localPlayerId";
	private static final String FIELD_FIRST_NAME = "firstName";
	private static final String FIELD_LAST_NAME = "lastName";
	private static final String FIELD_AGE = "age";
	private static final String FIELD_TEAM_NAME = "team_name";
	
	private int localPlayerId;
	private String firstName;
	private String lastName;
	private int age;
	private String teamName;
	
	public int getLocalPlayerId()
	{
		return localPlayerId;
	}
	
	public void setLocalPlayerId(int localPlayerId)
	{
		this.localPlayerId = localPlayerId;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String getTeamName()
	{
		return teamName;
	}
	
	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}
	
	/**
	 * Loads information from the Result Set that has queried data from the database
	 * relevant to the characteristics of a local player.
	 * 
	 * @param rs
	 *            Used to get information from the database.
	 */
	private LocalPlayer(ResultSet rs)
	{
		try
		{
			this.localPlayerId = rs.getInt(FIELD_ID);
			this.firstName = rs.getString(FIELD_FIRST_NAME);
			this.lastName = rs.getString(FIELD_LAST_NAME);
			this.age = rs.getInt(FIELD_AGE);
			this.teamName = rs.getString(FIELD_TEAM_NAME);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates a new local player, finds them, and then creates a new object of them.
	 * 
	 * @param firstName
	 *            Local player's first name.
	 * @param lastName
	 *            Local player's last name.
	 * @param age
	 *            Local player's age.
	 * @param teamName
	 *            Local player's team name.
	 * @return A local player object with a first name, last name, age, and team name.
	 */
	public static LocalPlayer newLocalPlayer(String firstName, String lastName, int age,
			String teamName)
	{
		LocalPlayer result = null;
		
		Database.executeSQL(buildInsertSql(firstName, lastName, age, teamName));
		
		String sql = "SELECT * FROM " + TABLE_NAME
				+ genereateWhereClause(0, firstName, lastName, age, teamName)
				+ " ORDER BY " + FIELD_ID + " DESC";
		ResultSet resultSet = Database.getResultSetFromSQL(sql);
		
		if (resultSet != null)
		{
			try
			{
				if (resultSet.next())
				{
					result = new LocalPlayer(resultSet);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		Database.close();
		
		return result;
	}
	
	private static String buildInsertSql(String firstName, String lastName, int age,
			String teamName)
	{
		return new String("INSERT INTO " + TABLE_NAME + "(" + FIELD_FIRST_NAME + ", "
				+ FIELD_LAST_NAME + ", " + FIELD_AGE + ", " + FIELD_TEAM_NAME + ") "
				+ "VALUES(" + Database.formatSqlStringValueForInsert(firstName) + ", "
				+ Database.formatSqlStringValueForInsert(lastName) + ", " + age + ", "
				+ Database.formatSqlStringValueForInsert(teamName) + ")");
	}
	
	/**
	 * @param id_in
	 *            Checks to see if anything was passed into the player ID field.
	 * @param firstName_in
	 *            Checks to see if anything was passed into the first name field.
	 * @param lastName_in
	 *            Checks to see if anything was passed into the last name field.
	 * @param age_in
	 *            Checks to see if anything was passed into the age field.
	 * @param teamName_in
	 *            Checks to see if anything was passed into the team name field.
	 * @return A string containing this information.
	 */
	private static String genereateWhereClause(int id_in, String firstName_in,
			String lastName_in, int age_in, String teamName_in)
	{
		StringBuilder whereClause = new StringBuilder();
		
		if (id_in > 0 || firstName_in != null || lastName_in != null || age_in > 0
				|| teamName_in != null)
		{
			Boolean fieldsAdded = false;
			
			whereClause.append(" WHERE ");
			
			if (id_in > 0)
			{
				whereClause.append(FIELD_ID + " = " + id_in);
				fieldsAdded = true;
			}
			if (firstName_in != null)
			{
				if (fieldsAdded)
				{
					whereClause.append(" AND ");
				}
				
				whereClause.append(FIELD_FIRST_NAME + " = \"" + firstName_in + "\"");
				fieldsAdded = true;
			}
			if (lastName_in != null)
			{
				if (fieldsAdded)
				{
					whereClause.append(" AND ");
				}
				whereClause.append(FIELD_LAST_NAME + " = \"" + lastName_in + "\"");
				fieldsAdded = true;
			}
			if (age_in > 0)
			{
				if (fieldsAdded)
				{
					whereClause.append(" AND ");
				}
				whereClause.append(FIELD_AGE + " = " + age_in);
				fieldsAdded = true;
			}
			if (teamName_in != null)
			{
				if (fieldsAdded)
				{
					whereClause.append(" AND ");
				}
				
				whereClause.append(FIELD_TEAM_NAME + " = \"" + teamName_in + "\"");
				fieldsAdded = true;
			}
		}
		return whereClause.toString();
	}
	
	/**
	 * Runs through the Result Set and adds each MLB player to the list that is to be
	 * returned.
	 * 
	 * @return List containing MLB players.
	 */
	public static ArrayList<LocalPlayer> getPlayersFromDatabase(int id_in,
			String fName_in, String lName_in, int age_in, String team_in)
	{
		ArrayList<LocalPlayer> resultList = new ArrayList<LocalPlayer>();
		
		String sql = "SELECT * FROM " + TABLE_NAME
				+ genereateWhereClause(id_in, fName_in, lName_in, 0, team_in)
				+ " ORDER BY " + FIELD_TEAM_NAME + ", " + FIELD_FIRST_NAME + ", "
				+ FIELD_LAST_NAME;
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		if (rs != null)
		{
			try
			{
				while (rs.next())
				{
					LocalPlayer player = new LocalPlayer(rs);
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
	 * Runs through the Result Set and adds each local player to the list that is to be
	 * returned.
	 * 
	 * @return List containing MLB players.
	 */
	public static ArrayList<LocalPlayer> getLocalPlayersStatisticsFromDatabase(int id_in)
	{
		ArrayList<LocalPlayer> resultList = new ArrayList<LocalPlayer>();
		
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_ID + " = \""
				+ id_in + "\"" + " ORDER BY " + FIELD_ID;
		ResultSet resultSet = Database.getResultSetFromSQL(sql);
		
		if (resultSet != null)
		{
			try
			{
				while (resultSet.next())
				{
					LocalPlayer player = new LocalPlayer(resultSet);
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
	 * Used to return a list of local players given that they're available.
	 * 
	 * @param id
	 *            Player ID used to reference them.
	 * @return List of players if the criteria is met.
	 */
	public static LocalPlayer getLocalPlayerForId(int id)
	{
		LocalPlayer result = null;
		
		ArrayList<LocalPlayer> playerList = LocalPlayer.getPlayersFromDatabase(id, null,
				null, 0, null);
		if (playerList.size() > 0)
		{
			result = playerList.get(0);
		}
		
		return result;
	}
}
