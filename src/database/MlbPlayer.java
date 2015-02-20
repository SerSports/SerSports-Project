/**
 * 
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author graydonsvendson
 *
 */
public class MlbPlayer {
	
	// Constants
	private static final String TABLE_NAME = "MlbPlayers";  
	private static final String FIELD_ID = "mlbPlayerId";  
	private static final String FIELD_FIRSTNAME = "firstName";  
	private static final String FIELD_LASTNAME = "lastName";  
	private static final String FIELD_TEAM = "team";  
	private static final String FIELD_NUMBER = "number";  
	private static final String FIELD_POSITION = "position";  
	
	// Members
	private int id;
	private String firstName;
	private String lastName;
	private String team;
	private int number;
	private String position;
	
	// Constructors
	public MlbPlayer(ResultSet rs)
	{
		try {
			// Load the rs's information
			this.id = rs.getInt(FIELD_ID);
			this.firstName = rs.getString(FIELD_FIRSTNAME);
			this.lastName = rs.getString(FIELD_LASTNAME);
			this.team = rs.getString(FIELD_TEAM);
			this.number = rs.getInt(FIELD_NUMBER);
			this.position = rs.getString(FIELD_POSITION);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Getters / Setters
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

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	// Methods
	public boolean saveMlbPlayerToDatabase() {
		boolean result = false;
		String sql = null;
		
		// See if this is a new record, or are we updating a record?
		if (this.id > 0)
			sql = buildUpdateSql();
		else
			sql = buildInsertSql();
		
		// Execute the command
		result = Database.executeSQL(sql);
		
		return result;
	}
	
	private String buildUpdateSql() {
		return "UPDATE " + TABLE_NAME + " " +
			   "SET " + 
					FIELD_FIRSTNAME + " = \"" + this.firstName + "\" " +
					FIELD_LASTNAME + " = \"" + this.lastName + "\" " +
					FIELD_TEAM + " = \"" + this.team + "\" " +
					FIELD_NUMBER + " = " + this.number + " " +
					FIELD_POSITION + " = \"" + this.position + "\" " +
				"WHERE " + FIELD_ID + " = " + this.id;
	}
	
	private String buildInsertSql() {
		return "INSERT INTO " + TABLE_NAME + 
				"(" + FIELD_FIRSTNAME + "," +  
					FIELD_LASTNAME + "," + 
					FIELD_TEAM + "," + 
					FIELD_NUMBER + "," + 
					FIELD_POSITION + ") " + 
				"VALUES (" + 
					this.firstName + ", " +
					this.lastName + ", " +
					this.team + ", " +
					this.number + ", " +
					this.position + ";";
	}
}
