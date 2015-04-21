package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalPlayerBattingStatistics_Season {

	// Constants
	private static final String TABLE_NAME = "localplayersbattingstatistics_season";
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_BATTING_GAME_PLAY = "batting_games_play";
	private static final String FIELD_BATTING_GAME_WON = "batting_games_won";
	private static final String FIELD_BATTING_GAME_LOSS = "batting_games_loss";
	private static final String FIELD_BATTING_TOTALS_AB = "batting_totals_ab";
	private static final String FIELD_BATTING_TOTALS_RBI = "batting_totals_rbi";
	private static final String FIELD_BATTING_ONBASE_TOTALS_H = "batting_onbase_totals_h";
	private static final String FIELD_BATTING_ONBASE_TOTALS_S = "batting_onbase_totals_s";
	private static final String FIELD_BATTING_ONBASE_TOTALS_D = "batting_onbase_totals_d";
	private static final String FIELD_BATTING_ONBASE_TOTALS_T = "batting_onbase_totals_t";
	private static final String FIELD_BATTING_ONBASE_TOTALS_HR = "batting_onbase_totals_hr";
	private static final String FIELD_BATTING_ONBASE_TOTALS_EARNED = "batting_onbase_totals_earned";
	private static final String FIELD_BATTING_TOTALS_RUNS = "batting_totals_runs";
	private static final String FIELD_BATTING_TOTALS_OUTS_K = "batting_totals_outs_k";
	private static final String FIELD_BATTING_STEAL_TOTALS_STOLEN = "batting_steal_totals_stolen";

	// Members
	private int localPlayersHittingStatisticsID;
	private int localPlayerId;
	private int batting_games_play;
	private int batting_games_won;
	private int batting_games_loss;
	private int batting_totals_ab;
	private int batting_totals_rbi;
	private int batting_onbase_totals_h;
	private int batting_onbase_totals_s;
	private int batting_onbase_totals_d;
	private int batting_onbase_totals_t;
	private int batting_onbase_totals_hr;
	private int batting_onbase_totals_earned;
	private int batting_totals_runs;
	private int batting_totals_outs_k;
	private int batting_steal_totals_stolen;

	public int getLocalPlayersHittingStatisticsID() {
		return localPlayersHittingStatisticsID;
	}

	public int getLocalPlayerId() {
		return localPlayerId;
	}

	public int getTotalBases() {
		return batting_onbase_totals_h + (2 * batting_onbase_totals_d) + (3 * batting_onbase_totals_t) + (4 * batting_onbase_totals_hr);
	}
	
	public float getSlugging() {
		float slug = 0.0f;
		
		if (batting_totals_ab != 0) {
			slug = (float) getTotalBases() / (float) batting_totals_ab;
			if (slug > 1.0f) {
				slug = 1.0f;
			}
		}
		
		return slug;
	}
	
	public float getBattingAverage() {
		float avg = 0.0f;
		
		if (batting_totals_ab != 0) {
			avg = (float) batting_onbase_totals_h / (float) batting_totals_ab;
			if (avg > 1.0f) {
				avg = 1.0f;
			}
		}
		
		return avg;
	}

	public int getBatting_totals_ab() {
		return batting_totals_ab;
	}

	public int getBatting_totals_rbi() {
		return batting_totals_rbi;
	}

	public int getBatting_onbase_totals_h() {
		return batting_onbase_totals_h;
	}

	public int getBatting_onbase_totals_s() {
		return batting_onbase_totals_s;
	}

	public int getBatting_onbase_totals_d() {
		return batting_onbase_totals_d;
	}

	public int getBatting_onbase_totals_t() {
		return batting_onbase_totals_t;
	}

	public int getBatting_onbase_totals_hr() {
		return batting_onbase_totals_hr;
	}

	public int getBatting_onbase_totals_earned() {
		return batting_onbase_totals_earned;
	}

	public int getBatting_totals_runs() {
		return batting_totals_runs;
	}

	public int getBatting_totals_outs_k() {
		return batting_totals_outs_k;
	}

	public int getBatting_steal_totals_stolen() {
		return batting_steal_totals_stolen;
	}
	
	public int getBatting_game_play() {
		return batting_games_play;
	}
	
	public int getBatting_game_won() {
		return batting_games_won;
	}
	
	public int getBatting_game_loss() {
		return batting_games_loss;
	}

	/**
	 * Method: Constructor Inputs: ResultSet rs Returns:
	 * 
	 * Description: Initialized this Object using a Result set
	 */
	private LocalPlayerBattingStatistics_Season(ResultSet rs) {
		try {
			// Load the rs's information
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID);
			this.batting_totals_ab = rs.getInt(FIELD_BATTING_TOTALS_AB);
			this.batting_totals_rbi = rs.getInt(FIELD_BATTING_TOTALS_RBI);
			this.batting_onbase_totals_h = rs.getInt(FIELD_BATTING_ONBASE_TOTALS_H);
			this.batting_onbase_totals_s = rs.getInt(FIELD_BATTING_ONBASE_TOTALS_S);
			this.batting_onbase_totals_d = rs.getInt(FIELD_BATTING_ONBASE_TOTALS_D);
			this.batting_onbase_totals_t = rs.getInt(FIELD_BATTING_ONBASE_TOTALS_T);
			this.batting_onbase_totals_hr = rs.getInt(FIELD_BATTING_ONBASE_TOTALS_HR);
			this.batting_onbase_totals_earned = rs.getInt(FIELD_BATTING_ONBASE_TOTALS_EARNED);
			this.batting_totals_runs = rs.getInt(FIELD_BATTING_TOTALS_RUNS);
			this.batting_totals_outs_k = rs.getInt(FIELD_BATTING_TOTALS_OUTS_K);
			this.batting_steal_totals_stolen = rs.getInt(FIELD_BATTING_STEAL_TOTALS_STOLEN);
			this.batting_games_play = rs.getInt(FIELD_BATTING_GAME_PLAY);
			this.batting_games_won = rs.getInt(FIELD_BATTING_GAME_WON);
			this.batting_games_loss = rs.getInt(FIELD_BATTING_GAME_LOSS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<LocalPlayerBattingStatistics_Season> getStatisticsFromDatabase(int localPlayerId) {
		ArrayList<LocalPlayerBattingStatistics_Season> resultList = new ArrayList<LocalPlayerBattingStatistics_Season>();

		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "
				+ FIELD_LOCAL_PLAYER_ID + " = " + localPlayerId;
		ResultSet rs = Database.getResultSetFromSQL(sql);

		if (rs != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the
			// ArrayList
			try {
				while (rs.next()) {
					LocalPlayerBattingStatistics_Season player = new LocalPlayerBattingStatistics_Season(rs);
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
	
	private static boolean notNumeric(String value){
		
		try{
			int number = Integer.parseInt(value);
		} catch(NumberFormatException ex){
			return true;
		}
		
		return false;
	}
}
