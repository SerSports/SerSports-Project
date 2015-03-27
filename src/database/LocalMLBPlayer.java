package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalMLBPlayer {

	// Members
	private String username;		
	private String user_id;
	private String first_name; 		
	private String last_name; 		
	private String user_age;
	private String user_sex;
	private String user_city;
	private String user_state;
	private String user_zip;
	private String user_email;
	

	private String user_team_id;	
	private String user_team_name;	
	private String user_league_name;
	private String [] position = new String[11];
	
	
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
		return user_id;
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
		return user_team_name;
	}

	public void setTeam(String team) {
		this.user_team_name = team;
	}
	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getTeam_id() {
		return user_team_id;
	}

	public String getTeam_name() {
		return user_team_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_age() {
		return user_age;
	}

	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_city() {
		return user_city;
	}

	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public String getUser_zip() {
		return user_zip;
	}

	public void setUser_zip(String user_zip) {
		this.user_zip = user_zip;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_team_id() {
		return user_team_id;
	}

	public void setUser_team_id(String user_team_id) {
		this.user_team_id = user_team_id;
	}

	public String getUser_team_name() {
		return user_team_name;
	}

	public void setUser_team_name(String user_team_name) {
		this.user_team_name = user_team_name;
	}

	public String getUser_league_name() {
		return user_league_name;
	}

	public void setUser_league_name(String user_league_name) {
		this.user_league_name = user_league_name;
	}

	public String [] getPosition() {
		return position;
	}
	
	public String getPosition(int number){
		return position[number];
	}

	public void setPosition(String [] position) {
		this.position = position;
	}
	
	public void setPosition(String position, int number){
		this.position[number] = position;
	}

}
