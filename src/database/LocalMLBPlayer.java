package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalMLBPlayer {

	private User currentUser = null;
	
	// Constants
	private static final String TABLE_NAME = "LocaPlayerStatistics";
	private static final String FIELD_LOCAL_PLAYER = "localPlayerStatistics";
	private static final String FIELD_ID = "localPlayerId";
	private static final String FIELD_TEAM_NAME = "team_name";
	private static final String FIELD_POSITION = "position";
	private static final String FIELD_GAME_DATE = "game_date";
	private static final String FIELD_HITTING_AB = "hitting_ab";
	private static final String FIELD_HITTING_RBI = "hitting_rbi";
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
	private static final String FIELD_HITTING_ONBASE_H = "hitting_onbase_h";
	private static final String FIELD_HITTING_ONBASE_S = "hitting_onbase_s";
	private static final String FIELD_HITTING_ONBASE_D = "hitting_onbase_d";
	private static final String FIELD_HITTING_ONBASE_T = "hitting_onbase_t";
	private static final String FIELD_HITTING_ONBASE_HR = "hitting_onbase_hr";
	private static final String FIELD_HITTING_ONBASE_BB = "hitting_onbase_bb";
	private static final String FIELD_HITTING_RUNS_EARNED = "hitting_runs_earned";
	private static final String FIELD_HITTING_RUNS_TOTAL = "hitting_runs_total";
	private static final String FIELD_HITTING_OUTS_KTOTAL = "hitting_outs_ktotal";
	private static final String FIELD_HITTING_STEAL_CAUGHT = "hitting_steal_caught";
	private static final String FIELD_HITTING_STEAL_STOLEN = "hitting_steal_stolen";
	private static final String FIELD_HITTING_GAMES_PLAY = "hitting_games_play";
	private static final String FIELD_HITTING_GAMES_WIN = "hitting_games_win";
	private static final String FIELD_HITTING_GAMES_LOSS = "hitting_games_loss";
	private static final String FIELD_FIELDING_PO = "fielding_po";
	private static final String FIELD_FIELDING_ERROR = "fielding_error";
	private static final String FIELD_FIELDING_A = "fielding_a";
	private static final String FIELD_FIELDING_FPCT = "fielding_fpct";
	private static final String FIELD_FIELDING_GAMES_PLAY = "fielding_games_play";
	private static final String FIELD_FIELDING_GAMES_WIN = "fielding_games_win";
	private static final String FIELD_FIELDING_GAMES_LOSS = "fielding_games_loss";

	// Members
	private int local_player_statistics;
	private int id;
	private String team_name; // Team name
	private String position;
	private String game_date;
	private int hitting_ab; // Batting AB
	private int hitting_rbi; // Batting RBI
	private float pitching_era; // Pitching ERA
	private int pitching_onbase_h; // Batting H
	private int pitching_onbase_s; // Batting 1B single
	private int pitching_onbase_d; // Batting 2B double
	private int pitching_onbase_t; // Batting 3B triple
	private int pitching_onbase_hr; // Batting HR home-runs
	private int pitching_onbase_bb; // Pitching BB
	private int pitching_runs_earned; // Pitching ER
	private int pitching_runs_total; // Pitching R
	private int pitching_outs_ktotal; // Batting outs SO
	private int pitching_steal_caught; // steals Stolen SB
	private int pitching_steal_stolen; // steals Stolen SB
	private int pitching_games_play; // games play
	private int pitching_games_win; // Pitching: W
	private int pitching_games_loss; // Pitching: L
	private int pitching_games_save; // Pitching: Saves
	private int pitching_games_hold; // Pitching:Hold
	private int hitting_onbase_h; // Hitting H
	private int hitting_onbase_s; // Hitting 1B single
	private int hitting_onbase_d; // Hitting 2B double
	private int hitting_onbase_t; // Hitting 3B triple
	private int hitting_onbase_hr; // Hitting HR home-runs
	private int hitting_onbase_bb; // Hitting BB
	private int hitting_runs_earned; // Hitting ER
	private int hitting_runs_total; // Hitting R
	private int hitting_outs_ktotal; // Hitting outs SO
	private int hitting_steal_caught; // Hitting steals Stolen SB
	private int hitting_steal_stolen; // Hitting steals Stolen SB
	private int hitting_games_play; // Hitting GP games played
	private int hitting_games_win; // Hitting: W
	private int hitting_games_loss; // Hitting: L
	private int fielding_po; // Fielding Putouts
	private int fielding_error; // Fielding Error
	private int fielding_a; // Fielding Assists
	private float fielding_fpct; // Fielding Fielding Percentage
	private int fielding_games_play; // Fielding GP games played
	private int fielding_games_win; // Fielding: W
	private int fielding_games_loss; // Fielding: L

	// Getters / Setters
	public String getTeam() {
		return team_name;
	}

	public void setTeam(String team) {
		this.team_name = team;
	}

	public String getTeam_name() {
		return team_name;
	}

	public int getHitting_ab() {
		return hitting_ab;
	}

	public int getHitting_rbi() {
		return hitting_rbi;
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

	public int getHitting_onbase_h() {
		return hitting_onbase_h;
	}

	public int getHitting_onbase_s() {
		return hitting_onbase_s;
	}

	public int getHitting_onbase_d() {
		return hitting_onbase_d;
	}

	public int getHitting_onbase_t() {
		return hitting_onbase_t;
	}

	public int getHitting_onbase_hr() {
		return hitting_onbase_hr;
	}

	public int getHitting_onbase_bb() {
		return hitting_onbase_bb;
	}

	public int getHitting_runs_earned() {
		return hitting_runs_earned;
	}

	public int getHitting_runs_total() {
		return hitting_runs_total;
	}

	public int getHitting_outs_ktotal() {
		return hitting_outs_ktotal;
	}

	public int getHitting_steal_caught() {
		return hitting_steal_caught;
	}

	public int getHitting_steal_stolen() {
		return hitting_steal_stolen;
	}

	public int getHitting_games_play() {
		return hitting_games_play;
	}

	public int getHitting_games_win() {
		return hitting_games_win;
	}

	public int getHitting_games_loss() {
		return hitting_games_loss;
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

	public int getLocal_player_statistics() {
		return local_player_statistics;
	}

	public void setLocal_player_statistics(int local_player_statistics) {
		this.local_player_statistics = local_player_statistics;
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

	/**
	 * Method: Constructor Inputs: ResultSet rs Returns:
	 * 
	 * Description:
	 */
	public LocalMLBPlayer() {
		currentUser = User.getCurrentUser();
	}

	// Methods
	public boolean saveLocalPlayerStatisticsToDatabase() {
		boolean result = false;
		String sql = null;

		// Save this is a new record
		sql = buildInsertSql();

		// Execute the command
		result = Database.executeSQL(sql);

		return result;
	}

	private String buildInsertSql() {
		return "INSERT INTO " + TABLE_NAME + "(" + FIELD_LOCAL_PLAYER + ", "
				+ "," + FIELD_ID + "," + FIELD_TEAM_NAME + "," + FIELD_POSITION
				+ "," + FIELD_GAME_DATE + "," + FIELD_HITTING_AB + ","
				+ FIELD_HITTING_RBI + "," + FIELD_PITCHING_ERA + ","
				+ FIELD_PITCHING_ONBASE_H + "," + FIELD_PITCHING_ONBASE_S + ","
				+ FIELD_PITCHING_ONBASE_D + "," + FIELD_PITCHING_ONBASE_T + ","
				+ FIELD_PITCHING_ONBASE_HR + "," + FIELD_PITCHING_ONBASE_BB
				+ "," + FIELD_PITCHING_RUNS_EARNED + ","
				+ FIELD_PITCHING_RUNS_TOTAL + "," + FIELD_PITCHING_OUTS_KTOTAL
				+ "," + FIELD_PITCHING_STEAL_CAUGHT + ","
				+ FIELD_PITCHING_STEAL_STOLEN + "," + FIELD_PITCHING_GAMES_PLAY
				+ "," + FIELD_PITCHING_GAMES_WIN + ","
				+ FIELD_PITCHING_GAMES_LOSS + "," + FIELD_PITCHING_GAMES_SAVE
				+ "," + FIELD_PITCHING_GAMES_HOLD + ","
				+ FIELD_HITTING_ONBASE_H + "," + FIELD_HITTING_ONBASE_S + ","
				+ FIELD_HITTING_ONBASE_D + "," + FIELD_HITTING_ONBASE_T + ","
				+ FIELD_HITTING_ONBASE_HR + "," + FIELD_HITTING_ONBASE_BB + ","
				+ FIELD_HITTING_RUNS_EARNED + "," + FIELD_HITTING_RUNS_TOTAL
				+ "," + FIELD_HITTING_OUTS_KTOTAL + ","
				+ FIELD_HITTING_STEAL_CAUGHT + "," + FIELD_HITTING_STEAL_STOLEN
				+ "," + FIELD_HITTING_GAMES_PLAY + ","
				+ FIELD_HITTING_GAMES_LOSS + "," + FIELD_FIELDING_PO + ","
				+ FIELD_FIELDING_ERROR + "," + FIELD_FIELDING_A + ","
				+ FIELD_FIELDING_FPCT + "," + FIELD_FIELDING_GAMES_PLAY + ","
				+ FIELD_FIELDING_GAMES_WIN + "," + FIELD_FIELDING_GAMES_LOSS
				+ FIELD_HITTING_GAMES_WIN + ") " + "VALUES (\""
				+ this.local_player_statistics + ", " + this.id + ", "
				+ this.team_name + ", " + this.position + ", " + this.game_date
				+ "," + this.hitting_ab + ", " + this.hitting_rbi + ", "
				+ this.pitching_era + ", " + this.pitching_onbase_h + ", "
				+ this.pitching_onbase_s + ", " + this.pitching_onbase_d + ", "
				+ this.pitching_onbase_t + ", " + this.pitching_onbase_hr
				+ ", " + this.pitching_onbase_bb + ", "
				+ this.pitching_runs_earned + ", " + this.pitching_runs_total
				+ ", " + this.pitching_outs_ktotal + ", "
				+ this.pitching_steal_caught + ", "
				+ this.pitching_steal_stolen + ", " + this.pitching_games_play
				+ ", " + this.pitching_games_win + ", "
				+ this.pitching_games_loss + ", " + this.pitching_games_save
				+ ", " + this.pitching_games_hold + ", "
				+ this.hitting_onbase_h + ", " + this.hitting_onbase_s + ", "
				+ this.hitting_onbase_d + ", " + this.hitting_onbase_t + ", "
				+ this.hitting_onbase_hr + ", " + this.hitting_onbase_bb + ", "
				+ this.hitting_runs_earned + ", " + this.hitting_runs_total
				+ ", " + this.hitting_outs_ktotal + ", "
				+ this.hitting_steal_caught + ", " + this.hitting_steal_stolen
				+ ", " + this.hitting_games_play + ", "
				+ this.hitting_games_loss + ", " + this.fielding_po + ", "
				+ this.fielding_error + ", " + this.fielding_a + ", "
				+ this.fielding_fpct + ", " + this.fielding_games_play + ", "
				+ this.fielding_games_win + ", " + this.fielding_games_loss
				+ +this.hitting_games_win + ");";
	}
}
