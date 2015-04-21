package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class LocalPlayerBattingStatistics {

	// Constants
	private static final String TABLE_NAME = "localplayersbattingstatistics";
	private static final String FIELD_ID = "localPlayersBattingStatisticsID";
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_TEAM_NAME = "team_name";
	private static final String FIELD_POSITION = "position";
	private static final String FIELD_GAME_DATE = "game_date";
	private static final String FIELD_BATTING_AB = "batting_ab";
	private static final String FIELD_BATTING_RBI = "batting_rbi";
	private static final String FIELD_BATTING_ONBASE_H = "batting_onbase_h";
	private static final String FIELD_BATTING_ONBASE_S = "batting_onbase_s";
	private static final String FIELD_BATTING_ONBASE_D = "batting_onbase_d";
	private static final String FIELD_BATTING_ONBASE_T = "batting_onbase_t";
	private static final String FIELD_BATTING_ONBASE_HR = "batting_onbase_hr";
	private static final String FIELD_BATTING_ONBASE_EARNED = "batting_onbase_earned";
	private static final String FIELD_BATTING_RUNS_TOTAL = "batting_runs";
	private static final String FIELD_BATTING_OUTS_KTOTAL = "batting_outs_k";
	private static final String FIELD_BATTING_STEAL_STOLEN = "batting_steal_stolen";
	private static final String FIELD_BATTING_GAME_WON = "batting_game_won";

	// Members
	private int localPlayersHittingStatisticsID;
	private int localPlayerId;
	private String team_name;
	private String position;
	private String game_date;
	private int batting_ab;
	private int batting_rbi;
	private int batting_onbase_h;
	private int batting_onbase_s;
	private int batting_onbase_d;
	private int batting_onbase_t;
	private int batting_onbase_hr;
	private int batting_onbase_earned;
	private int batting_runs_total;
	private int batting_outs_ktotal;
	private int batting_steal_stolen;
	private int batting_game_won;

	public int getLocalPlayersHittingStatisticsID() {
		return localPlayersHittingStatisticsID;
	}

	public int getLocalPlayerId() {
		return localPlayerId;
	}

	public String getTeam_name() {
		return team_name;
	}
	
	public int getTotalBases() {
		return batting_onbase_h + (2 * batting_onbase_d) + (3 * batting_onbase_t) + (4 * batting_onbase_hr);
	}
	
	public float getSlugging() {
		if (batting_ab != 0) {
			return (float) getTotalBases() / (float) batting_ab;
		}
		return 0.00f;
	}

	public String getPosition() {
		return position;
	}

	public String getGame_date() {
		return game_date;
	}

	public int getBatting_ab() {
		return batting_ab;
	}

	public int getBatting_rbi() {
		return batting_rbi;
	}

	public int getBatting_onbase_h() {
		return batting_onbase_h;
	}

	public int getBatting_onbase_s() {
		return batting_onbase_s;
	}

	public int getBatting_onbase_d() {
		return batting_onbase_d;
	}

	public int getBatting_onbase_t() {
		return batting_onbase_t;
	}

	public int getBatting_onbase_hr() {
		return batting_onbase_hr;
	}

	public int getBatting_onbase_earned() {
		return batting_onbase_earned;
	}

	public int getBatting_runs_total() {
		return batting_runs_total;
	}

	public int getBatting_outs_ktotal() {
		return batting_outs_ktotal;
	}

	public int getBatting_steal_stolen() {
		return batting_steal_stolen;
	}
	
	public int getBatting_game_won() {
		return batting_game_won;
	}

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
			this.batting_ab = rs.getInt(FIELD_BATTING_AB);
			this.batting_rbi = rs.getInt(FIELD_BATTING_RBI);
			this.batting_onbase_h = rs.getInt(FIELD_BATTING_ONBASE_H);
			this.batting_onbase_s = rs.getInt(FIELD_BATTING_ONBASE_S);
			this.batting_onbase_d = rs.getInt(FIELD_BATTING_ONBASE_D);
			this.batting_onbase_t = rs.getInt(FIELD_BATTING_ONBASE_T);
			this.batting_onbase_hr = rs.getInt(FIELD_BATTING_ONBASE_HR);
			this.batting_onbase_earned = rs.getInt(FIELD_BATTING_ONBASE_EARNED);
			this.batting_runs_total = rs.getInt(FIELD_BATTING_RUNS_TOTAL);
			this.batting_outs_ktotal = rs.getInt(FIELD_BATTING_OUTS_KTOTAL);
			this.batting_steal_stolen = rs.getInt(FIELD_BATTING_STEAL_STOLEN);
			this.batting_game_won = rs.getInt(FIELD_BATTING_GAME_WON);
		} catch (SQLException e) {
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
		//System.out.println("rs"+rs);
		if (rs != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the
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
	public static void addOrUpdateLocalPlayerBattingStatistics(String date,
			String ab, String h, String rbi, String b1, String b2, String b3,
			String runs, String sb, String hr, String so, Boolean won, int statsID) {

		int iab, ih, irbi, ib1, ib2, ib3, iruns, isb, ihr, iso, iwon;
		try {
			// parse strings into integers where appropriate
			if (won)
				iwon = 1;
			else
				iwon = 0;
			iab = parseToInt(ab);
			ih = parseToInt(h);
			irbi = parseToInt(rbi);
			ib1 = parseToInt(b1);
			ib2 = parseToInt(b2);
			ib3 = parseToInt(b3);
			iruns = parseToInt(runs);
			isb = parseToInt(sb);
			ihr = parseToInt(hr);
			iso = parseToInt(so);
			
			User currentUser = User.getCurrentUser();

			if(statsID == -1)
			{
				Database.executeSQL("INSERT INTO " + TABLE_NAME + "("
					+ FIELD_LOCAL_PLAYER_ID + ", " 
					+ FIELD_GAME_DATE + ", "
					+ FIELD_BATTING_AB + ", " 
					+ FIELD_BATTING_ONBASE_H + ", "
					+ FIELD_BATTING_RBI + ", "
					+ FIELD_BATTING_ONBASE_S + ", " 
					+ FIELD_BATTING_ONBASE_D + ", "
					+ FIELD_BATTING_ONBASE_T + ", "
					+ FIELD_BATTING_RUNS_TOTAL + ", "
					+ FIELD_BATTING_STEAL_STOLEN + ", "
					+ FIELD_BATTING_ONBASE_HR + ", " 
					+ FIELD_BATTING_OUTS_KTOTAL + ", "
					+ FIELD_BATTING_GAME_WON + ") " + "VALUES (\""
					+ currentUser.getLocalPlayerId() + "\", " + "\"" + date
					+ "\", " + "\"" + iab + "\", " + "\"" + ih + "\", "
					+ "\"" + irbi + "\", " + "\"" + ib1 + "\", " + "\"" + ib2
					+ "\", " + "\"" + ib3 + "\", " + "\"" + iruns + "\", " + "\""
					+ isb + "\", " + "\"" + ihr + "\", " + "\"" + iso + "\", \"" + iwon + "\");");
			}
			else
			{
				Database.executeSQL("UPDATE " + TABLE_NAME 
						+ " SET " 
						+ FIELD_GAME_DATE + " = \"" + date + "\", "
						+ FIELD_BATTING_AB + " = \"" + iab + "\", "
						+ FIELD_BATTING_ONBASE_H + " = \"" + ih + "\", "
						+ FIELD_BATTING_RBI + " = \"" + irbi + "\", "
						+ FIELD_BATTING_ONBASE_S + " = \"" + ib1 + "\", "
						+ FIELD_BATTING_ONBASE_D + " = \"" + ib2 + "\", "
						+ FIELD_BATTING_ONBASE_T + " = \"" + ib3 + "\", "
						+ FIELD_BATTING_RUNS_TOTAL + " = \"" + iruns + "\", "
						+ FIELD_BATTING_STEAL_STOLEN + " = \"" + isb + "\", "
						+ FIELD_BATTING_ONBASE_HR + " = \"" + ihr + "\", "
						+ FIELD_BATTING_OUTS_KTOTAL + " = \"" + iso + "\", "
						+ FIELD_BATTING_GAME_WON + " = \"" + iwon + "\""
						+ " WHERE "
						+ FIELD_ID + " = \"" + statsID + "\";");
			}
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
	
	public static int parseToInt(String value){
		int result;
		if (notNumeric(value) != true)
			result = Integer.parseInt(value);
		else
			result = 0;
		return result;
	}
}
