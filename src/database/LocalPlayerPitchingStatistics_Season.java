package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalPlayerPitchingStatistics_Season {

	// pitching constants
	private static final String TABLE_NAME = "localPlayersPitchingStatistics_season";
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_PITCHING_GAME_PLAY = "pitching_games_play"; 	// play (w)
	private static final String FIELD_PITCHING_GAME_WON = "pitching_games_won"; 	// win (w)
	private static final String FIELD_PITCHING_GAME_LOSS = "pitching_games_loss"; 	// loss (w)
	private static final String FIELD_PITCHING_TOTALS_ERA = "pitching_totals_era"; // Earned run average overall/per season (era)
	private static final String FIELD_PITCHING_GAMES_TOTALS_SAVE = "pitching_games_totals_save"; // as in saves the game (save)
	private static final String FIELD_PITCHING_GAMES_TOTALS_HIT = "pitching_games_totals_hit"; // hits allowed (hit)
	private static final String FIELD_PITCHING_GAMES_TOTALS_HOLD = "pitching_games_totals_hold"; // holds (hold)
	private static final String FIELD_PITCHING_TOTALS_RUNS = "pitching_totals_runs"; // runs allowed in one game (runs)
	private static final String FIELD_PITCHING_TOTALS_HBP = "pitching_totals_hbp"; // hits by pitch (hbp)

	// Members
	private int localPlayerId;
	private int pitching_games_play; // Pitching game won
	private int pitching_games_won; // Pitching game won
	private int pitching_games_loss; // Pitching game won
	private float pitching_totals_era; // Pitching: ERA
	private int pitching_games_totals_save; // Pitching: Saves
	private int pitching_games_totals_hit; // Pitching: Hits
	private int pitching_games_totals_hold; // Pitching: Hold
	private int pitching_totals_runs; // Pitching R
	private int pitching_totals_hbp; // Pitching hbp: hits by pitch

	public int getLocalPlayerId() {
		return localPlayerId;
	}

	public float getPitching_totals_era() {
		return pitching_totals_era;
	}

	public int getPitching_totals_runs() {
		return pitching_totals_runs;
	}

	public int getPitching_games_play() {
		return pitching_games_play;
	}

	public int getPitching_games_won() {
		return pitching_games_won;
	}

	public int getPitching_games_loss() {
		return pitching_games_loss;
	}

	public int getPitching_games_totals_save() {
		return pitching_games_totals_save;
	}

	public int getPitching_games_totals_hold() {
		return pitching_games_totals_hold;
	}

	public int getPitching_games_totals_hit() {
		return pitching_games_totals_hit;
	}

	public int getPitching_totals_hbp() {
		return pitching_totals_hbp;
	}

	/**
	 * Method: Constructor Inputs: ResultSet rs Returns:
	 * 
	 * Description: Initialized this Object using a Result set
	 */
	private LocalPlayerPitchingStatistics_Season(ResultSet rs) {
		try {
			// Load the rs's information
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID);
			this.pitching_totals_era = rs.getFloat(FIELD_PITCHING_TOTALS_ERA);
			this.pitching_totals_runs = rs.getInt(FIELD_PITCHING_TOTALS_RUNS);
			this.pitching_games_play = rs.getInt(FIELD_PITCHING_GAME_PLAY);
			this.pitching_games_won = rs.getInt(FIELD_PITCHING_GAME_WON);
			this.pitching_games_loss = rs.getInt(FIELD_PITCHING_GAME_LOSS);
			this.pitching_games_totals_save = rs.getInt(FIELD_PITCHING_GAMES_TOTALS_SAVE);
			this.pitching_games_totals_hold = rs.getInt(FIELD_PITCHING_GAMES_TOTALS_HOLD);
			this.pitching_games_totals_hit = rs.getInt(FIELD_PITCHING_GAMES_TOTALS_HIT);
			this.pitching_totals_hbp = rs.getInt(FIELD_PITCHING_TOTALS_HBP);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<LocalPlayerPitchingStatistics_Season> getStatisticsFromDatabase(int localPlayerId) {
		ArrayList<LocalPlayerPitchingStatistics_Season> resultList = new ArrayList<LocalPlayerPitchingStatistics_Season>();

		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "
				+ FIELD_LOCAL_PLAYER_ID + " = " + localPlayerId;
		ResultSet rs = Database.getResultSetFromSQL(sql);

		if (rs != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the
			// ArrayList
			try {
				while (rs.next()) {
					LocalPlayerPitchingStatistics_Season player = new LocalPlayerPitchingStatistics_Season(rs);
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
