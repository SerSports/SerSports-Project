package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalPlayerPitchingStatistics {
	
	// Constants
	private static final String TABLE_NAME = "localPlayersPitchingStatistics";  
	private static final String FIELD_ID = "localPlayersPitchingStatisticsID"; 
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_TEAM_NAME = "team_name";
	private static final String FIELD_POSITION = "position";
	private static final String FIELD_GAME_DATE = "game_date";	
	private static final String FIELD_PITCHING_ERA = "pitching_era"; 		
	private static final String FIELD_PITCHING_ONBASE_H = "pitching_onbase_h";	
	private static final String FIELD_PITCHING_ONBASE_S = "pitching_onbase_s";	
	private static final String FIELD_PITCHING_ONBASE_D = "pitching_onbase_d";	
	private static final String FIELD_PITCHING_ONBASE_T = "pitching_onbase_t";	
	private static final String FIELD_PITCHING_ONBASE_HR = "pitching_onbase_hr";	
	private static final String FIELD_PITCHING_ONBASE_BB = "pitching_onbase_bb";	
	private static final String FIELD_PITCHING_RUNS_EARNED = "pitching_runs_earned";  
	private static final String FIELD_PITCHING_RUNS_TOTAL = "pitching_runs_total"; 	
    private static final String FIELD_PITCHING_OUTS_KTOTAL = "pitching_outs_ktotal"; 
    private static final String FIELD_PITCHING_STEAL_CAUGHT = "pitching_steal_caught";
    private static final String FIELD_PITCHING_STEAL_STOLEN = "pitching_steal_stolen";
    private static final String FIELD_PITCHING_GAMES_PLAY = "pitching_games_play";	
    private static final String FIELD_PITCHING_GAMES_WIN = "pitching_games_win";	
    private static final String FIELD_PITCHING_GAMES_LOSS = "pitching_games_loss";	
    private static final String FIELD_PITCHING_GAMES_SAVE = "pitching_games_save";	
    private static final String FIELD_PITCHING_GAMES_HOLD = "pitching_games_hold"; 	

	// Members
	private int localPlayersHittingStatisticsID; 
	private int localPlayerId; 
	private String team_name; 
	private String position; 
	private String game_date; 
	private float pitching_era; 		//Pitching ERA
	private int pitching_onbase_h;		//Batting H
	private int pitching_onbase_s;		//Batting 1B single
	private int pitching_onbase_d;		//Batting 2B double
	private int pitching_onbase_t;		//Batting 3B triple
	private int pitching_onbase_hr;		//Batting HR home-runs
	private int pitching_onbase_bb;		//Pitching BB
	private int pitching_runs_earned; 	//Pitching ER 
	private int pitching_runs_total; 	//Pitching R
    private int pitching_outs_ktotal; 	//Batting outs SO
    private int pitching_steal_caught; 	// steals Stolen SB
    private int pitching_steal_stolen; 	// steals Stolen SB
    private int pitching_games_play;	// GP games played //Fielding//Pitching//Batting hitting_games_play
    private int pitching_games_win;		//Pitching: W
    private int pitching_games_loss;	//Pitching: L
    private int pitching_games_save;	//Pitching: Saves
    private int pitching_games_hold; 	//Pitching:Hold
    
	public int getLocalPlayersHittingStatisticsID() {
		return localPlayersHittingStatisticsID;
	}
	public int getLocalPlayerId() {
		return localPlayerId;
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
	public float getPitching_era() {
		return pitching_era;
	}
	public int getPitching_onbase_h() {
		return pitching_onbase_h;
	}
	public int getPitching_onbase_s() {
		return pitching_onbase_s;
	}
	public int getPitching_onbase_d() {
		return pitching_onbase_d;
	}
	public int getPitching_onbase_t() {
		return pitching_onbase_t;
	}
	public int getPitching_onbase_hr() {
		return pitching_onbase_hr;
	}
	public int getPitching_onbase_bb() {
		return pitching_onbase_bb;
	}
	public int getPitching_runs_earned() {
		return pitching_runs_earned;
	}
	public int getPitching_runs_total() {
		return pitching_runs_total;
	}
	public int getPitching_outs_ktotal() {
		return pitching_outs_ktotal;
	}
	public int getPitching_steal_caught() {
		return pitching_steal_caught;
	}
	public int getPitching_steal_stolen() {
		return pitching_steal_stolen;
	}
	public int getPitching_games_play() {
		return pitching_games_play;
	}
	public int getPitching_games_win() {
		return pitching_games_win;
	}
	public int getPitching_games_loss() {
		return pitching_games_loss;
	}
	public int getPitching_games_save() {
		return pitching_games_save;
	}
	public int getPitching_games_hold() {
		return pitching_games_hold;
	}

	/**
	  Method: Constructor
	  Inputs: ResultSet rs
	  Returns:

	  Description: Initialized this Object using a Result set
	*/
	private LocalPlayerPitchingStatistics(ResultSet rs) {
		try {
			// Load the rs's information
			this.localPlayersHittingStatisticsID = rs.getInt(FIELD_ID);
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID); 
			this.team_name = rs.getString(FIELD_TEAM_NAME);
			this.position = rs.getString(FIELD_POSITION);
			this.game_date = rs.getString(FIELD_GAME_DATE);
			this.pitching_era = rs.getFloat(FIELD_PITCHING_ERA);
			this.pitching_onbase_h = rs.getInt(FIELD_PITCHING_ONBASE_H);
			this.pitching_onbase_s = rs.getInt(FIELD_PITCHING_ONBASE_S);
			this.pitching_onbase_d = rs.getInt(FIELD_PITCHING_ONBASE_D);
			this.pitching_onbase_t = rs.getInt(FIELD_PITCHING_ONBASE_T);
			this.pitching_onbase_hr = rs.getInt(FIELD_PITCHING_ONBASE_HR);
			this.pitching_onbase_bb = rs.getInt(FIELD_PITCHING_ONBASE_BB);
			this.pitching_runs_earned = rs.getInt(FIELD_PITCHING_RUNS_EARNED); 
			this.pitching_runs_total = rs.getInt(FIELD_PITCHING_RUNS_TOTAL);
			this.pitching_outs_ktotal = rs.getInt(FIELD_PITCHING_OUTS_KTOTAL);
			this.pitching_steal_caught = rs.getInt(FIELD_PITCHING_STEAL_CAUGHT);
			this.pitching_steal_stolen = rs.getInt(FIELD_PITCHING_STEAL_STOLEN);
			this.pitching_games_play = rs.getInt(FIELD_PITCHING_GAMES_PLAY);
			this.pitching_games_win = rs.getInt(FIELD_PITCHING_GAMES_WIN);
			this.pitching_games_loss = rs.getInt(FIELD_PITCHING_GAMES_LOSS);
			this.pitching_games_save = rs.getInt(FIELD_PITCHING_GAMES_SAVE);
			this.pitching_games_hold = rs.getInt(FIELD_PITCHING_GAMES_HOLD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<LocalPlayerPitchingStatistics> getStatisticsFromDatabase(int localPlayerId) {
		ArrayList<LocalPlayerPitchingStatistics> resultList = new ArrayList<LocalPlayerPitchingStatistics>();
		
		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_LOCAL_PLAYER_ID + " = " + localPlayerId + " ORDER BY " + FIELD_GAME_DATE + " DESC";
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		if (rs != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the ArrayList
			try {
				while(rs.next()){
					LocalPlayerPitchingStatistics player = new LocalPlayerPitchingStatistics(rs);
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
