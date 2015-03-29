package database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class:	MLBPlayer

Description: User Object, handles user authentication
*/
public class User {
	
	private static User currentUser = null;
	
	// Constants
	private static final String TABLE_NAME = "users";  
	private static final String FIELD_ID = "userId"; 
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId"; 
	private static final String FIELD_USER_NAME = "userName"; 
	private static final String FIELD_PASSWORD = "password";
	
	// Members
	private int userId;
	private int localPlayerId; 
	private String userName; 
	private String password; 
	
	// Getters / Setters
	public int getLocalPlayerId() {
		return localPlayerId;
	}
	
	public static User getCurrentUser() {
		return currentUser;
	}
	
	/**
	  Method: Constructor
	  Inputs: ResultSet rs
	  Returns:

	  Description: 
	*/
	private User(ResultSet rs) {
		try {
			// Load the rs's information
			this.userId = rs.getInt(FIELD_ID);
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID);
			this.userName = rs.getString(FIELD_USER_NAME);
			this.password = rs.getString(FIELD_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static User authenticateUser(String userName, String password) {
		User result = null;
		
		// See if we can find the requested user
		ResultSet rs = Database.getResultSetFromSQL("SELECT * FROM " + TABLE_NAME + " " + 
													"WHERE " + FIELD_USER_NAME + " = \"" + userName + "\" AND " + 
															   FIELD_PASSWORD + " = \"" + password + "\"");
		
		// User found?
		if (rs != null) {
			try {
				if (rs.next()){
					result = new User(rs);
					currentUser = result;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	public static User newUser(String userName, String password, String firstName, String lastName, int age) {
		User result = null;
		
		// Create the Local Player First
		LocalPlayer player = LocalPlayer.newLocalPlayer(firstName, lastName, age);
		
		// Create the New User
		Database.executeSQL(buildInsertSql(player.getLocalPlayerId(), userName, password));
		
		// Find the newly created Local Player
		ResultSet rs = Database.getResultSetFromSQL("SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_USER_NAME + " = \"" + userName + "\"");
		
		// Create the Local Player Object
		if (rs != null) {
			try {
				if (rs.next()){
					result = new User(rs);
					currentUser = result;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
			}
		}
		
		return result;
	}

	private static String buildInsertSql(int localPlayerId, String userName, String password) {
		return new String("INSERT INTO " + TABLE_NAME + 
						 	" (" + FIELD_LOCAL_PLAYER_ID + ", " + FIELD_USER_NAME + ", " + FIELD_PASSWORD + ") " + 
					      "VALUES("+ localPlayerId + ", \"" + userName + "\", \"" + password + "\")");
	}
}
