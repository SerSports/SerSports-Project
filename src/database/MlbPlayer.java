package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Contains all components of an MLB player and calls from a separate database to obtain
 * said components. Provides all back end functionality of MLB player's classification
 * filtering.
 * 
 * @author SerSports
 */
public class MlbPlayer extends Object implements java.io.Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * General attributes required by the MLB player object
	 */
	private static final String TABLE_NAME = "mlbplayers";
	private static final String FIELD_ID = "mlbPlayerId";
	private static final String FIELD_FIRSTNAME = "firstName";
	private static final String FIELD_LASTNAME = "lastName";
	private static final String FIELD_TEAM_NAME = "team_name";
	private static final String FIELD_TEAM_ID = "team_id";
	
	/*
	 * Pitching Statistics
	 */
	private static final String FIELD_PITCHING_ERA = "pitching_era"; // Earned Run Average
	private static final String FIELD_PITCHING_ONBASE_H = "pitching_onbase_h"; // Hits Given Up
	private static final String FIELD_PITCHING_ONBASE_S = "pitching_onbase_s"; // Singles Given Up
	private static final String FIELD_PITCHING_ONBASE_D = "pitching_onbase_d"; // Doubles Given Up
	private static final String FIELD_PITCHING_ONBASE_T = "pitching_onbase_t"; // Triples Given Up
	private static final String FIELD_PITCHING_ONBASE_HR = "pitching_onbase_hr"; // Home Runs Given Up
	private static final String FIELD_PITCHING_ONBASE_BB = "pitching_onbase_bb"; // Base-on-balls (Walks) Given Up 
	private static final String FIELD_PITCHING_RUNS_EARNED = "pitching_runs_earned"; // Runs Earned Against
	private static final String FIELD_PITCHING_RUNS_TOTAL = "pitching_runs_total"; // Total Runs Given Up
	private static final String FIELD_PITCHING_OUTS_KTOTAL = "pitching_outs_ktotal"; // Total Strike-outs
	private static final String FIELD_PITCHING_STEAL_CAUGHT = "pitching_steal_caught"; // Steals Caught (Pick-offs)
	private static final String FIELD_PITCHING_STEAL_STOLEN = "pitching_steal_stolen"; // Stolen Bases Given Up
	private static final String FIELD_PITCHING_GAMES_PLAY = "pitching_games_play"; // Games Played
	private static final String FIELD_PITCHING_GAMES_WIN = "pitching_games_win"; // Games Won
	private static final String FIELD_PITCHING_GAMES_LOSS = "pitching_games_loss"; // Games Lost
	private static final String FIELD_PITCHING_GAMES_SAVE = "pitching_games_save"; // Games Saved
	private static final String FIELD_PITCHING_GAMES_HOLD = "pitching_games_hold"; // Games Held
	
	/*
	 * Batting Statistics
	 */
	private static final String FIELD_HITTING_AB = "hitting_ab"; // At Bats
	private static final String FIELD_HITTING_RBI = "hitting_rbi"; // Runs Batted In
	private static final String FIELD_HITTING_ONBASE_H = "hitting_onbase_h"; // Hits
	private static final String FIELD_HITTING_ONBASE_S = "hitting_onbase_s"; // Singles
	private static final String FIELD_HITTING_ONBASE_D = "hitting_onbase_d"; // Doubles
	private static final String FIELD_HITTING_ONBASE_T = "hitting_onbase_t"; // Triples
	private static final String FIELD_HITTING_ONBASE_HR = "hitting_onbase_hr"; // Home Runs
	private static final String FIELD_HITTING_ONBASE_BB = "hitting_onbase_bb"; // Base-on-balls (Walks)
	private static final String FIELD_HITTING_RUNS_EARNED = "hitting_runs_earned"; // Runs Accounted For
	private static final String FIELD_HITTING_RUNS_TOTAL = "hitting_runs_total"; // Total Runs
	private static final String FIELD_HITTING_OUTS_KTOTAL = "hitting_outs_ktotal"; // Total Strike-outs
	private static final String FIELD_HITTING_STEAL_CAUGHT = "hitting_steal_caught"; // Caught Stealing
	private static final String FIELD_HITTING_STEAL_STOLEN = "hitting_steal_stolen"; // Stolen Bases
	private static final String FIELD_HITTING_GAMES_PLAY = "hitting_games_play"; // Games Played
	private static final String FIELD_HITTING_GAMES_WIN = "hitting_games_win"; // Games Won
	private static final String FIELD_HITTING_GAMES_LOSS = "hitting_games_loss"; // Games Lost
	
	/*
	 * Fielding Statistics
	 */
	private static final String FIELD_FIELDING_PO = "fielding_po"; // Put-outs
	private static final String FIELD_FIELDING_ERROR = "fielding_error"; // Errors
	private static final String FIELD_FIELDING_A = "fielding_a"; // Assists
	private static final String FIELD_FIELDING_FPCT = "fielding_fpct"; // Fielding Percentage
	private static final String FIELD_FIELDING_GAMES_PLAY = "fielding_games_play"; // Games Played
	private static final String FIELD_FIELDING_GAMES_WIN = "fielding_games_win"; // Games Won
	private static final String FIELD_FIELDING_GAMES_LOSS = "fielding_games_loss"; // Games Lost
	/*
	 * General Members
	 */
	private String id;
	private String first_name;
	private String last_name;
	private String team_id;
	private String team_name;
	
	/*
	 * Pitching Members
	 */
	private float pitching_era;
	private int pitching_onbase_h;
	private int pitching_onbase_s;
	private int pitching_onbase_d;
	private int pitching_onbase_t;
	private int pitching_onbase_hr;
	private int pitching_onbase_bb;
	private int pitching_runs_earned;
	private int pitching_runs_total;
	private int pitching_outs_ktotal;
	private int pitching_steal_caught;
	private int pitching_steal_stolen;
	private int pitching_games_play;
	private int pitching_games_win;
	private int pitching_games_loss;
	private int pitching_games_save;
	private int pitching_games_hold;
	
	/*
	 * Batting Members
	 */
	private int batting_ab;
	private int batting_rbi;
	private int batting_onbase_h;
	private int batting_onbase_s;
	private int batting_onbase_d;
	private int batting_onbase_t;
	private int batting_onbase_hr;
	private int batting_onbase_bb;
	private int batting_runs_earned;
	private int batting_runs_total;
	private int batting_outs_ktotal;
	private int batting_steal_caught;
	private int batting_steal_stolen;
	private int batting_games_play;
	private int batting_games_win;
	private int batting_games_loss;
	
	/*
	 * Fielding Members
	 */
	private int fielding_po;
	private int fielding_error;
	private int fielding_a;
	private float fielding_fpct;
	private int fielding_games_play;
	private int fielding_games_win;
	private int fielding_games_loss;
	
	/**
	 * Loads information from the Result Set that has queried data from the database
	 * relevant to the characteristics of an MLB Player
	 * 
	 * @param rs
	 *            Used to get information from the database.
	 */
	public MlbPlayer(ResultSet rs)
	{
		try
		{
			this.id = rs.getString(FIELD_ID);
			this.first_name = rs.getString(FIELD_FIRSTNAME);
			this.last_name = rs.getString(FIELD_LASTNAME);
			this.team_name = rs.getString(FIELD_TEAM_NAME);
			this.team_id = rs.getString(FIELD_TEAM_ID);
			
			this.pitching_era = rs.getFloat(FIELD_PITCHING_ERA);
			this.pitching_onbase_h = rs.getInt(FIELD_PITCHING_ONBASE_H);
			this.pitching_onbase_s = rs.getInt(FIELD_PITCHING_ONBASE_S);
			this.pitching_onbase_d = rs.getInt(FIELD_PITCHING_ONBASE_D);
			this.pitching_onbase_t = rs.getInt(FIELD_PITCHING_ONBASE_T);
			this.pitching_onbase_hr = rs.getInt(FIELD_PITCHING_ONBASE_HR);
			this.pitching_onbase_bb = rs.getInt(FIELD_PITCHING_ONBASE_BB);
			this.pitching_runs_earned = rs.getInt(FIELD_PITCHING_RUNS_EARNED);
			this.pitching_runs_total = rs.getInt(FIELD_PITCHING_RUNS_TOTAL);
			this.pitching_outs_ktotal = rs.getInt(FIELD_PITCHING_OUTS_KTOTAL);
			this.pitching_steal_caught = rs.getInt(FIELD_PITCHING_STEAL_CAUGHT);
			this.pitching_games_play = rs.getInt(FIELD_PITCHING_GAMES_PLAY);
			this.pitching_games_play = rs.getInt(FIELD_PITCHING_GAMES_PLAY);
			this.pitching_games_win = rs.getInt(FIELD_PITCHING_GAMES_WIN);
			this.pitching_games_loss = rs.getInt(FIELD_PITCHING_GAMES_LOSS);
			this.pitching_games_save = rs.getInt(FIELD_PITCHING_GAMES_SAVE);
			this.pitching_games_hold = rs.getInt(FIELD_PITCHING_GAMES_HOLD);
			this.pitching_games_play = rs.getInt(FIELD_PITCHING_GAMES_PLAY);
			
			this.batting_ab = rs.getInt(FIELD_HITTING_AB);
			this.batting_ab = rs.getInt(FIELD_HITTING_AB);
			this.batting_rbi = rs.getInt(FIELD_HITTING_RBI);
			this.batting_onbase_h = rs.getInt(FIELD_HITTING_ONBASE_H);
			this.batting_onbase_s = rs.getInt(FIELD_HITTING_ONBASE_S);
			this.batting_onbase_d = rs.getInt(FIELD_HITTING_ONBASE_D);
			this.batting_onbase_t = rs.getInt(FIELD_HITTING_ONBASE_T);
			this.batting_onbase_hr = rs.getInt(FIELD_HITTING_ONBASE_HR);
			this.batting_onbase_bb = rs.getInt(FIELD_HITTING_ONBASE_BB);
			this.batting_runs_earned = rs.getInt(FIELD_HITTING_RUNS_EARNED);
			this.batting_runs_total = rs.getInt(FIELD_HITTING_RUNS_TOTAL);
			this.batting_outs_ktotal = rs.getInt(FIELD_HITTING_OUTS_KTOTAL);
			this.batting_steal_caught = rs.getInt(FIELD_HITTING_STEAL_CAUGHT);
			this.batting_steal_stolen = rs.getInt(FIELD_HITTING_STEAL_STOLEN);
			this.batting_games_play = rs.getInt(FIELD_HITTING_GAMES_PLAY);
			this.batting_games_win = rs.getInt(FIELD_HITTING_GAMES_WIN);
			this.batting_games_loss = rs.getInt(FIELD_HITTING_GAMES_LOSS);
			
			this.fielding_po = rs.getInt(FIELD_FIELDING_PO);
			this.fielding_error = rs.getInt(FIELD_FIELDING_ERROR);
			this.fielding_a = rs.getInt(FIELD_FIELDING_A);
			this.fielding_fpct = rs.getInt(FIELD_FIELDING_FPCT);
			this.fielding_games_play = rs.getInt(FIELD_FIELDING_GAMES_PLAY);
			this.fielding_games_win = rs.getInt(FIELD_FIELDING_GAMES_WIN);
			this.fielding_games_loss = rs.getInt(FIELD_FIELDING_GAMES_LOSS);
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getFirst_name()
	{
		return first_name;
	}
	
	public String getLast_name()
	{
		return last_name;
	}
	
	public String getTeam_id()
	{
		return team_id;
	}
	
	public String getTeam_name()
	{
		return team_name;
	}
	
	/**
	 * @return The sum of all bases accrued by a player, with bases equating to: Single -
	 *         1, Double - 2, Triple - 3, Home Run - 4
	 */
	public int getTotalBases()
	{
		return batting_onbase_h + (2 * batting_onbase_d) + (3 * batting_onbase_t)
				+ (4 * batting_onbase_hr);
	}
	
	/**
	 * @return Slugging percentage based on the quotient of the player's total bases and
	 *         their total at bats given that they have at least one at bat. The maximum
	 *         value for slugging percentage is 1.0 (100%).
	 */
	public float getSlugging()
	{
		if (batting_ab != 0)
		{
			return (float) getTotalBases() / (float) batting_ab;
		}
		return 0.00f;
	}
	
	/**
	 * @return Batting average based on the quotient of the player's total hits and their
	 *         total at bats given that they have at least one at bat. The maximum value
	 *         for slugging percentage is 1.0 (100%).
	 */
	public float getBattingAverage()
	{
		if (batting_ab != 0)
		{
			return (float) batting_onbase_h / (float) batting_ab;
		}
		else
		{
			return 0.00f;
		}
	}
	
	public float getPitching_era()
	{
		return pitching_era;
	}
	
	public int getPitching_onbase_h()
	{
		return pitching_onbase_h;
	}
	
	public int getPitching_onbase_s()
	{
		return pitching_onbase_s;
	}
	
	public int getPitching_onbase_d()
	{
		return pitching_onbase_d;
	}
	
	public int getPitching_onbase_t()
	{
		return pitching_onbase_t;
	}
	
	public int getPitching_onbase_hr()
	{
		return pitching_onbase_hr;
	}
	
	public int getPitching_onbase_bb()
	{
		return pitching_onbase_bb;
	}
	
	public int getPitching_runs_earned()
	{
		return pitching_runs_earned;
	}
	
	public int getPitching_runs_total()
	{
		return pitching_runs_total;
	}
	
	public int getPitching_outs_ktotal()
	{
		return pitching_outs_ktotal;
	}
	
	public int getPitching_steal_caught()
	{
		return pitching_steal_caught;
	}
	
	public int getPitching_steal_stolen()
	{
		return pitching_steal_stolen;
	}
	
	public int getPitching_games_play()
	{
		return pitching_games_play;
	}
	
	public int getPitching_games_win()
	{
		return pitching_games_win;
	}
	
	public int getPitching_games_loss()
	{
		return pitching_games_loss;
	}
	
	public int getPitching_games_save()
	{
		return pitching_games_save;
	}
	
	public int getPitching_games_hold()
	{
		return pitching_games_hold;
	}
	
	public int getBatting_ab()
	{
		return batting_ab;
	}
	
	public int getBatting_rbi()
	{
		return batting_rbi;
	}
	
	public int getBatting_onbase_h()
	{
		return batting_onbase_h;
	}
	
	public int getBatting_onbase_s()
	{
		return batting_onbase_s;
	}
	
	public int getBatting_onbase_d()
	{
		return batting_onbase_d;
	}
	
	public int getBatting_onbase_t()
	{
		return batting_onbase_t;
	}
	
	public int getBatting_onbase_hr()
	{
		return batting_onbase_hr;
	}
	
	public int getBatting_onbase_bb()
	{
		return batting_onbase_bb;
	}
	
	public int getBatting_runs_earned()
	{
		return batting_runs_earned;
	}
	
	public int getBatting_runs_total()
	{
		return batting_runs_total;
	}
	
	public int getBatting_outs_ktotal()
	{
		return batting_outs_ktotal;
	}
	
	public int getBatting_steal_caught()
	{
		return batting_steal_caught;
	}
	
	public int getBatting_steal_stolen()
	{
		return batting_steal_stolen;
	}
	
	public int getBatting_games_play()
	{
		return batting_games_play;
	}
	
	public int getBatting_games_win()
	{
		return batting_games_win;
	}
	
	public int getBatting_games_loss()
	{
		return batting_games_loss;
	}
	
	public int getFielding_po()
	{
		return fielding_po;
	}
	
	public int getFielding_error()
	{
		return fielding_error;
	}
	
	public int getFielding_a()
	{
		return fielding_a;
	}
	
	public float getFielding_fpct()
	{
		return fielding_fpct;
	}
	
	public int getFielding_games_play()
	{
		return fielding_games_play;
	}
	
	public int getFielding_games_win()
	{
		return fielding_games_win;
	}
	
	public int getFielding_games_loss()
	{
		return fielding_games_loss;
	}
	
	/**
	 * Saves the current state of the MLB Player object to the database
	 * 
	 * @return The current state of the MLB Player object
	 */
	public boolean saveMlbPlayerToDatabase()
	{
		boolean result = false;
		String sql = null;
		
		sql = buildUpdateSql();
		
		result = Database.executeSQL(sql);
		
		return result;
	}
	
	/**
	 * @return The current state of all the attributes that an MLB Player object consists
	 *         of when the server is asked to update the information
	 */
	private String buildUpdateSql()
	{
		return "UPDATE " + TABLE_NAME + " " + "SET " + FIELD_FIRSTNAME + " = \""
				+ this.first_name + "\", " + FIELD_LASTNAME + " = \"" + this.last_name
				+ "\", " + FIELD_TEAM_NAME + " = \"" + this.team_name + "\", "
				+ FIELD_TEAM_ID + " = \"" + this.team_id + "\", " + FIELD_HITTING_AB
				+ " = \"" + this.batting_ab + "\", " + FIELD_HITTING_RBI + " = \""
				+ this.batting_rbi + "\", " + FIELD_PITCHING_ERA + " = \""
				+ this.pitching_era + "\", " + FIELD_PITCHING_ONBASE_H + " = \""
				+ this.pitching_onbase_h + "\", " + FIELD_PITCHING_ONBASE_S + " = \""
				+ this.pitching_onbase_s + "\", " + FIELD_PITCHING_ONBASE_D + " = \""
				+ this.pitching_onbase_d + "\", " + FIELD_PITCHING_ONBASE_T + " = \""
				+ this.pitching_onbase_t + "\", " + FIELD_PITCHING_ONBASE_HR + " = \""
				+ this.pitching_onbase_hr + "\", " + FIELD_PITCHING_ONBASE_BB + " = \""
				+ this.pitching_onbase_bb + "\", " + FIELD_PITCHING_RUNS_EARNED + " = \""
				+ this.pitching_runs_earned + "\", " + FIELD_PITCHING_RUNS_TOTAL
				+ " = \"" + this.pitching_runs_total + "\", "
				+ FIELD_PITCHING_OUTS_KTOTAL + " = \"" + this.pitching_outs_ktotal
				+ "\", " + FIELD_PITCHING_STEAL_CAUGHT + " = \""
				+ this.pitching_steal_caught + "\", " + FIELD_PITCHING_STEAL_STOLEN
				+ " = \"" + this.pitching_steal_stolen + "\", "
				+ FIELD_PITCHING_GAMES_PLAY + " = \"" + this.pitching_games_play + "\", "
				+ FIELD_PITCHING_GAMES_WIN + " = \"" + this.pitching_games_win + "\", "
				+ FIELD_PITCHING_GAMES_LOSS + " = \"" + this.pitching_games_loss + "\", "
				+ FIELD_PITCHING_GAMES_SAVE + " = \"" + this.pitching_games_save + "\", "
				+ FIELD_PITCHING_GAMES_HOLD + " = \"" + this.pitching_games_hold + "\", "
				+ FIELD_HITTING_ONBASE_H + " = \"" + this.batting_onbase_h + "\", "
				+ FIELD_HITTING_ONBASE_S + " = \"" + this.batting_onbase_s + "\", "
				+ FIELD_HITTING_ONBASE_D + " = \"" + this.batting_onbase_d + "\", "
				+ FIELD_HITTING_ONBASE_T + " = \"" + this.batting_onbase_t + "\", "
				+ FIELD_HITTING_ONBASE_HR + " = \"" + this.batting_onbase_hr + "\", "
				+ FIELD_HITTING_ONBASE_BB + " = \"" + this.batting_onbase_bb + "\", "
				+ FIELD_HITTING_RUNS_EARNED + " = \"" + this.batting_runs_earned + "\", "
				+ FIELD_HITTING_RUNS_TOTAL + " = \"" + this.batting_runs_total + "\", "
				+ FIELD_HITTING_OUTS_KTOTAL + " = \"" + this.batting_outs_ktotal + "\", "
				+ FIELD_HITTING_STEAL_CAUGHT + " = \"" + this.batting_steal_caught
				+ "\", " + FIELD_HITTING_STEAL_STOLEN + " = \""
				+ this.batting_steal_stolen + "\", " + FIELD_HITTING_GAMES_PLAY + " = \""
				+ this.batting_games_play + "\", " + FIELD_HITTING_GAMES_WIN + " = \""
				+ this.batting_games_win + "\", " + FIELD_HITTING_GAMES_LOSS + " = \""
				+ this.batting_games_loss + "\", " + FIELD_FIELDING_PO + " = \""
				+ this.fielding_po + "\", " + FIELD_FIELDING_ERROR + " = \""
				+ this.fielding_error + "\", " + FIELD_FIELDING_A + " = \""
				+ this.fielding_a + "\", " + FIELD_FIELDING_FPCT + " = \""
				+ this.fielding_fpct + "\", " + FIELD_FIELDING_GAMES_PLAY + " = \""
				+ this.fielding_games_play + "\", " + FIELD_FIELDING_GAMES_WIN + " = \""
				+ this.fielding_games_win + "\", " + FIELD_FIELDING_GAMES_LOSS + " = \""
				+ this.fielding_games_loss + "\" " + "WHERE " + FIELD_ID + " = \""
				+ this.id + "\"";
	}
	
	/**
	 * @return The current state of all the attributes that an MLB Player object consists
	 *         of when the server is asked to insert the information into a table for the
	 *         first time
	 */
	private String buildInsertSql()
	{
		return "INSERT INTO " + TABLE_NAME + "(" + FIELD_ID + ", " + FIELD_FIRSTNAME
				+ "," + FIELD_LASTNAME + "," + FIELD_TEAM_NAME + "," + FIELD_TEAM_ID
				+ "," + FIELD_HITTING_AB + "," + FIELD_HITTING_RBI + ","
				+ FIELD_PITCHING_ERA + "," + FIELD_PITCHING_ONBASE_H + ","
				+ FIELD_PITCHING_ONBASE_S + "," + FIELD_PITCHING_ONBASE_D + ","
				+ FIELD_PITCHING_ONBASE_T + "," + FIELD_PITCHING_ONBASE_HR + ","
				+ FIELD_PITCHING_ONBASE_BB + "," + FIELD_PITCHING_RUNS_EARNED + ","
				+ FIELD_PITCHING_RUNS_TOTAL + "," + FIELD_PITCHING_OUTS_KTOTAL + ","
				+ FIELD_PITCHING_STEAL_CAUGHT + "," + FIELD_PITCHING_STEAL_STOLEN + ","
				+ FIELD_PITCHING_GAMES_PLAY + "," + FIELD_PITCHING_GAMES_WIN + ","
				+ FIELD_PITCHING_GAMES_LOSS + "," + FIELD_PITCHING_GAMES_SAVE + ","
				+ FIELD_PITCHING_GAMES_HOLD + "," + FIELD_HITTING_ONBASE_H + ","
				+ FIELD_HITTING_ONBASE_S + "," + FIELD_HITTING_ONBASE_D + ","
				+ FIELD_HITTING_ONBASE_T + "," + FIELD_HITTING_ONBASE_HR + ","
				+ FIELD_HITTING_ONBASE_BB + "," + FIELD_HITTING_RUNS_EARNED + ","
				+ FIELD_HITTING_RUNS_TOTAL + "," + FIELD_HITTING_OUTS_KTOTAL + ","
				+ FIELD_HITTING_STEAL_CAUGHT + "," + FIELD_HITTING_STEAL_STOLEN + ","
				+ FIELD_HITTING_GAMES_PLAY + "," + FIELD_HITTING_GAMES_WIN + ","
				+ FIELD_HITTING_GAMES_LOSS + "," + FIELD_FIELDING_PO + ","
				+ FIELD_FIELDING_ERROR + "," + FIELD_FIELDING_A + ","
				+ FIELD_FIELDING_FPCT + "," + FIELD_FIELDING_GAMES_PLAY + ","
				+ FIELD_FIELDING_GAMES_WIN + "," + FIELD_FIELDING_GAMES_LOSS + ") "
				+ "VALUES (\"" + this.id + "\", " + "\"" + this.first_name + "\", "
				+ "\"" + this.last_name + "\", " + "\"" + this.team_name + "\", " + "\""
				+ this.team_id + "\", " + this.batting_ab + ", " + this.batting_rbi
				+ ", " + this.pitching_era + ", " + this.pitching_onbase_h + ", "
				+ this.pitching_onbase_s + ", " + this.pitching_onbase_d + ", "
				+ this.pitching_onbase_t + ", " + this.pitching_onbase_hr + ", "
				+ this.pitching_onbase_bb + ", " + this.pitching_runs_earned + ", "
				+ this.pitching_runs_total + ", " + this.pitching_outs_ktotal + ", "
				+ this.pitching_steal_caught + ", " + this.pitching_steal_stolen + ", "
				+ this.pitching_games_play + ", " + this.pitching_games_win + ", "
				+ this.pitching_games_loss + ", " + this.pitching_games_save + ", "
				+ this.pitching_games_hold + ", " + this.batting_onbase_h + ", "
				+ this.batting_onbase_s + ", " + this.batting_onbase_d + ", "
				+ this.batting_onbase_t + ", " + this.batting_onbase_hr + ", "
				+ this.batting_onbase_bb + ", " + this.batting_runs_earned + ", "
				+ this.batting_runs_total + ", " + this.batting_outs_ktotal + ", "
				+ this.batting_steal_caught + ", " + this.batting_steal_stolen + ", "
				+ this.batting_games_play + ", " + this.batting_games_win + ", "
				+ this.batting_games_loss + ", " + this.fielding_po + ", "
				+ this.fielding_error + ", " + this.fielding_a + ", "
				+ this.fielding_fpct + ", " + this.fielding_games_play + ", "
				+ this.fielding_games_win + ", " + this.fielding_games_loss + ");";
	}
	
	/**
	 * Obtains a result set containing every MLB Player and then loops through the result
	 * set and adds each player to an array list.
	 * 
	 * @return Array list consisting of all generated players from the result set.
	 */
	public static ArrayList<MlbPlayer> getListOfPlayersFromDatabase()
	{
		ArrayList<MlbPlayer> resultList = new ArrayList<MlbPlayer>();
		
		ResultSet rs = Database.getResultSetFromSQL("SELECT * FROM " + TABLE_NAME);
		if (rs != null)
		{
			try
			{
				while (rs.next())
				{
					MlbPlayer player = new MlbPlayer(rs);
					resultList.add(player);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return resultList;
	}
	
	/**
	 * Gets MLB Players from a database and allows the user the option to apply filters
	 * based on the various fields
	 * 
	 * @param filter
	 *            Holds the filter criteria to be applied by the user
	 * @return A list of MLB Players
	 */
	public static ArrayList<MlbPlayer> getPlayersFromDatabase(MlbPlayerFilter filter)
	{
		ArrayList<MlbPlayer> resultList = new ArrayList<MlbPlayer>();
		
		String sql = "SELECT * FROM " + TABLE_NAME + " " + filter.getWhereClause()
				+ " ORDER BY " + FIELD_TEAM_NAME + ", " + FIELD_FIRSTNAME + ", "
				+ FIELD_LASTNAME;
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		if (rs != null)
		{
			try
			{
				while (rs.next())
				{
					MlbPlayer player = new MlbPlayer(rs);
					resultList.add(player);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		Database.close();
		
		return resultList;
	}
	
	/**
	 * Gets a selected MLB Player by filtering a search from the database with the Id
	 * value that is assigned to all players given that the list of players that are being
	 * searched has at least one player in it
	 * 
	 * @param id
	 *            Attribute assigned to an MLB Player to identify them if selected
	 * @return The MLB Player object that is selected by the user
	 */
	public static MlbPlayer getPlayerForId(String id)
	{
		MlbPlayer result = null;
		
		MlbPlayerFilter filter = new MlbPlayerFilter();
		filter.setIdValue(id);
		
		ArrayList<MlbPlayer> playerList = MlbPlayer.getPlayersFromDatabase(filter);
		if (playerList.size() > 0)
		{
			result = playerList.get(0);
		}
		
		return result;
	}
	
	/**
	 * Initializes data from XML Node
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	public MlbPlayer(Node node)
	{
		loadDataFromNode(node);
	}
	
	/**
	 * Gets the attribute of the node's named item given that the attribute exists.
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param namedItem
	 *            The specific attribute that the node value holds.
	 * @return The namedItem given that it is not null
	 */
	private String getNodesNamedItem(Node node, String namedItem)
	{
		String returnVal = new String("0");
		
		if (node.getAttributes().getNamedItem(namedItem) != null)
		{
			returnVal = node.getAttributes().getNamedItem(namedItem).getNodeValue();
		}
		return returnVal;
	}
	
	/**
	 * Gets the value of the node's named item as a String and then parses the String to a
	 * float.
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param namedItem
	 *            The specific attribute that the node value holds.
	 * @return Value of the node's named item as a float
	 */
	private float getNodesNamedFloat(Node node, String namedItem)
	{
		float result = 0f;
		
		String value = getNodesNamedItem(node, namedItem);
		
		try
		{
			result = Float.parseFloat(value);
		}
		catch (NumberFormatException e)
		{
			result = 0f;
		}
		
		return result;
	}
	
	/**
	 * Gets the value of the node's named item as a String and then parses the String to
	 * an integer.
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param namedItem
	 *            The specific attribute that the node value holds.
	 * @return Value of the node's named item as an integer
	 */
	private int getNodesNamedInt(Node node, String namedItem)
	{
		int result = 0;
		
		String value = getNodesNamedItem(node, namedItem);
		
		try
		{
			result = Integer.parseInt(value);
		}
		catch (NumberFormatException e)
		{
			result = 0;
		}
		
		return result;
	}
	
	/**
	 * Gets the loaded player's general attributes from the node
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	private void loadPlayerData(Node node)
	{
		id = getNodesNamedItem(node, "id");
		first_name = getNodesNamedItem(node, "first_name");
		last_name = getNodesNamedItem(node, "last_name");
	}
	
	/**
	 * Gets the loaded player's team attributes from the node
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	private void loadTeamData(Node node)
	{
		team_id = getNodesNamedItem(node, "id");
		team_name = getNodesNamedItem(node, "name");
	}
	
	/**
	 * Gets the loaded player's batting attributes from the node
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	private void loadHittingData(Node node)
	{
		batting_ab = getNodesNamedInt(node, "ab");
		batting_rbi = getNodesNamedInt(node, "rbi");
	}
	
	/**
	 * Gets the loaded player's pitching attributes from the node
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	private void loadPitchingData(Node node)
	{
		pitching_era = getNodesNamedFloat(node, "era");
	}
	
	/**
	 * Gets the loaded player's fielding attributes from the node
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	private void loadFieldingData(Node node)
	{
		fielding_po = getNodesNamedInt(node, "po");
		fielding_error = getNodesNamedInt(node, "error");
		fielding_a = getNodesNamedInt(node, "a");
		fielding_fpct = getNodesNamedInt(node, "fpct");
	}
	
	/**
	 * Gets the data of all "on-base" statistics based on the field that the player is
	 * classified as
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param parentNodeName
	 *            Used to determine the field that player is classified under: batting or
	 *            pitching
	 */
	private void loadOnbaseData(Node node, String parentNodeName)
	{
		if (parentNodeName.equals("hitting"))
		{
			batting_onbase_h = getNodesNamedInt(node, "h");
			batting_onbase_s = getNodesNamedInt(node, "s");
			batting_onbase_d = getNodesNamedInt(node, "d");
			batting_onbase_t = getNodesNamedInt(node, "t");
			batting_onbase_hr = getNodesNamedInt(node, "hr");
			batting_onbase_bb = getNodesNamedInt(node, "bb");
		}
		else if (parentNodeName.equals("pitching"))
		{
			pitching_onbase_h = getNodesNamedInt(node, "h");
			pitching_onbase_s = getNodesNamedInt(node, "s");
			pitching_onbase_d = getNodesNamedInt(node, "d");
			pitching_onbase_t = getNodesNamedInt(node, "t");
			pitching_onbase_hr = getNodesNamedInt(node, "hr");
			pitching_onbase_bb = getNodesNamedInt(node, "bb");
		}
	}
	
	/**
	 * Gets the data of all "runs" statistics based on the field that the player is
	 * classified as
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param parentNodeName
	 *            Used to determine the field that player is classified under: batting or
	 *            pitching
	 */
	private void loadRunsData(Node node, String parentNodeName)
	{
		if (parentNodeName.equals("hitting"))
		{
			batting_runs_earned = getNodesNamedInt(node, "earned");
			batting_runs_total = getNodesNamedInt(node, "total");
		}
		else if (parentNodeName.equals("pitching"))
		{
			pitching_runs_earned = getNodesNamedInt(node, "earned");
			pitching_runs_total = getNodesNamedInt(node, "total");
		}
	}
	
	/**
	 * Gets the data of all "Strike-outs" statistics based on the field that the player is
	 * classified as
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param parentNodeName
	 *            Used to determine the field that player is classified under: batting or
	 *            pitching
	 */
	private void loadStrikeOutsData(Node node, String parentNodeName)
	{
		if (parentNodeName.equals("hitting"))
		{
			batting_outs_ktotal = getNodesNamedInt(node, "ktotal");
		}
		else if (parentNodeName.equals("pitching"))
		{
			pitching_outs_ktotal = getNodesNamedInt(node, "ktotal");
		}
	}
	
	/**
	 * Gets the data of all "Steals" statistics based on the field that the player is
	 * classified as
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param parentNodeName
	 *            Used to determine the field that player is classified under: batting or
	 *            pitching
	 */
	private void loadStealData(Node node, String parentNodeName)
	{
		if (parentNodeName.equals("hitting"))
		{
			batting_steal_caught = getNodesNamedInt(node, "caught");
			batting_steal_stolen = getNodesNamedInt(node, "stolen");
		}
		else if (parentNodeName.equals("pitching"))
		{
			pitching_steal_caught = getNodesNamedInt(node, "caught");
			pitching_steal_stolen = getNodesNamedInt(node, "stolen");
		}
	}
	
	/**
	 * Gets the data of all "Games" statistics based on the field that the player is
	 * classified as
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param parentNodeName
	 *            Used to determine the field that player is classified under: batting,
	 *            pitching, or fielding
	 */
	private void loadGamesData(Node node, String parentNodeName)
	{
		if (parentNodeName.equals("hitting"))
		{
			batting_games_play = getNodesNamedInt(node, "play");
			batting_games_win = getNodesNamedInt(node, "win");
			batting_games_loss = getNodesNamedInt(node, "loss");
		}
		else if (parentNodeName.equals("pitching"))
		{
			pitching_games_play = getNodesNamedInt(node, "play");
			pitching_games_win = getNodesNamedInt(node, "win");
			pitching_games_loss = getNodesNamedInt(node, "loss");
			pitching_games_save = getNodesNamedInt(node, "save");
			pitching_games_hold = getNodesNamedInt(node, "hold");
		}
		else if (parentNodeName.equals("fielding"))
		{
			fielding_games_play = getNodesNamedInt(node, "play");
			fielding_games_win = getNodesNamedInt(node, "win");
			fielding_games_loss = getNodesNamedInt(node, "loss");
		}
	}
	
	/**
	 * Obtains a result set containing every player's statistics and then loops through
	 * the result set and adds each player to an array list.
	 * 
	 * @param localPlayerId
	 *            Identifier used for all local players.
	 * @return Array list consisting of all generated players from the result set.
	 */
	public static ArrayList<MlbPlayer> getStatisticsFromDatabase(String id_in)
	{
		ArrayList<MlbPlayer> resultList = new ArrayList<MlbPlayer>();
		
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_ID + " = \""
				+ id_in.toString() + "\"" + " ORDER BY " + FIELD_ID;
		ResultSet resultSet = Database.getResultSetFromSQL(sql);
		
		if (resultSet != null)
		{
			try
			{
				while (resultSet.next())
				{
					MlbPlayer player = new MlbPlayer(resultSet);
					resultList.add(player);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		Database.close();
		
		return resultList;
	}
	
	/**
	 * First gets the player's data and then gets the team data based on the player
	 * followed by identifying the child tag (i.e. their classifications) then gets the
	 * parent node's name and loads that data based on the attributes that were relevant
	 * to its child tag
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	public void loadDataFromNode(Node node)
	{
		loadPlayerData(node);
		
		NodeList child1Nodes = node.getChildNodes();
		for (int j = 0; j < child1Nodes.getLength(); j++)
		{
			Node teamNode = child1Nodes.item(j);
			if (teamNode instanceof Element)
			{
				loadTeamData(teamNode);
				
				NodeList child2Nodes = teamNode.getChildNodes();
				for (int k = 0; k < child2Nodes.getLength(); k++)
				{
					Node c1Node = child2Nodes.item(k);
					if (c1Node instanceof Element)
					{
						String parentNodeName = null;
						
						switch (c1Node.getNodeName())
						{
							case "hitting":
								loadHittingData(c1Node);
								break;
							case "pitching":
								loadPitchingData(c1Node);
								break;
							case "fielding":
								loadFieldingData(c1Node);
								break;
						}
						
						parentNodeName = c1Node.getNodeName();
						
						NodeList child3Nodes = c1Node.getChildNodes();
						for (int l = 0; l < child3Nodes.getLength(); l++)
						{
							Node c2Node = child3Nodes.item(l);
							if (c2Node instanceof Element)
							{
								switch (c2Node.getNodeName())
								{
									case "onbase":
										loadOnbaseData(c2Node, parentNodeName);
										break;
									case "runs":
										loadRunsData(c2Node, parentNodeName);
										break;
									case "outs":
										loadStrikeOutsData(c2Node, parentNodeName);
										break;
									case "steal":
										loadStealData(c2Node, parentNodeName);
										break;
									case "games":
										loadGamesData(c2Node, parentNodeName);
										break;
								}
							}
						}
					}
				}
			}
		}
	}
}
