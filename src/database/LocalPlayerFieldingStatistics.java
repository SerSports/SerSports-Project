package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalPlayerFieldingStatistics {

	// Constants
	private static final String TABLE_NAME = "localPlayersFieldingStatistics";
	private static final String FIELD_ID = "localPlayersFieldingStatisticsID";
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_TEAM_NAME = "team_name";
	private static final String FIELD_POSITION = "position";
	private static final String FIELD_GAME_DATE = "game_date";
	private static final String FIELD_FIELDING_PO = "fielding_po";
	private static final String FIELD_FIELDING_ERROR = "fielding_error";
	private static final String FIELD_FIELDING_ASSIST = "fielding_assist";
	private static final String FIELD_FIELDING_FPCT = "fielding_fpct";
	private static final String FIELD_FIELDING_GAME_WON = "fielding_game_won";

	// Members
	private int localPlayersFieldingStatisticsID;
	private int localPlayerId;
	private String team_name;
	private String position;
	private String game_date;
	private int fielding_po; // Fielding Putouts
	private int fielding_error; // Fielding Error
	private int fielding_assist; // Fielding Assists
	private float fielding_fpct; // Fielding Fielding Percentage
	private int fielding_game_won; // Fielding: W

	public int getLocalPlayersFieldingStatisticsID() {
		return localPlayersFieldingStatisticsID;
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

	public int getFielding_po() {
		return fielding_po;
	}

	public int getFielding_error() {
		return fielding_error;
	}

	public int getFielding_assist() {
		return fielding_assist;
	}

	public float getFielding_fpct() {
		return fielding_fpct;
	}
	
	public int getFielding_game_won(){
		return fielding_game_won;
	}

	/**
	 * Method: Constructor Inputs: ResultSet rs Returns:
	 * 
	 * Description: Initialized this Object using a Result set
	 */
	private LocalPlayerFieldingStatistics(ResultSet rs) {
		try {
			// Load the rs's information
			this.localPlayersFieldingStatisticsID = rs.getInt(FIELD_ID);
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID);
			this.team_name = rs.getString(FIELD_TEAM_NAME);
			this.position = rs.getString(FIELD_POSITION);
			this.game_date = rs.getString(FIELD_GAME_DATE);
			this.fielding_po = rs.getInt(FIELD_FIELDING_PO);
			this.fielding_error = rs.getInt(FIELD_FIELDING_ERROR);
			this.fielding_assist = rs.getInt(FIELD_FIELDING_ASSIST);
			this.fielding_fpct = rs.getFloat(FIELD_FIELDING_FPCT);
			this.fielding_game_won = rs.getInt(FIELD_FIELDING_GAME_WON);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<LocalPlayerFieldingStatistics> getStatisticsFromDatabase(
			int localPlayerId) {
		ArrayList<LocalPlayerFieldingStatistics> resultList = new ArrayList<LocalPlayerFieldingStatistics>();

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
					LocalPlayerFieldingStatistics player = new LocalPlayerFieldingStatistics(
							rs);
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

	// get all the local player's fielding statistics
	public static void addOrUpdateLocalPlayerFieldingStatistics(String date,
			Boolean won, String po, String error, String assist,
			String fpct, int statsID) {

		int iwon, ipo, ierror, iassist, ifpct;
		try {
			// parse strings into integers where appropriate
			if (won)
				iwon = 1;
			else
				iwon = 0;
			if (notNumeric(po) != true)
				ipo = Integer.parseInt(po);
			else
				ipo = 0;
			if (notNumeric(error) != true)
				ierror = Integer.parseInt(error);
			else
				ierror = 0;
			if (notNumeric(assist) != true)
				iassist = Integer.parseInt(assist);
			else
				iassist = 0;
			if (notNumeric(fpct) != true)
				ifpct = Integer.parseInt(fpct);
			else
				ifpct = 0;

			User currentUser = User.getCurrentUser();

			if(statsID == -1)
			{
				Database.executeSQL("INSERT INTO " + TABLE_NAME + "(" + FIELD_LOCAL_PLAYER_ID
					+ ", " + FIELD_GAME_DATE + ", " + FIELD_FIELDING_PO + ", " + FIELD_FIELDING_ERROR 
					+ ", " + FIELD_FIELDING_ASSIST + ", " + FIELD_FIELDING_FPCT + ", " + FIELD_FIELDING_GAME_WON + ") "
					+ "VALUES (\"" + currentUser.getLocalPlayerId() + "\", "
					+ "\"" + date + "\", " + "\"" + ipo + "\", " + "\""
					+ ierror + "\", " + "\"" + iassist + "\", " + "\"" + ifpct + "\", " + "\"" + iwon
					+ "\");");
			}
			else
			{
				Database.executeSQL("UPDATE " + TABLE_NAME 
						+ " SET " 
						+ FIELD_GAME_DATE + " = \"" + date + "\", "
						+ FIELD_FIELDING_PO + " = \"" + ipo + "\", "
						+ FIELD_FIELDING_ERROR + " = \"" + ierror + "\", "
						+ FIELD_FIELDING_ASSIST + " = \"" + iassist + "\", "
						+ FIELD_FIELDING_FPCT + " = \"" + ifpct + "\", "
						+ FIELD_FIELDING_GAME_WON + " = \"" + iwon + "\""
						+ " WHERE "
						+ FIELD_ID + " = \"" + statsID + "\";");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

	public static void deleteLocalPlayerFieldingStatistic(int localPlayerFieldingStatisticID){
		Database.executeSQL("DELETE FROM " + TABLE_NAME + " WHERE " + FIELD_ID + " = " 
				+ localPlayerFieldingStatisticID + ";");
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
