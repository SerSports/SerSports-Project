/*
File: MlbPlayerStatistics.java
Author:	Ashley Mannon
Date:	

Description: GUI for displaying/searching the Local Players database

*/
package database;

import java.rmi.server.*;
import java.rmi.*;
import java.text.NumberFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MlbPlayerStatistics {
	private User currentUser = null;

	// constructor
	public MlbPlayerStatistics() {
	}
	
	// get all the Mlb player's batting statistics
	public static void setMlbUserBattingStatistics(String[] battingStatistics) {
		// set only batting stats
		//battingStatistics = {currentMlbPlayerId, date, gp, ab, h, rbi, b1, b2, b3, runs, sb, hr, so};
		
		LocalMLBPlayer temp = new LocalMLBPlayer();
		
		temp.setId(battingStatistics[0]);
		temp.setGame_date(battingStatistics[1]);
		temp.setHitting_games_play(battingStatistics[2]);
		temp.setHitting_ab(battingStatistics[3]);
		temp.setHitting_onbase_h(battingStatistics[4]);
		temp.setHitting_rbi(battingStatistics[5]);
		temp.setHitting_onbase_s(battingStatistics[6]);
		temp.setHitting_onbase_d(battingStatistics[7]);
		temp.setHitting_onbase_t(battingStatistics[8]);
		temp.setHitting_runs_total(battingStatistics[9]);
		temp.setHitting_steal_stolen(battingStatistics[10]);
		temp.setHitting_onbase_hr(battingStatistics[11]);
		temp.setHitting_outs_ktotal(battingStatistics[12]);

	}

	// get all the Mlb player's fielding statistics
	public static void setMlbUserFieldingStatistics() {
		// set only fielding stats
	}

	// get all the Mlb player's pitching statistics
	public static void setMlbUserPitchingStatistics() {
		// set only pitching stats
	}

	// get all the Mlb player's batting statistics
	public static ArrayList<MlbPlayerStatistics> getListOfMlbUserBattingStatistics() {
		ArrayList<MlbPlayerStatistics> result = new ArrayList<MlbPlayerStatistics>();
		// return only batting stats
		return result;
	}

	// get all the Mlb player's fielding statistics
	public static ArrayList<MlbPlayerStatistics> getListOfMlbUserFieldingStatistics() {
		ArrayList<MlbPlayerStatistics> result = new ArrayList<MlbPlayerStatistics>();
		// return only fielding stats
		return result;
	}

	// get all the Mlb player's pitching statistics
	public static ArrayList<MlbPlayerStatistics> getListOfMlbUserPitchingStatistics() {
		ArrayList<MlbPlayerStatistics> result = new ArrayList<MlbPlayerStatistics>();
		// return only pitching stats
		return result;
	}
}

