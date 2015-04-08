package database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

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
	//private static final String FIELD_HITTING_GAMES_LOSS = "hitting_games_loss";

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
	//private int hitting_games_loss;

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

	public int getHitting_ab() {
		return hitting_ab;
	}

	public int getHitting_rbi() {
		return hitting_rbi;
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

	public int getHitting_onbase_earned() {
		return hitting_onbase_earned;
	}

	public int getHitting_runs_total() {
		return hitting_runs_total;
	}

	public int getHitting_outs_ktotal() {
		return hitting_outs_ktotal;
	}

	public int getHitting_steal_stolen() {
		return hitting_steal_stolen;
	}

	public int getHitting_games_play() {
		return hitting_games_play;
	}
/*
	public int getHitting_games_loss() {
		return hitting_games_loss;
	}
*/
	/**
	 * Method: Constructor Inputs: ResultSet rs Returns:
	 * 
	 * Description: Initialized this Object using a Result set
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
			//this.hitting_games_loss = rs.getInt(FIELD_HITTING_GAMES_LOSS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<LocalPlayerBattingStatistics> getStatisticsFromDatabase(int localPlayerId) {
		ArrayList<LocalPlayerBattingStatistics> resultList = new ArrayList<LocalPlayerBattingStatistics>();

		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "
				+ FIELD_LOCAL_PLAYER_ID + " = " + localPlayerId + " ORDER BY "
				+ FIELD_GAME_DATE + " DESC";
		ResultSet rs = Database.getResultSetFromSQL(sql);

		if (rs != null) {
			// Loop through the Result Set and Add Each LocalPlayer to the
			// ArrayList
			try {
				while (rs.next()) {
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

	// add local player's batting statistics to localPlayerBattingStatistics
	// table
	public static void addLocalPlayerBattingStatistics(String date, String gp,
			String ab, String h, String rbi, String b1, String b2, String b3,
			String runs, String sb, String hr, String so) {

		int igp, iab, ih, irbi, ib1, ib2, ib3, iruns, isb, ihr, iso;
		try {
			// parse strings into integers where appropriate
			if (notNumeric(gp) != true)
				igp = Integer.parseInt(gp);
			else
				igp = 0;
			if (notNumeric(ab) != true)
				iab = Integer.parseInt(ab);
			else
				iab = 0;
			if (notNumeric(h) != true)
				ih = Integer.parseInt(h);
			else
				ih = 0;
			if (notNumeric(rbi) != true)
				irbi = Integer.parseInt(rbi);
			else
				irbi = 0;
			if (notNumeric(b1) != true)
				ib1 = Integer.parseInt(b1);
			else
				ib1 = 0;
			if (notNumeric(b2) != true)
				ib2 = Integer.parseInt(b2);
			else
				ib2 = 0;
			if (notNumeric(b3) != true)
				ib3 = Integer.parseInt(b3);
			else
				ib3 = 0;
			if (notNumeric(runs) != true)
				iruns = Integer.parseInt(runs);
			else
				iruns = 0;
			if (notNumeric(sb) != true)
				isb = Integer.parseInt(sb);
			else
				isb = 0;
			if (notNumeric(hr) != true)
				ihr = Integer.parseInt(hr);
			else
				ihr = 0;
			if (notNumeric(so) != true)
				iso = Integer.parseInt(so);
			else
				iso = 0;
			/*
			 * NOTE: local variables which may need columns added in LocalPlayer
			 * table
			 */
			// String teamName = null;
			// String position = "Batting";

			// get username/id
			// LocalPlayer currentLocalPlayer =
			// LocalPlayer.getCurrentLoggedInUser();
			User currentUser = User.getCurrentUser();

			Database.executeSQL("INSERT INTO " + TABLE_NAME + "("
					+ FIELD_LOCAL_PLAYER_ID + ", " + FIELD_GAME_DATE + ", "
					+ FIELD_HITTING_AB + ", " + FIELD_HITTING_RBI + ", "
					+ FIELD_HITTING_ONBASE_H + ", " + FIELD_HITTING_ONBASE_S
					+ ", " + FIELD_HITTING_ONBASE_D + ", "
					+ FIELD_HITTING_ONBASE_T + ", " + FIELD_HITTING_ONBASE_HR
					+ ", " + FIELD_HITTING_RUNS_TOTAL + ", "
					+ FIELD_HITTING_OUTS_KTOTAL + ", "
					+ FIELD_HITTING_STEAL_STOLEN + ", "
					+ FIELD_HITTING_GAMES_PLAY + ") " + "VALUES (\""
					+ currentUser.getLocalPlayerId() + "\", " + "\"" + date
					+ "\", " + "\"" + iab + "\", " + "\"" + irbi + "\", "
					+ "\"" + ih + "\", " + "\"" + ib1 + "\", " + "\"" + ib2
					+ "\", " + "\"" + ib3 + "\", " + "\"" + ihr + "\", " + "\""
					+ iruns + "\", " + "\"" + iso + "\", " + "\"" + isb
					+ "\", " + "\"" + igp + "\");");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteLocalPlayerBattingStatistic(int localPlayerHittingStatisticID){
		Database.executeSQL("DELETE FROM " + TABLE_NAME + " WHERE " + FIELD_ID + " = " 
				+ localPlayerHittingStatisticID + ";");
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
