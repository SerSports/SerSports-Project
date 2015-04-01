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
	private static final String FIELD_FIELDING_GAMES_PLAY = "fielding_games_play";
	private static final String FIELD_FIELDING_GAMES_WIN = "fielding_games_win";
	private static final String FIELD_FIELDING_GAMES_LOSS = "fielding_games_loss";

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
	private int fielding_games_play; // Fielding GP games played
	private int fielding_games_win; // Fielding: W
	private int fielding_games_loss; // Fielding: L

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

	public int getFielding_a() {
		return fielding_assist;
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
			this.fielding_games_play = rs.getInt(FIELD_FIELDING_GAMES_PLAY);
			this.fielding_games_win = rs.getInt(FIELD_FIELDING_GAMES_WIN);
			this.fielding_games_loss = rs.getInt(FIELD_FIELDING_GAMES_LOSS);
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
	public static void addLocalPlayerFieldingStatistics(String date, String gp,
			String w, String l, String po, String error, String assist,
			String fpct) {

		int igp, iw, il, ipo, ierror, iassist, ifpct;
		try {
			// parse strings into integers where appropriate
			if (notNumeric(gp) != true)
				igp = Integer.parseInt(gp);
			else
				igp = 0;
			if (notNumeric(w) != true)
				iw = Integer.parseInt(w);
			else
				iw = 0;
			if (notNumeric(l) != true)
				il = Integer.parseInt(l);
			else
				il = 0;
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

			/*
			 * NOTE: local variables which may need columns added in LocalPlayer
			 * table
			 */
			// String teamName = null;
			// String position = "Fielding";

			// get username/id
			User currentUser = User.getCurrentUser();

			Database.executeSQL("INSERT INTO " + TABLE_NAME + "(" + FIELD_LOCAL_PLAYER_ID
					+ ", " + FIELD_GAME_DATE + ", " + FIELD_FIELDING_GAMES_PLAY
					+ ", " + FIELD_FIELDING_GAMES_WIN + ", "
					+ FIELD_FIELDING_GAMES_LOSS + ", " + FIELD_FIELDING_PO
					+ ", " + FIELD_FIELDING_ERROR + ", "
					+ FIELD_FIELDING_ASSIST + ", " + FIELD_FIELDING_FPCT + ") "
					+ "VALUES (\"" + currentUser.getLocalPlayerId() + "\", "
					+ "\"" + date + "\", " + "\"" + igp + "\", " + "\"" + iw
					+ "\", " + "\"" + il + "\", " + "\"" + ipo + "\", " + "\""
					+ ierror + "\", " + "\"" + iassist + "\", " + "\"" + ifpct
					+ "\");");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
