package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalPlayerPitchingStatistics {

	// pitching constants
	private static final String TABLE_NAME = "localPlayersPitchingStatistics";
	private static final String FIELD_ID = "localPlayersPitchingStatisticsID";
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_TEAM_NAME = "team_name";
	private static final String FIELD_POSITION = "position";
	private static final String FIELD_GAME_DATE = "game_date";
	private static final String FIELD_PITCHING_GAMES_WIN = "pitching_games_win"; 	// win (w)
	private static final String FIELD_PITCHING_GAMES_LOSS = "pitching_games_loss"; 	// loss (l)
	private static final String FIELD_PITCHING_ERA = "pitching_era"; // Earned run average overall/per season (era)
	private static final String FIELD_PITCHING_GAMES_SAVE = "pitching_games_save"; // as in saves the game (save)
	private static final String FIELD_PITCHING_GAMES_HIT = "pitching_games_hit"; // hits allowed (hit)
	private static final String FIELD_PITCHING_GAMES_HOLD = "pitching_games_hold"; // holds (hold)
	private static final String FIELD_PITCHING_RUNS_TOTAL = "pitching_runs_total"; // runs allowed in one game (runs)
	private static final String FIELD_PITCHING_HBP = "pitching_hbp"; // hits by pitch (hbp)

	// Members
	private int localPlayersPitchingStatisticsID;
	private int localPlayerId;
	private String team_name;
	private String position;
	private String game_date;
	private int pitching_games_win; // Pitching game won
	private int pitching_games_loss; // Pitching game lost
	private float pitching_era; // Pitching: ERA
	private int pitching_games_save; // Pitching: Saves
	private int pitching_games_hit; // Pitching: Hits
	private int pitching_games_hold; // Pitching: Hold
	private int pitching_runs_total; // Pitching R
	private int pitching_hbp; // Pitching hbp: hits by pitch

	public int getLocalPlayersPitchingStatisticsID() {
		return localPlayersPitchingStatisticsID;
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

	public int getPitching_runs_total() {
		return pitching_runs_total;
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

	public int getPitching_games_hit() {
		return pitching_games_hit;
	}

	public int getPitching_hbp() {
		return pitching_hbp;
	}

	/**
	 * Method: Constructor Inputs: ResultSet rs Returns:
	 * 
	 * Description: Initialized this Object using a Result set
	 */
	private LocalPlayerPitchingStatistics(ResultSet rs) {
		try {
			// Load the rs's information
			this.localPlayersPitchingStatisticsID = rs.getInt(FIELD_ID);
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID);
			this.team_name = rs.getString(FIELD_TEAM_NAME);
			this.position = rs.getString(FIELD_POSITION);
			this.game_date = rs.getString(FIELD_GAME_DATE);
			this.pitching_era = rs.getFloat(FIELD_PITCHING_ERA);
			this.pitching_runs_total = rs.getInt(FIELD_PITCHING_RUNS_TOTAL);
			this.pitching_games_win = rs.getInt(FIELD_PITCHING_GAMES_WIN);
			this.pitching_games_loss = rs.getInt(FIELD_PITCHING_GAMES_LOSS);
			this.pitching_games_save = rs.getInt(FIELD_PITCHING_GAMES_SAVE);
			this.pitching_games_hold = rs.getInt(FIELD_PITCHING_GAMES_HOLD);
			this.pitching_games_hit = rs.getInt(FIELD_PITCHING_GAMES_HIT);
			this.pitching_hbp = rs.getInt(FIELD_PITCHING_HBP);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<LocalPlayerPitchingStatistics> getStatisticsFromDatabase(int localPlayerId) {
		ArrayList<LocalPlayerPitchingStatistics> resultList = new ArrayList<LocalPlayerPitchingStatistics>();

		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "
				+ FIELD_LOCAL_PLAYER_ID + " = " + localPlayerId + " ORDER BY "
				+ FIELD_GAME_DATE + " DESC";
		ResultSet rs = Database.getResultSetFromSQL(sql);

		if (rs != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the
			// ArrayList
			try {
				while (rs.next()) {
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

	//add local player's pitching statistics
	public static void addLocalPlayerPitchingStatistics(String date,
			String w, String l, String era, String saves, String hits,
			String holds, String runs, String hbp) {

		int iw, il, iera, isaves, ihits, iholds, iruns, ihbp;
		try {
			// parse strings into integers where appropriate
			if (notNumeric(w) != true)
				iw = Integer.parseInt(w);
			else
				iw = 0;
			if (notNumeric(l) != true)
				il = Integer.parseInt(l);
			else
				il = 0;
			if (notNumeric(era) != true)
				iera = Integer.parseInt(era);
			else
				iera = 0;
			if (notNumeric(saves) != true)
				isaves = Integer.parseInt(saves);
			else
				isaves = 0;
			if (notNumeric(hits) != true)
				ihits = Integer.parseInt(hits);
			else
				ihits = 0;
			if (notNumeric(holds) != true)
				iholds = Integer.parseInt(holds);
			else
				iholds = 0;
			if (notNumeric(runs) != true)
				iruns = Integer.parseInt(runs);
			else
				iruns = 0;
			if (notNumeric(hbp) != true)
				ihbp = Integer.parseInt(hbp);
			else
				ihbp = 0;

			/*
			 * NOTE: local variables which may need columns added in LocalPlayer
			 * table
			 */
			// String teamName = null;
			// String position = "Pitching";

			// get username/id
			User currentUser = User.getCurrentUser();

			Database.executeSQL("INSERT INTO " + TABLE_NAME + "(" + FIELD_LOCAL_PLAYER_ID
					+ ", " + FIELD_GAME_DATE + ", " + FIELD_PITCHING_GAMES_WIN + ", "
					+ FIELD_PITCHING_GAMES_LOSS + ", " + FIELD_PITCHING_ERA
					+ ", " + FIELD_PITCHING_GAMES_SAVE + ", "
					+ FIELD_PITCHING_GAMES_HIT + ", "
					+ FIELD_PITCHING_GAMES_HOLD + ", "
					+ FIELD_PITCHING_RUNS_TOTAL + ", " + FIELD_PITCHING_HBP
					+ ") " + "VALUES (\"" + currentUser.getLocalPlayerId()
					+ "\", " + "\"" + date + "\", " + "\"" + iw + "\", " + "\"" + il 
					+ "\", " + "\"" + iera
					+ "\", " + "\"" + isaves + "\", " + "\"" + ihits + "\", "
					+ "\"" + iholds + "\", " + "\"" + iruns + "\", " + "\""
					+ ihbp + "\");");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void deleteLocalPlayerPitchingStatistic(int localPlayerPitchingStatisticID){
		Database.executeSQL("DELETE FROM " + TABLE_NAME + " WHERE " + FIELD_ID + " = " 
				+ localPlayerPitchingStatisticID + ";");
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
