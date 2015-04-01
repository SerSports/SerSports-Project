package database;

import java.rmi.server.*;
import java.rmi.*;
import java.text.NumberFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalPlayerStatistics {
	
	//batting Constants
	private static final String TABLE_NAME = "localPlayersHittingStatistics";		//localPlayersHittingStatistics
	private static final String FIELD_ID = "localPlayerID";  						//localPlayerID
	//private static final String FIELD_TEAM_NAME = "team_name";						//team_name
	//private static final String FIELD_POSITION = "position";						//position
	private static final String FIELD_GAME_DATE = "game_date";						//date user played entered game (date)
	private static final String FIELD_HITTING_AB = "hitting_ab"; 					//at-bat (ab)
	private static final String FIELD_HITTING_RBI = "hitting_rbi"; 					//runs batted in (rbi)
	private static final String FIELD_HITTING_ONBASE_H = "hitting_onbase_h";		//hits (landed on base) (h)
	private static final String FIELD_HITTING_ONBASE_S = "hitting_onbase_s";		//single (1B)
	private static final String FIELD_HITTING_ONBASE_D = "hitting_onbase_d";		//double (2B)
	private static final String FIELD_HITTING_ONBASE_T = "hitting_onbase_t";		//triple (3B)
	private static final String FIELD_HITTING_ONBASE_HR = "hitting_onbase_hr";		//home run (hr)
	private static final String FIELD_HITTING_RUNS_TOTAL = "hitting_runs_total"; 	//total runs (runs)
	private static final String FIELD_HITTING_OUTS_KTOTAL = "hitting_outs_ktotal";  //strikes out (so)
	private static final String FIELD_HITTING_STEAL_STOLEN = "hitting_steal_stolen"; //stolen base (sb)
	private static final String FIELD_HITTING_GAMES_PLAY = "hitting_games_play";	//games play (gp)


    //pitching constants
    private static final String TABLE_NAME_P = "localPlayersPitchingStatistics";
	//private static final String FIELD_ID = "localPlayerId";
	//private static final String FIELD_TEAM_NAME = "team_name";
	//private static final String FIELD_POSITION = "position";
	//private static final String FIELD_GAME_DATE = "game_date";
	private static final String FIELD_PITCHING_GAMES_PLAY = "pitching_games_play";  //games played (gp)
	private static final String FIELD_PITCHING_GAMES_WIN = "pitching_games_win";	//win (w)
	private static final String FIELD_PITCHING_GAMES_LOSS = "pitching_games_loss";  //loss (l)
	private static final String FIELD_PITCHING_ERA = "pitching_era";				//Earned run average overall/per season (era)
	private static final String FIELD_PITCHING_GAMES_SAVE = "pitching_games_save";  //as in saves the game (save)
	private static final String FIELD_PITCHING_GAMES_HIT = "pitching_games_hit";	//hits allowed (hit) 
	private static final String FIELD_PITCHING_GAMES_HOLD = "pitching_games_hold";  //holds (hold)
	private static final String FIELD_PITCHING_RUNS_TOTAL = "pitching_runs_total";  //runs allowed in one game (runs) 
	private static final String FIELD_PITCHING_HBP = "pitching_hbp"; 				//hits by pitch (hbp)
	
	
	//fielding constants
	private static final String TABLE_NAME_F = "localPlayersFieldingStatistics";
	//private static final String FIELD_ID = "localPlayerId";
	//private static final String FIELD_TEAM_NAME = "team_name";
	//private static final String FIELD_POSITION = "position";
	//private static final String FIELD_GAME_DATE = "game_date";
	private static final String FIELD_FIELDING_GAMES_PLAY = "fielding_games_play";	//games play (gp)
	private static final String FIELD_FIELDING_GAMES_WIN = "fielding_games_win";	//game won (w)
    private static final String FIELD_FIELDING_GAMES_LOSS = "fielding_games_loss";	//game lost (l)
	private static final String FIELD_FIELDING_PO = "fielding_po";					//putout (po)
    private static final String FIELD_FIELDING_ERROR = "fielding_error";			//error
    private static final String FIELD_FIELDING_ASSIST = "fielding_assist";			//assist
    private static final String FIELD_FIELDING_FPCT = "fielding_fpct";				//fielding percentage
    	
    	
	
    
	// constructor
	public LocalPlayerStatistics() {
		
	}
	
	// get all the local player's batting statistics
	public static void setLocalPlayerBattingStatistics(String date, String gp, String ab, String h, String rbi,
			String b1, String b2, String b3, String runs, String sb, String hr, String so) {

		int igp, iab, ih, irbi, ib1, ib2, ib3, iruns, isb, ihr, iso;
		try{
			//parse strings into integers where appropriate
			igp = Integer.parseInt(gp);
			iab = Integer.parseInt(ab);
			ih = Integer.parseInt(h);
			irbi = Integer.parseInt(rbi);
			ib1 = Integer.parseInt(b1);
			ib2 = Integer.parseInt(b2);
			ib3 = Integer.parseInt(b3);
			iruns = Integer.parseInt(runs);
			isb = Integer.parseInt(sb);
			ihr = Integer.parseInt(hr);
			iso = Integer.parseInt(so);
		
			/*
			 * NOTE: local variables which may need columns added in LocalPlayer table
			 */
			//String teamName = null;
			//String position = "Batting";
		
			//get username/id
			User currentUser = User.getCurrentUser();
        
			Database.executeSQL("INSERT INTO " + TABLE_NAME + 
        		"(" + FIELD_ID + ", " + FIELD_GAME_DATE + ", "
        			+ FIELD_HITTING_AB + ", " + FIELD_HITTING_RBI + ", " 
        		    + FIELD_HITTING_ONBASE_H + ", " + FIELD_HITTING_ONBASE_S + ", "
        			+ FIELD_HITTING_ONBASE_D + ", " + FIELD_HITTING_ONBASE_T + ", " 
        			+ FIELD_HITTING_ONBASE_HR + ", " + FIELD_HITTING_RUNS_TOTAL + ", " 
        		    + FIELD_HITTING_OUTS_KTOTAL + ", " + FIELD_HITTING_STEAL_STOLEN + ", " 
        			+ FIELD_HITTING_GAMES_PLAY + ") " +
        		  "VALUES (\"" + currentUser.getLocalPlayerId() + "\", " + "\"" + date + "\", " 
        			+ "\"" + iab + "\", " + "\"" + irbi + "\", " 
        		    + "\"" + ih + "\", " + "\"" + ib1 + "\", " 
        			+ "\"" + ib2 + "\", " + "\"" + ib3 + "\", " 
        			+ "\"" + ihr + "\", " + "\"" + iruns + "\", " 
        			+ "\"" + iso + "\", " + "\"" + isb + "\", " 
        			+ "\"" + igp + "\");");
        
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// get all the local player's fielding statistics
	public static void setLocalPlayerFieldingStatistics(String date, String gp, String w, String l, String po,
			String error, String assist, String fpct) {
		
		int igp, iw, il, ipo, ierror, iassist, ifpct;
		try{
			//parse strings into integers where appropriate
			igp = Integer.parseInt(gp);
			iw = Integer.parseInt(w);
			il = Integer.parseInt(l);
			ipo = Integer.parseInt(po);
			ierror = Integer.parseInt(error);
			iassist = Integer.parseInt(assist);
			ifpct = Integer.parseInt(fpct);
		
			/*
			 * NOTE: local variables which may need columns added in LocalPlayer table
			 */
			//String teamName = null;
			//String position = "Fielding";
		
			//get username/id
			User currentUser = User.getCurrentUser();
        
			Database.executeSQL("INSERT INTO " + TABLE_NAME_F + 
        		"(" + FIELD_ID + ", " + FIELD_GAME_DATE + ", "
        			+ FIELD_FIELDING_GAMES_PLAY + ", " + FIELD_FIELDING_GAMES_WIN + ", " 
        		    + FIELD_FIELDING_GAMES_LOSS + ", " + FIELD_FIELDING_PO + ", "
        			+ FIELD_FIELDING_ERROR + ", " + FIELD_FIELDING_ASSIST + ", " 
        			+ FIELD_FIELDING_FPCT + ") " +
        		  "VALUES (\"" + currentUser.getLocalPlayerId() + "\", " + "\"" + date + "\", " 
        			+ "\"" + igp + "\", " + "\"" + iw + "\", " 
        		    + "\"" + il + "\", " + "\"" + ipo + "\", " 
        			+ "\"" + ierror + "\", " + "\"" + iassist + "\", " 
        			+ "\"" + ifpct + "\");");
        
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// get all the local player's pitching statistics
	public static void setLocalPlayerPitchingStatistics(String date, String gp, String w, String l, String era,
			String saves, String hits, String holds, String runs, String hbp) {
		
		int igp, iw, il, iera, isaves, ihits, iholds, iruns, ihbp;
		try{
			//parse strings into integers where appropriate
			igp = Integer.parseInt(gp);
			iw = Integer.parseInt(w);
			il = Integer.parseInt(l);
			iera = Integer.parseInt(era);
			isaves = Integer.parseInt(saves);
			ihits = Integer.parseInt(hits);
			iholds = Integer.parseInt(holds);
			iruns = Integer.parseInt(runs);
			ihbp = Integer.parseInt(hbp);

		
			/*
			 * NOTE: local variables which may need columns added in LocalPlayer table
			 */
			//String teamName = null;
			//String position = "Pitching";
		
			//get username/id
			User currentUser = User.getCurrentUser();
        
			Database.executeSQL("INSERT INTO " + TABLE_NAME_P + 
        		"(" + FIELD_ID + ", " + FIELD_GAME_DATE + ", "
        			+ FIELD_PITCHING_GAMES_PLAY + ", " + FIELD_PITCHING_GAMES_WIN + ", " 
        		    + FIELD_PITCHING_GAMES_LOSS + ", " + FIELD_PITCHING_ERA + ", "
        			+ FIELD_PITCHING_GAMES_SAVE + ", " + FIELD_PITCHING_GAMES_HIT + ", " 
        			+ FIELD_PITCHING_GAMES_HOLD + ", " + FIELD_PITCHING_RUNS_TOTAL + ", " 
        		    + FIELD_PITCHING_HBP + ") " +
        		  "VALUES (\"" + currentUser.getLocalPlayerId() + "\", " + "\"" + date + "\", " 
        			+ "\"" + igp + "\", " + "\"" + iw + "\", " 
        		    + "\"" + il + "\", " + "\"" + iera + "\", " 
        			+ "\"" + isaves + "\", " + "\"" + ihits + "\", " 
        			+ "\"" + iholds + "\", " + "\"" + iruns + "\", " 
        			+ "\"" + ihbp + "\");");
        
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// get all the local player's batting statistics
	public static ArrayList<LocalPlayerStatistics> getListOfLocalPlayerBattingStatistics() {
		ArrayList<LocalPlayerStatistics> result = new ArrayList<LocalPlayerStatistics>();
		// return only batting stats
		
		//Database.executeSQL("SELECT * FROM localPlayersHittingStatistics WHERE localPlayerID = " + currentUser.getLocalPlayerId());
		
		return result;
	}

	// get all the local player's fielding statistics
	public static ArrayList<LocalPlayerStatistics> getListOfLocalPlayerFieldingStatistics() {
		ArrayList<LocalPlayerStatistics> result = new ArrayList<LocalPlayerStatistics>();
		// return only fielding stats
		return result;
	}

	// get all the local player's pitching statistics
	public static ArrayList<LocalPlayerStatistics> getListOfLocalPlayerPitchingStatistics() {
		ArrayList<LocalPlayerStatistics> result = new ArrayList<LocalPlayerStatistics>();
		// return only pitching stats
		return result;
	}
}
