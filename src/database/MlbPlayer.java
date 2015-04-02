/*
File: MLBPlayer.java
Author:	
Date:	

Description: Creates a MLB Player Object with player stats and info

 */
package database;

import java.rmi.server.*;
import java.rmi.*;
import java.text.NumberFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
Class:	MLBPlayer

Description: Creates MLBPlayer Object
*/
public class MlbPlayer extends Object implements java.io.Serializable {
	
	// Constants
	private static final String TABLE_NAME = "MlbPlayers";  
	private static final String FIELD_ID = "mlbPlayerId";  
	private static final String FIELD_FIRSTNAME = "firstName";  
	private static final String FIELD_LASTNAME = "lastName";  
	private static final String FIELD_TEAM_NAME = "team_name";  
	private static final String FIELD_TEAM_ID = "team_id";				
	 			
	private static final String FIELD_PITCHING_ERA = "pitching_era"; 		
	private static final String FIELD_PITCHING_ONBASE_H = "pitching_onbase_h";	
	private static final String FIELD_PITCHING_ONBASE_S = "pitching_onbase_s";	
	private static final String FIELD_PITCHING_ONBASE_D = "pitching_onbase_d";	
	private static final String FIELD_PITCHING_ONBASE_T = "pitching_onbase_t";	
	private static final String FIELD_PITCHING_ONBASE_HR = "pitching_onbase_hr";	
	private static final String FIELD_PITCHING_ONBASE_BB = "pitching_onbase_bb";	
	private static final String FIELD_PITCHING_RUNS_EARNED = "pitching_runs_earned";  
	private static final String FIELD_PITCHING_RUNS_TOTAL = "pitching_runs_total"; 	
    private static final String FIELD_PITCHING_OUTS_KTOTAL = "pitching_outs_ktotal"; 
    private static final String FIELD_PITCHING_STEAL_CAUGHT = "pitching_steal_caught";
    private static final String FIELD_PITCHING_STEAL_STOLEN = "pitching_steal_stolen";
    private static final String FIELD_PITCHING_GAMES_PLAY = "pitching_games_play";	
    private static final String FIELD_PITCHING_GAMES_WIN = "pitching_games_win";	
    private static final String FIELD_PITCHING_GAMES_LOSS = "pitching_games_loss";	
    private static final String FIELD_PITCHING_GAMES_SAVE = "pitching_games_save";	
    private static final String FIELD_PITCHING_GAMES_HOLD = "pitching_games_hold"; 	
    
    private static final String FIELD_HITTING_AB = "hitting_ab"; 			
	private static final String FIELD_HITTING_RBI = "hitting_rbi";
    private static final String FIELD_HITTING_ONBASE_H = "hitting_onbase_h";		
    private static final String FIELD_HITTING_ONBASE_S = "hitting_onbase_s";		
    private static final String FIELD_HITTING_ONBASE_D = "hitting_onbase_d";		
    private static final String FIELD_HITTING_ONBASE_T = "hitting_onbase_t";		
    private static final String FIELD_HITTING_ONBASE_HR = "hitting_onbase_hr";	
    private static final String FIELD_HITTING_ONBASE_BB = "hitting_onbase_bb";	
    private static final String FIELD_HITTING_RUNS_EARNED = "hitting_runs_earned"; 	 
    private static final String FIELD_HITTING_RUNS_TOTAL = "hitting_runs_total"; 	
    private static final String FIELD_HITTING_OUTS_KTOTAL = "hitting_outs_ktotal"; 	
    private static final String FIELD_HITTING_STEAL_CAUGHT = "hitting_steal_caught"; 
    private static final String FIELD_HITTING_STEAL_STOLEN = "hitting_steal_stolen"; 
    private static final String FIELD_HITTING_GAMES_PLAY = "hitting_games_play";	
    private static final String FIELD_HITTING_GAMES_WIN = "hitting_games_win";	
    private static final String FIELD_HITTING_GAMES_LOSS = "hitting_games_loss";
    
    private static final String FIELD_FIELDING_PO = "fielding_po";			
    private static final String FIELD_FIELDING_ERROR = "fielding_error";		
    private static final String FIELD_FIELDING_A = "fielding_a";			
    private static final String FIELD_FIELDING_FPCT = "fielding_fpct";		
    private static final String FIELD_FIELDING_GAMES_PLAY = "fielding_games_play";	
    private static final String FIELD_FIELDING_GAMES_WIN = "fielding_games_win";	
    private static final String FIELD_FIELDING_GAMES_LOSS = "fielding_games_loss";	
	
	// Members
	private String id;
	private String first_name; 			//Player First Name
	private String last_name; 			//Player Last Name

	private String team_id;				//Team ID
	private String team_name;			//Team name
    
	private float pitching_era; 		//Pitching ERA
	private int pitching_onbase_h;		//Batting H
	private int pitching_onbase_s;		//Batting 1B single
	private int pitching_onbase_d;		//Batting 2B double
	private int pitching_onbase_t;		//Batting 3B triple
	private int pitching_onbase_hr;		//Batting HR home-runs
	private int pitching_onbase_bb;		//Pitching BB
	private int pitching_runs_earned; 	//Pitching ER 
	private int pitching_runs_total; 	//Pitching R
    private int pitching_outs_ktotal; 	//Batting outs SO
    private int pitching_steal_caught; 	// steals Stolen SB
    private int pitching_steal_stolen; 	// steals Stolen SB
    private int pitching_games_play;	// GP games played //Fielding//Pitching//Batting hitting_games_play
    private int pitching_games_win;		//Pitching: W
    private int pitching_games_loss;	//Pitching: L
    private int pitching_games_save;	//Pitching: Saves
    private int pitching_games_hold; 	//Pitching:Hold
    
    
    private int hitting_ab; 			//Batting AB
	private int hitting_rbi; 			//Batting RBI	
	private int hitting_onbase_h;		//Hitting H
    private int hitting_onbase_s;		//Hitting 1B single
    private int hitting_onbase_d;		//Hitting 2B double
    private int hitting_onbase_t;		//Hitting 3B triple
    private int hitting_onbase_hr;		//Hitting HR home-runs
    private int hitting_onbase_bb;		//Hitting BB
    private int hitting_runs_earned; 	//Hitting ER 
    private int hitting_runs_total; 	//Hitting R
    private int hitting_outs_ktotal; 	//Hitting outs SO
    private int hitting_steal_caught; 	//Hitting steals Stolen SB
    private int hitting_steal_stolen; 	//Hitting steals Stolen SB
    private int hitting_games_play;		//Hitting GP games played
    private int hitting_games_win;		//Hitting: W
    private int hitting_games_loss;		//Hitting: L

    private int fielding_po;			//Fielding Putouts
    private int fielding_error;			//Fielding Error
    private int fielding_a;				//Fielding Assists
    private float fielding_fpct;		//Fielding Fielding Percentage
    private int fielding_games_play;	//Fielding GP games played
    private int fielding_games_win;		//Fielding: W
    private int fielding_games_loss;	//Fielding: L
	
    /**
	  Method: Constructor
	  Inputs: ResultSet rs
	  Returns:

	  Description: 
	*/
	public MlbPlayer(ResultSet rs) {
		try {
			// Load the rs's information
			this.id = rs.getString(FIELD_ID);
			this.first_name = rs.getString(FIELD_FIRSTNAME);
			this.last_name = rs.getString(FIELD_LASTNAME);
			this.team_name = rs.getString(FIELD_TEAM_NAME);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Getters / Setters
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	public String getTeam() {
		return team_name;
	}

	public void setTeam(String team) {
		this.team_name = team;
	}
	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getTeam_id() {
		return team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public float getPitching_era() {
		return pitching_era;
	}

	public int getPitching_onbase_h() {
		return pitching_onbase_h;
	}

	public int getPitching_onbase_s() {
		return pitching_onbase_s;
	}

	public int getPitching_onbase_d() {
		return pitching_onbase_d;
	}

	public int getPitching_onbase_t() {
		return pitching_onbase_t;
	}

	public int getPitching_onbase_hr() {
		return pitching_onbase_hr;
	}

	public int getPitching_onbase_bb() {
		return pitching_onbase_bb;
	}

	public int getPitching_runs_earned() {
		return pitching_runs_earned;
	}

	public int getPitching_runs_total() {
		return pitching_runs_total;
	}

	public int getPitching_outs_ktotal() {
		return pitching_outs_ktotal;
	}

	public int getPitching_steal_caught() {
		return pitching_steal_caught;
	}

	public int getPitching_steal_stolen() {
		return pitching_steal_stolen;
	}

	public int getPitching_games_play() {
		return pitching_games_play;
	}

	public int getPitching_games_win() {
		return pitching_games_win;
	}

	public int getPitching_games_loss() {
		return pitching_games_loss;
	}

	public int getPitching_games_save() {
		return pitching_games_save;
	}

	public int getPitching_games_hold() {
		return pitching_games_hold;
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

	public int getHitting_onbase_bb() {
		return hitting_onbase_bb;
	}

	public int getHitting_runs_earned() {
		return hitting_runs_earned;
	}

	public int getHitting_runs_total() {
		return hitting_runs_total;
	}

	public int getHitting_outs_ktotal() {
		return hitting_outs_ktotal;
	}

	public int getHitting_steal_caught() {
		return hitting_steal_caught;
	}

	public int getHitting_steal_stolen() {
		return hitting_steal_stolen;
	}

	public int getHitting_games_play() {
		return hitting_games_play;
	}

	public int getHitting_games_win() {
		return hitting_games_win;
	}

	public int getHitting_games_loss() {
		return hitting_games_loss;
	}

	public int getFielding_po() {
		return fielding_po;
	}

	public int getFielding_error() {
		return fielding_error;
	}

	public int getFielding_a() {
		return fielding_a;
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
	
	// Methods
	public boolean saveMlbPlayerToDatabase() {
		boolean result = false;
		String sql = null;
		
		// Save this is a new record
		sql = buildInsertSql();
		
		// Execute the command
		result = Database.executeSQL(sql);
		
		return result;
	}
	
	private String buildInsertSql() {
		return "INSERT INTO " + TABLE_NAME + 
				"(" + FIELD_ID + ", " + FIELD_FIRSTNAME + "," +  
					FIELD_LASTNAME + "," + FIELD_TEAM_NAME + "," +  
					FIELD_TEAM_ID + "," + FIELD_HITTING_AB + "," +
					FIELD_HITTING_RBI + "," + FIELD_PITCHING_ERA + "," +
					FIELD_PITCHING_ONBASE_H + "," + FIELD_PITCHING_ONBASE_S + "," +
					FIELD_PITCHING_ONBASE_D + "," + FIELD_PITCHING_ONBASE_T + "," +
					FIELD_PITCHING_ONBASE_HR + "," + FIELD_PITCHING_ONBASE_BB + "," +
					FIELD_PITCHING_RUNS_EARNED + "," + FIELD_PITCHING_RUNS_TOTAL + "," +
					FIELD_PITCHING_OUTS_KTOTAL + "," + FIELD_PITCHING_STEAL_CAUGHT + "," +
					FIELD_PITCHING_STEAL_STOLEN + "," + FIELD_PITCHING_GAMES_PLAY + "," +
					FIELD_PITCHING_GAMES_WIN + "," + FIELD_PITCHING_GAMES_LOSS + "," +
					FIELD_PITCHING_GAMES_SAVE + "," + FIELD_PITCHING_GAMES_HOLD + "," +
					FIELD_HITTING_ONBASE_H + "," + FIELD_HITTING_ONBASE_S + "," +
					FIELD_HITTING_ONBASE_D + "," + FIELD_HITTING_ONBASE_T + "," +
					FIELD_HITTING_ONBASE_HR + "," + FIELD_HITTING_ONBASE_BB + "," +
					FIELD_HITTING_RUNS_EARNED + "," + FIELD_HITTING_RUNS_TOTAL + "," +
					FIELD_HITTING_OUTS_KTOTAL + "," + FIELD_HITTING_STEAL_CAUGHT + "," +
					FIELD_HITTING_STEAL_STOLEN + "," + FIELD_HITTING_GAMES_PLAY + "," +
					FIELD_HITTING_GAMES_WIN + "," + FIELD_HITTING_GAMES_LOSS + "," +
					FIELD_FIELDING_PO + "," + FIELD_FIELDING_ERROR + "," +
					FIELD_FIELDING_A + "," + FIELD_FIELDING_FPCT + "," +
					FIELD_FIELDING_GAMES_PLAY + "," + FIELD_FIELDING_GAMES_WIN + "," +
					FIELD_FIELDING_GAMES_LOSS + ") " + 
				"VALUES (\"" + this.id + "\", " + "\"" + this.first_name + "\", " +
					"\"" + this.last_name + "\", " + "\"" + this.team_name + "\", " + 
					"\"" + this.team_id + "\", " + 
					this.hitting_ab + ", " + this.hitting_rbi + ", " +
					this.pitching_era + ", " + this.pitching_onbase_h + ", " +
					this.pitching_onbase_s + ", " + this.pitching_onbase_d + ", " +
					this.pitching_onbase_t + ", " + this.pitching_onbase_hr + ", " +
					this.pitching_onbase_bb + ", " + this.pitching_runs_earned + ", " +
					this.pitching_runs_total + ", " + this.pitching_outs_ktotal + ", " +
					this.pitching_steal_caught + ", " + this.pitching_steal_stolen + ", " +
					this.pitching_games_play + ", " + this.pitching_games_win + ", " +
					this.pitching_games_loss + ", " + this.pitching_games_save + ", " +
					this.pitching_games_hold + ", " + this.hitting_onbase_h + ", " +
					this.hitting_onbase_s + ", " + this.hitting_onbase_d + ", " +
					this.hitting_onbase_t + ", " + this.hitting_onbase_hr + ", " +
					this.hitting_onbase_bb + ", " + this.hitting_runs_earned + ", " +
					this.hitting_runs_total + ", " + this.hitting_outs_ktotal + ", " +
					this.hitting_steal_caught + ", " + this.hitting_steal_stolen + ", " +
					this.hitting_games_play + ", " + this.hitting_games_win + ", " +
					this.hitting_games_loss + ", " + this.fielding_po + ", " +
					this.fielding_error + ", " + this.fielding_a + ", " +
					this.fielding_fpct + ", " + this.fielding_games_play + ", " +
					this.fielding_games_win + ", " + this.fielding_games_loss  +
					");";
	}
	/**
	  Method: 
	  Inputs: 
	  Returns:

	  Description:
	*/
	// Static Methods
	public static ArrayList<MlbPlayer> getListOfPlayersFromDatabase() {
		ArrayList<MlbPlayer> resultList = new ArrayList<MlbPlayer>();
		
		// Get the Result Set containing every Player
		ResultSet rs = Database.getResultSetFromSQL("SELECT * FROM " + TABLE_NAME);
		if (rs != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the ArrayList
			try {
				while(rs.next()){
					MlbPlayer player = new MlbPlayer(rs);
					resultList.add(player);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return resultList;
	}

	/**
	  Method: 
	  Inputs: 
	  Returns:

	  Description:
	*/
	/*
	 * getPlayersFromDatabase provides a user to search by one, a combination, or all parameters and
	 * 		return an ArrayList of MLB player names
	 */
	public static ArrayList<MlbPlayer> getPlayersFromDatabase(String id_in, String fName_in, String lName_in, String team_in) {
		ArrayList<MlbPlayer> resultList = new ArrayList<MlbPlayer>();
		
		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + genereateWhereClause(id_in, fName_in, lName_in, team_in) + " ORDER BY " + FIELD_TEAM_NAME + ", " + FIELD_FIRSTNAME + ", " + FIELD_LASTNAME;
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		if (rs != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the ArrayList
			try {
				while(rs.next()){
					MlbPlayer player = new MlbPlayer(rs);
					resultList.add(player);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
			}
		}
		
		// Clean up
		Database.close();
			
		return resultList;
	}

	private static String genereateWhereClause(String id_in, String fName_in, String lName_in, String team_in) {
		StringBuilder whereClause = new StringBuilder();
		
		// See if anything was passed in
		if (id_in != null || fName_in != null || lName_in != null || team_in != null) {
			Boolean fieldsAdded = false;
			
			// Initialize
			whereClause.append(" WHERE ");
			
			// Add the fields we need
			if (id_in != null) {
				whereClause.append(FIELD_ID + " = \"" + id_in + "\"");
				fieldsAdded = true;
			} 
			if (fName_in != null) {
				if (fieldsAdded) {
					whereClause.append(" AND ");
				}
				
				whereClause.append(FIELD_FIRSTNAME + " = \"" + fName_in + "\"");
				fieldsAdded = true;
			} 
			if (lName_in != null) {
				if (fieldsAdded) {
					whereClause.append(" AND ");
				}
				whereClause.append(FIELD_LASTNAME + " = \"" + lName_in + "\"");
				fieldsAdded = true;
			} 
			if (team_in != null) {
				if (fieldsAdded) {
					whereClause.append(" AND ");
				}
				
				whereClause.append(FIELD_TEAM_NAME + " = \"" + team_in + "\"");
				fieldsAdded = true;
			}
		}
		return whereClause.toString();
	}
	
	/**
	  Method: 
	  Inputs: 
	  Returns:

	  Description:
	*/
	public MlbPlayer(Node node) {
        // Initialize from XML Node
        loadDataFromNode(node);
    }
    
    private String getNodesNamedItem(Node node, String namedItem) {
        String returnVal = new String("0");
        
        // Check the attribute exists
        if (node.getAttributes().getNamedItem(namedItem) != null) {
            returnVal = node.getAttributes().getNamedItem(namedItem).getNodeValue();
        }
        return returnVal;
    }
    
    private float getNodesNamedFloat(Node node, String namedItem) {
    	float result = 0f;
    	
    	// Get the Value as a String first
    	String value = getNodesNamedItem(node, namedItem);
    	
    	// Validate it is in fact a float
    	try {
    		result = Float.parseFloat(value);
    	} catch (NumberFormatException e) {
    		result = 0f;
    	}
    	
    	return result;
    }
    
    private int getNodesNamedInt(Node node, String namedItem) {
    	int result = 0;
    	
    	// Get the Value as a String first
    	String value = getNodesNamedItem(node, namedItem);
    	
    	// Validate it is in fact a float
    	try {
    		result = Integer.parseInt(value);
    	} catch (NumberFormatException e) {
    		result = 0;
    	}
    	
    	return result;
    }
    
    private void loadPlayerData(Node node) {
        // Get "player" data
        id               = getNodesNamedItem(node, "id");
        first_name       = getNodesNamedItem(node, "first_name");
        last_name        = getNodesNamedItem(node, "last_name");
    }
    
    private void loadTeamData(Node node) {
        // Get "team" data
        team_id      = getNodesNamedItem(node, "id");
        team_name    = getNodesNamedItem(node, "name");
    }
    
    private void loadHittingData(Node node) {
        // Get the "hitting" data
        hitting_ab       = getNodesNamedInt(node, "ab");
        hitting_rbi      = getNodesNamedInt(node, "rbi");
    }
    
    private void loadPitchingData(Node node) {
        pitching_era    = getNodesNamedFloat(node, "era");
    }

	private void loadFieldingData(Node node) 
	{
		fielding_po 	= getNodesNamedInt(node, "po");
	    fielding_error 	= getNodesNamedInt(node, "error");
	    fielding_a 		= getNodesNamedInt(node, "a");
	    fielding_fpct	= getNodesNamedInt(node, "fpct");
	}
    
    private void loadOnbaseData(Node node, String parentNodeName) {
        // Load "onbase" data
    	if (parentNodeName.equals("hitting")) {
	        hitting_onbase_h     = getNodesNamedInt(node, "h");
	        hitting_onbase_s     = getNodesNamedInt(node, "s");
	        hitting_onbase_d     = getNodesNamedInt(node, "d");
	        hitting_onbase_t     = getNodesNamedInt(node, "t");
	        hitting_onbase_hr    = getNodesNamedInt(node, "hr");
	        hitting_onbase_bb    = getNodesNamedInt(node, "bb");
    	} else if (parentNodeName.equals("pitching")) {
	        pitching_onbase_h     = getNodesNamedInt(node, "h");
	        pitching_onbase_s     = getNodesNamedInt(node, "s");
	        pitching_onbase_d     = getNodesNamedInt(node, "d");
	        pitching_onbase_t     = getNodesNamedInt(node, "t");
	        pitching_onbase_hr    = getNodesNamedInt(node, "hr");
	        pitching_onbase_bb    = getNodesNamedInt(node, "bb");
    	}
    }
    
    private void loadRunsData(Node node, String parentNodeName) {
        // Load "runs" data
    	if (parentNodeName.equals("hitting")) {
	        hitting_runs_earned      = getNodesNamedInt(node, "earned");
	        hitting_runs_total       = getNodesNamedInt(node, "total");
    	} else if (parentNodeName.equals("pitching")) {
	        pitching_runs_earned      = getNodesNamedInt(node, "earned");
	        pitching_runs_total       = getNodesNamedInt(node, "total");
    	}
    }
    
    private void loadOutsData(Node node, String parentNodeName) {
        // Load "outs" data
    	if (parentNodeName.equals("hitting")) {
    		hitting_outs_ktotal  = getNodesNamedInt(node, "ktotal");
    	} else if (parentNodeName.equals("pitching")) {
    		pitching_outs_ktotal  = getNodesNamedInt(node, "ktotal");
    	}
    }
    
    private void loadStealData(Node node, String parentNodeName) {
        // Load "steal" data
    	if (parentNodeName.equals("hitting")) {
    		hitting_steal_caught = getNodesNamedInt(node, "caught");
    		hitting_steal_stolen = getNodesNamedInt(node, "stolen");
    	} else if (parentNodeName.equals("pitching")) {
    		pitching_steal_caught = getNodesNamedInt(node, "caught");
    		pitching_steal_stolen = getNodesNamedInt(node, "stolen");
    	}
    }
    
    private void loadGamesData(Node node, String parentNodeName) {
        // Load "games" data
    	if (parentNodeName.equals("hitting")) {
    		hitting_games_play       = getNodesNamedInt(node, "play");
    		hitting_games_win        = getNodesNamedInt(node, "win");
    		hitting_games_loss       = getNodesNamedInt(node, "loss");
    	} else if (parentNodeName.equals("pitching")) {
    		pitching_games_play       = getNodesNamedInt(node, "play");
    		pitching_games_win        = getNodesNamedInt(node, "win");
    		pitching_games_loss       = getNodesNamedInt(node, "loss");
    		pitching_games_save       = getNodesNamedInt(node, "save");
    		pitching_games_hold       = getNodesNamedInt(node, "hold");
		} else if (parentNodeName.equals("fielding")) {
			fielding_games_play       = getNodesNamedInt(node, "play");
    		fielding_games_win        = getNodesNamedInt(node, "win");
    		fielding_games_loss       = getNodesNamedInt(node, "loss");
		}
    }
    
    public static ArrayList<MlbPlayer> getStatisticsFromDatabase(String id_in) {
		ArrayList<MlbPlayer> resultList = new ArrayList<MlbPlayer>();
		
		// Get the Result Set containing every Player
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_ID + " = \"" + id_in.toString() + "\"" +
								" ORDER BY " + FIELD_ID;
		ResultSet resultSet = Database.getResultSetFromSQL(sql);
		
		if (resultSet != null) {
			// Loop through the Result Set and Add Each MlbPlayer to the ArrayList
			try {
				while(resultSet.next()){
					MlbPlayer player = new MlbPlayer(resultSet);
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
    
	/**
	  Method: 
	  Inputs: 
	  Returns:

	  Description:
	*/
    public void loadDataFromNode(Node node) {
        // Get "player" data
        loadPlayerData(node);
        
        NodeList child1Nodes = node.getChildNodes();
        for (int j = 0; j < child1Nodes.getLength(); j++) {
            Node teamNode = child1Nodes.item(j);
            if (teamNode instanceof Element) {
                // Get "team" data
                loadTeamData(teamNode);
                
                NodeList child2Nodes = teamNode.getChildNodes();
                for (int k = 0; k < child2Nodes.getLength(); k++) {
                    Node c1Node = child2Nodes.item(k);
                    if (c1Node instanceof Element) {
                    	String parentNodeName = null;

                        //Identifying the child tag
                        switch (c1Node.getNodeName()) {
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
                        
                        // Get Parent Node Lame
                        parentNodeName = c1Node.getNodeName();
                        
                        // Load the Node data
                        NodeList child3Nodes = c1Node.getChildNodes();
                        for (int l = 0; l < child3Nodes.getLength(); l++) {
                            Node c2Node = child3Nodes.item(l);
                            if (c2Node instanceof Element) {
                                //Identifying the child tag
                                switch (c2Node.getNodeName()) {
                                    case "onbase":
                                        loadOnbaseData(c2Node, parentNodeName);
                                        break;
                                    case "runs":
                                        loadRunsData(c2Node, parentNodeName);
                                        break;
                                    case "outs":
                                        loadOutsData(c2Node, parentNodeName);
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