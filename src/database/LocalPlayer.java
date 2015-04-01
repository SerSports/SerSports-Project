package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalPlayer {
	
	// Constants
	private static final String TABLE_NAME = "localPlayers";  
	private static final String FIELD_ID = "localPlayerId"; 
	private static final String FIELD_FIRST_NAME = "firstName";
	private static final String FIELD_LAST_NAME = "lastName";
	private static final String FIELD_AGE = "age"; 
	private static final String FIELD_TEAM_NAME = "team_name"; 
	
	// Members
	private int localPlayerId;
	private String firstName; 
	private String lastName;
	private int age;
	private String teamName;
	
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
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	private LocalPlayer(ResultSet rs) {
		try {
			// Load the rs's information
			this.localPlayerId = rs.getInt(FIELD_ID);
			this.firstName = rs.getString(FIELD_FIRST_NAME);
			this.lastName = rs.getString(FIELD_LAST_NAME);
			this.age = rs.getInt(FIELD_AGE);
			this.teamName = rs.getString(FIELD_TEAM_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static LocalPlayer newLocalPlayer(String firstName, String lastName, int age, String teamName) {
		LocalPlayer result = null;
		
		// Create the new local player
		Database.executeSQL(buildInsertSql(firstName, lastName, age, teamName));
		
		// Find the newly created Local Player
		String sql = "SELECT * FROM " + TABLE_NAME + genereateWhereClause(0, firstName, lastName, age, teamName) + " ORDER BY " + FIELD_ID + " DESC";
		ResultSet resultSet = Database.getResultSetFromSQL(sql);
		
		// Create the Local Player Object
		if (resultSet != null) {
			try {
				if (resultSet.next()){
					result = new LocalPlayer(resultSet);
					//System.out.println("currentLocalPlayer: "+currentLocalPlayer.getLocalPlayerId());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Clean Up
		Database.close();
		
		return result;
	}
	
	private static String buildInsertSql(String firstName, String lastName, int age, String teamName) {
		return new String("INSERT INTO " + TABLE_NAME + 
							"(" + FIELD_FIRST_NAME + ", " + 
								  FIELD_LAST_NAME + ", " + 
								  FIELD_AGE + ", " + 
								  FIELD_TEAM_NAME + ") " + 
						  "VALUES(" + Database.formatSqlStringValueForInsert(firstName) + ", " + 
									  Database.formatSqlStringValueForInsert(lastName) + ", " + 
									  age + ", " + 
									  Database.formatSqlStringValueForInsert(teamName) + ")");
	}
	
	private static String genereateWhereClause(int id_in, String firstName_in, String lastName_in, int age_in, String teamName_in) {
		StringBuilder whereClause = new StringBuilder();
		
		// See if anything was passed in
		if (id_in > 0 || firstName_in != null || lastName_in != null || age_in > 0 || teamName_in != null) {
			Boolean fieldsAdded = false;
			
			// Initialize
			whereClause.append(" WHERE ");
			
			// Add the fields we need
			if (id_in > 0) {
				whereClause.append(FIELD_ID + " = " + id_in );
				fieldsAdded = true;
			} 
			if (firstName_in != null) {
				if (fieldsAdded) {
					whereClause.append(" AND ");
				}
				
				whereClause.append(FIELD_FIRST_NAME + " = \"" + firstName_in + "\"");
				fieldsAdded = true;
			} 
			if (lastName_in != null) {
				if (fieldsAdded) {
					whereClause.append(" AND ");
				}
				whereClause.append(FIELD_LAST_NAME + " = \"" + lastName_in + "\"");
				fieldsAdded = true;
			} 
			if (age_in > 0) {
				whereClause.append(FIELD_ID + " = " + age_in);
				fieldsAdded = true;
			} 
			if (teamName_in != null) {
				if (fieldsAdded) {
					whereClause.append(" AND ");
				}
				
				whereClause.append(FIELD_TEAM_NAME + " = \"" + teamName_in + "\"");
				fieldsAdded = true;
			}
		}
		return whereClause.toString();
	}

	
	public static ArrayList<LocalPlayer> getPlayersFromDatabase(int id_in, String fName_in, String lName_in, int age_in, String team_in) {
		ArrayList<LocalPlayer> resultList = new ArrayList<LocalPlayer>();
		
		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + genereateWhereClause(id_in, fName_in, lName_in, 0, team_in) + 
								" ORDER BY " + FIELD_TEAM_NAME + ", " + FIELD_FIRST_NAME + ", " + FIELD_LAST_NAME;
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		if (rs != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the ArrayList
			try {
				while(rs.next()){
					LocalPlayer player = new LocalPlayer(rs);
					resultList.add(player);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Clean up
		Database.close();
			
		return resultList;
	}

	public static ArrayList<LocalPlayer> getLocalPlayersStatisticsFromDatabase(int id_in) {
		ArrayList<LocalPlayer> resultList = new ArrayList<LocalPlayer>();
		
		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_ID + " = \"" + id_in + "\"" +
								" ORDER BY " + FIELD_ID;
		ResultSet resultSet = Database.getResultSetFromSQL(sql);
		
		if (resultSet != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the ArrayList
			try {
				while(resultSet.next()){
					LocalPlayer player = new LocalPlayer(resultSet);
					resultList.add(player);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Clean up
		Database.close();
			
		return resultList;
	}
}
