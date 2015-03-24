package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalMLBPlayer {

	// Members
	private String id;
	private String first_name; 			//Player First Name
	private String last_name; 			//Player Last Name

	private String team_id;				//Team ID
	private String team_name;			//Team name
	
	public LocalMLBPlayer(ResultSet rs) {
		/*
		try {
			// Load the rs's information
			this.id = rs.getString(FIELD_ID);
			this.first_name = rs.getString(FIELD_FIRSTNAME);
			this.last_name = rs.getString(FIELD_LASTNAME);
			this.team_name = rs.getString(FIELD_TEAM_NAME);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	// Getters / Setters
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	public String getTeam() {
		return team_name;
	}

	public void setTeam(String team) {
		this.team_name = team;
	}
	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getTeam_id() {
		return team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

}
