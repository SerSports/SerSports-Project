/*
File: MlbPlayerFieldingStatistics.java
Author:	Ashley Mannon
Date:	

Description: GUI for displaying/searching the Local Players database

*/
package database;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MlbPlayerFieldingStatistics {
	// Constants
	private static final String TABLE_NAME = "MlbPlayersFieldingStatistics";  
	private static final String FIELD_ID = "MlbPlayersFieldingStatisticsID"; 
	private static final String FIELD_MLB_PLAYER_ID = "MlbPlayerId";
	private static final String FIELD_TEAM_NAME = "team_name";
	private static final String FIELD_POSITION = "position";
	private static final String FIELD_GAME_DATE = "game_date";	
    private static final String FIELD_FIELDING_PO = "fielding_po";			
    private static final String FIELD_FIELDING_ERROR = "fielding_error";		
    private static final String FIELD_FIELDING_A = "fielding_a";			
    private static final String FIELD_FIELDING_FPCT = "fielding_fpct";		
    private static final String FIELD_FIELDING_GAMES_PLAY = "fielding_games_play";	
    private static final String FIELD_FIELDING_GAMES_WIN = "fielding_games_win";	
    private static final String FIELD_FIELDING_GAMES_LOSS = "fielding_games_loss";

	// Members
	private int MlbPlayersFieldingStatisticsID; 
	private int MlbPlayerId; 
	private String team_name; 
	private String position; 
	private String game_date; 
    private int fielding_po;			//Fielding Putouts
    private int fielding_error;			//Fielding Error
    private int fielding_a;				//Fielding Assists
    private float fielding_fpct;		//Fielding Fielding Percentage
    private int fielding_games_play;	//Fielding GP games played
    private int fielding_games_win;		//Fielding: W
    private int fielding_games_loss;	//Fielding: L
    
	public int getPlayersFieldingStatisticsID() {
		return MlbPlayersFieldingStatisticsID;
	}
	public int getMlbPlayerId() {
		return MlbPlayerId;
	}
	public String getTeam_name() {
		return team_name;
	}
	public String getPosition() {
		return position;
	}
	public String getGame_date() {
		return game_date;
	}
	public int getFielding_po() {
		return fielding_po;
	}
	public int getFielding_error() {
		return fielding_error;
	}
	public int getFielding_a() {
		return fielding_a;
	}
	public float getFielding_fpct() {
		return fielding_fpct;
	}
	public int getFielding_games_play() {
		return fielding_games_play;
	}
	public int getFielding_games_win() {
		return fielding_games_win;
	}
	public int getFielding_games_loss() {
		return fielding_games_loss;
	}

	/**
	  Method: Constructor
	  Inputs: ResultSet rs
	  Returns:

	  Description: Initialized this Object using a Result set
	*/
	 private MlbPlayerFieldingStatistics (ResultSet rs) {
		try {
			// Load the rs's information
			this.MlbPlayersFieldingStatisticsID = rs.getInt(FIELD_ID);
			this.MlbPlayerId = rs.getInt(FIELD_MLB_PLAYER_ID); 
			this.team_name = rs.getString(FIELD_TEAM_NAME);
			this.position = rs.getString(FIELD_POSITION);
			this.game_date = rs.getString(FIELD_GAME_DATE);
			this.fielding_po = rs.getInt(FIELD_FIELDING_PO);
			this.fielding_error = rs.getInt(FIELD_FIELDING_ERROR);
			this.fielding_a = rs.getInt(FIELD_FIELDING_A);
			this.fielding_fpct = rs.getFloat(FIELD_FIELDING_FPCT);
			this.fielding_games_play = rs.getInt(FIELD_FIELDING_GAMES_PLAY);
			this.fielding_games_win = rs.getInt(FIELD_FIELDING_GAMES_WIN);
			this.fielding_games_loss = rs.getInt(FIELD_FIELDING_GAMES_LOSS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<MlbPlayerFieldingStatistics> getStatisticsFromDatabase(int MlbPlayerId) {
		ArrayList<MlbPlayerFieldingStatistics> resultList = new ArrayList<MlbPlayerFieldingStatistics>();
		
		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_MLB_PLAYER_ID + " = " + MlbPlayerId + " ORDER BY " + FIELD_GAME_DATE + " DESC";
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		if (rs != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the ArrayList
			try {
				while(rs.next()){
					MlbPlayerFieldingStatistics player = new MlbPlayerFieldingStatistics(rs);
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