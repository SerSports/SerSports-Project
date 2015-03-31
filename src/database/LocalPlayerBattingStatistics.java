package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalPlayerBattingStatistics {
	
	// Constants
	private static final String TABLE_NAME = "localPlayersHittingStatistics";  
	private static final String FIELD_ID = "localPlayersHittingStatisticsID"; 
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_TEAM_NAME = "team_name";
	private static final String FIELD_POSITION = "position";
	private static final String FIELD_GAME_DATE = "game_date";
	private static final String FIELD_HITTING_AB = "hitting_ab";
	private static final String FIELD_HITTING_RBI = "hitting_rbi";
	private static final String FIELD_HITTING_ONBASE_H = "hitting_onbase_h";
	private static final String FIELD_HITTING_ONBASE_S = "hitting_onbase_s";
	private static final String FIELD_HITTING_ONBASE_D = "hitting_onbase_d";
	private static final String FIELD_HITTING_ONBASE_T = "hitting_onbase_t";
	private static final String FIELD_HITTING_ONBASE_HR = "hitting_onbase_hr";
	private static final String FIELD_HITTING_ONBASE_EARNED = "hitting_onbase_earned";
	private static final String FIELD_HITTING_RUNS_TOTAL = "hitting_runs_total";
	private static final String FIELD_HITTING_OUTS_KTOTAL = "hitting_outs_ktotal";
	private static final String FIELD_HITTING_STEAL_STOLEN = "hitting_steal_stolen";
	private static final String FIELD_HITTING_GAMES_PLAY = "hitting_games_play";
	private static final String FIELD_HITTING_GAMES_LOSS = "hitting_games_loss";

	// Members
	private int localPlayersHittingStatisticsID; 
	private int localPlayerId; 
	private String team_name; 
	private String position; 
	private String game_date; 
	private int hitting_ab; 
	private int hitting_rbi; 
	private int hitting_onbase_h; 
	private int hitting_onbase_s; 
	private int hitting_onbase_d; 
	private int hitting_onbase_t; 
	private int hitting_onbase_hr;
	private int hitting_onbase_earned;
	private int hitting_runs_total;
	private int hitting_outs_ktotal; 
	private int hitting_steal_stolen; 
	private int hitting_games_play; 
	private int hitting_games_loss; 
	
	public int getLocalPlayersHittingStatisticsID() {
		return localPlayersHittingStatisticsID;
	}

	public void setLocalPlayersHittingStatisticsID(
			int localPlayersHittingStatisticsID) {
		this.localPlayersHittingStatisticsID = localPlayersHittingStatisticsID;
	}

	public int getLocalPlayerId() {
		return localPlayerId;
	}

	public void setLocalPlayerId(int localPlayerId) {
		this.localPlayerId = localPlayerId;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGame_date() {
		return game_date;
	}

	public void setGame_date(String game_date) {
		this.game_date = game_date;
	}

	public int getHitting_ab() {
		return hitting_ab;
	}

	public void setHitting_ab(int hitting_ab) {
		this.hitting_ab = hitting_ab;
	}

	public int getHitting_rbi() {
		return hitting_rbi;
	}

	public void setHitting_rbi(int hitting_rbi) {
		this.hitting_rbi = hitting_rbi;
	}

	public int getHitting_onbase_h() {
		return hitting_onbase_h;
	}

	public void setHitting_onbase_h(int hitting_onbase_h) {
		this.hitting_onbase_h = hitting_onbase_h;
	}

	public int getHitting_onbase_s() {
		return hitting_onbase_s;
	}

	public void setHitting_onbase_s(int hitting_onbase_s) {
		this.hitting_onbase_s = hitting_onbase_s;
	}

	public int getHitting_onbase_d() {
		return hitting_onbase_d;
	}

	public void setHitting_onbase_d(int hitting_onbase_d) {
		this.hitting_onbase_d = hitting_onbase_d;
	}

	public int getHitting_onbase_t() {
		return hitting_onbase_t;
	}

	public void setHitting_onbase_t(int hitting_onbase_t) {
		this.hitting_onbase_t = hitting_onbase_t;
	}

	public int getHitting_onbase_hr() {
		return hitting_onbase_hr;
	}

	public void setHitting_onbase_hr(int hitting_onbase_hr) {
		this.hitting_onbase_hr = hitting_onbase_hr;
	}

	public int getHitting_onbase_earned() {
		return hitting_onbase_earned;
	}

	public void setHitting_onbase_earned(int hitting_onbase_earned) {
		this.hitting_onbase_earned = hitting_onbase_earned;
	}

	public int getHitting_runs_total() {
		return hitting_runs_total;
	}

	public void setHitting_runs_total(int hitting_runs_total) {
		this.hitting_runs_total = hitting_runs_total;
	}

	public int getHitting_outs_ktotal() {
		return hitting_outs_ktotal;
	}

	public void setHitting_outs_ktotal(int hitting_outs_ktotal) {
		this.hitting_outs_ktotal = hitting_outs_ktotal;
	}

	public int getHitting_steal_stolen() {
		return hitting_steal_stolen;
	}

	public void setHitting_steal_stolen(int hitting_steal_stolen) {
		this.hitting_steal_stolen = hitting_steal_stolen;
	}

	public int getHitting_games_play() {
		return hitting_games_play;
	}

	public void setHitting_games_play(int hitting_games_play) {
		this.hitting_games_play = hitting_games_play;
	}

	public int getHitting_games_loss() {
		return hitting_games_loss;
	}

	public void setHitting_games_loss(int hitting_games_loss) {
		this.hitting_games_loss = hitting_games_loss;
	}

	/**
	  Method: Constructor
	  Inputs: ResultSet rs
	  Returns:

	  Description: Initialized this Object using a Result set
	*/
	private LocalPlayerBattingStatistics(ResultSet rs) {
		try {
			// Load the rs's information
			this.localPlayersHittingStatisticsID = rs.getInt(FIELD_ID);
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID); 
			this.team_name = rs.getString(FIELD_TEAM_NAME);
			this.position = rs.getString(FIELD_POSITION);
			this.game_date = rs.getString(FIELD_GAME_DATE);
			this.hitting_ab = rs.getInt(FIELD_HITTING_AB);
			this.hitting_rbi = rs.getInt(FIELD_HITTING_RBI);
			this.hitting_onbase_h = rs.getInt(FIELD_HITTING_ONBASE_H);
			this.hitting_onbase_s = rs.getInt(FIELD_HITTING_ONBASE_S);
			this.hitting_onbase_d = rs.getInt(FIELD_HITTING_ONBASE_D);
			this.hitting_onbase_t = rs.getInt(FIELD_HITTING_ONBASE_T);
			this.hitting_onbase_hr = rs.getInt(FIELD_HITTING_ONBASE_HR);
			this.hitting_onbase_earned = rs.getInt(FIELD_HITTING_ONBASE_EARNED);
			this.hitting_runs_total = rs.getInt(FIELD_HITTING_RUNS_TOTAL);
			this.hitting_outs_ktotal = rs.getInt(FIELD_HITTING_OUTS_KTOTAL);
			this.hitting_steal_stolen = rs.getInt(FIELD_HITTING_STEAL_STOLEN);
			this.hitting_games_play = rs.getInt(FIELD_HITTING_GAMES_PLAY);
			this.hitting_games_loss = rs.getInt(FIELD_HITTING_GAMES_LOSS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<LocalPlayerBattingStatistics> getStatisticsFromDatabase(int localPlayerId) {
		ArrayList<LocalPlayerBattingStatistics> resultList = new ArrayList<LocalPlayerBattingStatistics>();
		
		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_LOCAL_PLAYER_ID + " = " + localPlayerId + " ORDER BY " + FIELD_GAME_DATE + " DESC";
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		if (rs != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the ArrayList
			try {
				while(rs.next()){
					LocalPlayerBattingStatistics player = new LocalPlayerBattingStatistics(rs);
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
