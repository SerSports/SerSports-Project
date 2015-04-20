package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class localPlayerFieldingStatistics_Season {

	// Constants
	private static final String TABLE_NAME = "localplayersfieldingstatistics_season";
	private static final String FIELD_LOCAL_PLAYER_ID = "localPlayerId";
	private static final String FIELD_FIELDING_GAME_PLAY = "fielding_game_play";
	private static final String FIELD_FIELDING_GAME_WON = "fielding_game_won";
	private static final String FIELD_FIELDING_GAME_LOSS = "fielding_game_loss";
	private static final String FIELD_FIELDING_TOTALS_PO = "fielding_totals_po";
	private static final String FIELD_FIELDING_TOTALS_ERROR = "fielding_totals_error";
	private static final String FIELD_FIELDING_TOTALS_ASSIST = "fielding_totals_assist";
	private static final String FIELD_FIELDING_TOTALS_FPCT = "fielding_totals_fpct";

	// Members
	private int localPlayersFieldingStatisticsID;
	private int localPlayerId;
	private int fielding_totals_po; // Fielding Putouts
	private int fielding_totals_error; // Fielding Error
	private int fielding_totals_assist; // Fielding Assists
	private float fielding_totals_fpct; // Fielding Fielding Percentage
	private int fielding_games_play; // Fielding: P
	private int fielding_games_won; // Fielding: W
	private int fielding_games_loss; // Fielding: L

	public int getLocalPlayersFieldingStatisticsID() {
		return localPlayersFieldingStatisticsID;
	}

	public int getLocalPlayerId() {
		return localPlayerId;
	}

	public int getFielding_totals_po() {
		return fielding_totals_po;
	}

	public int getFielding_totals_error() {
		return fielding_totals_error;
	}

	public int getFielding_totals_assist() {
		return fielding_totals_assist;
	}

	public float getFielding_totals_fpct() {
		return fielding_totals_fpct;
	}
	
	public int getFielding_game_play(){
		return fielding_games_play;
	}
	
	public int getFielding_games_won(){
		return fielding_games_won;
	}
	
	public int getFielding_games_loss(){
		return fielding_games_loss;
	}

	/**
	 * Method: Constructor Inputs: ResultSet rs Returns:
	 * 
	 * Description: Initialized this Object using a Result set
	 */
	private localPlayerFieldingStatistics_Season(ResultSet rs) {
		try {
			// Load the rs's information
			this.localPlayerId = rs.getInt(FIELD_LOCAL_PLAYER_ID);
			this.fielding_totals_po = rs.getInt(FIELD_FIELDING_TOTALS_PO);
			this.fielding_totals_error = rs.getInt(FIELD_FIELDING_TOTALS_ERROR);
			this.fielding_totals_assist = rs.getInt(FIELD_FIELDING_TOTALS_ASSIST);
			this.fielding_totals_fpct = rs.getFloat(FIELD_FIELDING_TOTALS_FPCT);
			this.fielding_games_play = rs.getInt(FIELD_FIELDING_GAME_PLAY);
			this.fielding_games_won = rs.getInt(FIELD_FIELDING_GAME_WON);
			this.fielding_games_loss = rs.getInt(FIELD_FIELDING_GAME_LOSS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<localPlayerFieldingStatistics_Season> getStatisticsFromDatabase(
			int localPlayerId) {
		ArrayList<localPlayerFieldingStatistics_Season> resultList = new ArrayList<localPlayerFieldingStatistics_Season>();

		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "
				+ FIELD_LOCAL_PLAYER_ID + " = " + localPlayerId;
		ResultSet rs = Database.getResultSetFromSQL(sql);

		if (rs != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the
			// ArrayList
			try {
				while (rs.next()) {
					localPlayerFieldingStatistics_Season player = new localPlayerFieldingStatistics_Season(rs);
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
