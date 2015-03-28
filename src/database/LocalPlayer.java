package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalPlayer {

	// Constants
	private static final String TABLE_NAME = "localPlayers";  
	private static final String FIELD_ID = "localPlayerId"; 
	private static final String FIELD_FIRST_NAME = "firstName";
	private static final String FIELD_LAST_NAME = "lastName";
	private static final String FIELD_AGE = "age"; 
	
	// Members
	private int localPlayerId;
	private String firstName; 
	private String lastName;
	private int age;
	
	// Getters / Setters
	public int getLocalPlayerId() {
		return localPlayerId;
	}

	public void setLocalPlayerId(int localPlayerId) {
		this.localPlayerId = localPlayerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	private LocalPlayer(ResultSet rs) {
		try {
			// Load the rs's information
			this.localPlayerId = rs.getInt(FIELD_ID);
			this.firstName = rs.getString(FIELD_FIRST_NAME);
			this.lastName = rs.getString(FIELD_LAST_NAME);
			this.age = rs.getInt(FIELD_AGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static LocalPlayer newLocalPlayer(String firstName, String lastName, int age) {
		LocalPlayer result = null;
		
		// Create the new local player
		Database.executeSQL(buildInsertSql(firstName, lastName, age));
		
		// Find the newly created Local Player
		String sql = "SELECT * FROM " + TABLE_NAME + genereateWhereClause(firstName, lastName, age) + " ORDER BY " + FIELD_ID + " DESC";
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		// Create the Local Player Object
		if (rs != null) {
			try {
				if (rs.next()){
					result = new LocalPlayer(rs);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	private static String buildInsertSql(String firstName, String lastName, int age) {
		return new String("INSERT INTO " + TABLE_NAME + 
							"(" + FIELD_FIRST_NAME + ", " + 
								  FIELD_LAST_NAME + ", " + 
								  FIELD_AGE + ") " + 
						  "VALUES(\"" + firstName + "\", \"" + 
								  		lastName + "\", " + 
								  		age + ")");
	}
	
	private static String genereateWhereClause(String firstName, String lastName, int age) {
		return new String(" WHERE " + FIELD_FIRST_NAME + " = \"" + firstName + "\" AND " + 
									 FIELD_LAST_NAME + " = \"" + lastName + "\" AND " + 
									 FIELD_AGE + " = " + age);
	}
}
