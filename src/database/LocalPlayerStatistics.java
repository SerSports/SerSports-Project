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
	public static void setLocalUserBattingStatistics() {
		// set only batting stats
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
	public static ArrayList<LocalPlayerStatistics> getLocalUserBattingStatistics() {
		ArrayList<LocalPlayerStatistics> result = new ArrayList<LocalPlayerStatistics>();
		// return only batting stats
		return result;
	}

	// get all the local player's fielding statistics
	public static ArrayList<LocalPlayerStatistics> getLocalUserFieldingStatistics() {
		ArrayList<LocalPlayerStatistics> result = new ArrayList<LocalPlayerStatistics>();
		// return only fielding stats
		return result;
	}

	// get all the local player's pitching statistics
	public static ArrayList<LocalPlayerStatistics> getLocalUserPitchingStatistics() {
		ArrayList<LocalPlayerStatistics> result = new ArrayList<LocalPlayerStatistics>();
		// return only pitching stats
		return result;
	}
}
