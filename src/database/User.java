package database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Object used to handle authentication of user's credentials
 * 
 * @author SerSports
 */
public class User
{
	
	private static User currentUser = null;
	
	private static final String TABLE_NAME = "users";
	private static final String FIELD_ID = "userId";
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_USER_NAME = "userName";
	private static final String FIELD_PASSWORD = "password";
	
	private int userId;
	private int localPlayerId;
	private String userName;
	private String password;
	
	public int getLocalPlayerId()
	{
		return localPlayerId;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public static User getCurrentUser()
	{
		return currentUser;
	}
	
	public static String getTableName()
	{
		return TABLE_NAME;
	}
	
	public static String getFieldUserName()
	{
		return FIELD_USER_NAME;
	}
	
	/**
	 * Loads information from the Result Set that has queried data from the database
	 * relevant to the characteristics of an user
	 * 
	 * @param rs
	 *            Used to get information from the database.
	 */
	private User(ResultSet rs)
	{
		try
		{
			this.userId = rs.getInt(FIELD_ID);
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID);
			this.userName = rs.getString(FIELD_USER_NAME);
			this.password = rs.getString(FIELD_PASSWORD);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Searches for the user in the database based on the credentials they provided
	 * 
	 * @param userName
	 *            User name entered
	 * @param password
	 *            Password entered
	 * @return A new User object that is in current use
	 */
	public static User authenticateUser(String userName, String password)
	{
		User result = null;
		
		ResultSet rs = Database.getResultSetFromSQL("SELECT * FROM " + TABLE_NAME + " "
				+ "WHERE " + FIELD_USER_NAME + " = \"" + userName + "\" AND "
				+ FIELD_PASSWORD + " = \"" + password + "\"");
		
		if (rs != null)
		{
			try
			{
				if (rs.next())
				{
					result = new User(rs);
					currentUser = result;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 * Creates a local player and then a user and then finds the newly created local
	 * player and makes a local player object
	 * 
	 * @param userName
	 *            User name entered
	 * @param password
	 *            Password entered
	 * @param firstName
	 *            First name of user
	 * @param lastName
	 *            Last name of user
	 * @param age
	 *            Age of user
	 * @param teamName
	 *            Team name of user
	 * @return Newly created local player object
	 */
	public static User newUser(String userName, String password, String firstName,
			String lastName, int age, String teamName)
	{
		User result = null;
		
		LocalPlayer player = LocalPlayer.newLocalPlayer(firstName, lastName, age,
				teamName);
		
		Database.executeSQL(buildInsertSql(player.getLocalPlayerId(), userName, password));
		
		ResultSet rs = Database.getResultSetFromSQL("SELECT * FROM " + TABLE_NAME
				+ " WHERE " + FIELD_USER_NAME + " = \"" + userName + "\"");
		
		if (rs != null)
		{
			try
			{
				if (rs.next())
				{
					result = new User(rs);
					currentUser = result;
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
	
	/**
	 * @param localPlayerId
	 *            Identifier assigned to Local Player
	 * @param userName
	 *            User name entered
	 * @param password
	 *            Password entered
	 * @return String of inserted values
	 */
	private static String buildInsertSql(int localPlayerId, String userName,
			String password)
	{
		return new String("INSERT INTO " + TABLE_NAME + " (" + FIELD_LOCAL_PLAYER_ID
				+ ", " + FIELD_USER_NAME + ", " + FIELD_PASSWORD + ") " + "VALUES("
				+ localPlayerId + ", \"" + userName + "\", \"" + password + "\")");
	}
	
	/**
	 * @return Current user's local player Id
	 */
	public static LocalPlayer getCurrentLocalPlayer()
	{
		return LocalPlayer.getLocalPlayerForId(currentUser.localPlayerId);
	}
}
