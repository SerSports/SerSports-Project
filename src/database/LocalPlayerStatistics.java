package database;

import java.rmi.server.*;
import java.rmi.*;
import java.text.NumberFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalPlayerStatistics {
	private User currentUser = null;

	// constructor
	public LocalPlayerStatistics() {
	}
	
	// get all the local player's batting statistics
	public static void setLocalUserBattingStatistics(String[] battingStatistics) {
		// set only batting stats
		//battingStatistics = {currentLocalPlayerId, date, gp, ab, h, rbi, b1, b2, b3, runs, sb, hr, so};
		
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
		/*setHitting_onbase_bb;
		setHitting_runs_earned;
		setHitting_steal_caught;*/
		
		/*
		String tmp = new String("INSERT INTO " + TABLE_NAME + 
			 	" (" + FIELD_ID + ", " + FIELD_GAMES_PLAY + ", " + FIELD_HITTING_AB
			 	     + FIELD_HITTING_ONBASE_H + FIELD_HITTING_RBI + FIELD_HITTING_ONBASE_S
			 	     + FIELD_HITTING_ONBASE_D + FIELD_HITTING_ONBASE_T + FIELD_HITTING_RUNS_TOTAL
			 	     + FIELD_HITTING_STEAL_STOLEN + FIELD_HITTING_ONBASE_HR + FIELD_OUTS_KTOTAL + ") " + 
		      "VALUES("+ temp.getId() + ", \"" + temp.getGame_date() + temp.getHitting_ab() + ", \"" +
			 	     temp.getHitting_onbase_h() + ", \"" + temp.getHitting_rbi() + ", \"" +
			 	     temp.getHitting_onbase_s() + ", \"" + temp.getHitting_onbase_d() + ", \"" +
			 	     temp.getHitting_onbase_t() + ", \"" + temp.getHitting_runs_total() + ", \"" +
			 	     temp.getHitting_steal_stolen() + ", \"" + temp.getHitting_onbase_hr() + ", \"" +
			 	     temp.getHitting_outs_ktotal() + "\")");
		*/
	}

	// get all the local player's fielding statistics
	public static void setLocalUserFieldingStatistics() {
		// set only fielding stats
	}

	// get all the local player's pitching statistics
	public static void setLocalUserPitchingStatistics() {
		// set only pitching stats
	}

	// get all the local player's batting statistics
	public static ArrayList<LocalPlayerStatistics> getListOfLocalUserBattingStatistics() {
		ArrayList<LocalPlayerStatistics> result = new ArrayList<LocalPlayerStatistics>();
		// return only batting stats
		return result;
	}

	// get all the local player's fielding statistics
	public static ArrayList<LocalPlayerStatistics> getListOfLocalUserFieldingStatistics() {
		ArrayList<LocalPlayerStatistics> result = new ArrayList<LocalPlayerStatistics>();
		// return only fielding stats
		return result;
	}

	// get all the local player's pitching statistics
	public static ArrayList<LocalPlayerStatistics> getListOfLocalUserPitchingStatistics() {
		ArrayList<LocalPlayerStatistics> result = new ArrayList<LocalPlayerStatistics>();
		// return only pitching stats
		return result;
	}
}
